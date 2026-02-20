package state;

public class DispensingState implements VendingMachineState {
    
    @Override
    public void selectItem(VendingMachine machine, String itemName) {
        System.out.println("Cannot select item while dispensing. Please wait...");
    }
    
    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Cannot insert coin while dispensing. Please wait...");
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        String selectedItem = machine.getSelectedItem();
        double itemPrice = machine.getItemPrice(selectedItem);
        
        System.out.println("Item '" + selectedItem + "' has been dispensed successfully.");
        machine.removeFromInventory(selectedItem);
        double change = machine.getBalance() - itemPrice;
        machine.deductBalance(itemPrice);
        
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        }
        
        System.out.println("Machine returning to Idle state...");
        machine.setSelectedItem(null);
        machine.setBalance(0);
        machine.setState(new IdleState());
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Cannot set Out of Order while dispensing. Please wait...");
    }
    
    @Override
    public String toString() {
        return "Dispensing";
    }
}
