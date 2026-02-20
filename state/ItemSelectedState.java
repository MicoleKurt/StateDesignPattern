package state;

public class ItemSelectedState implements VendingMachineState {
    
    @Override
    public void selectItem(VendingMachine machine, String itemName) {
        System.out.println("Cannot select another item. Please complete the current transaction first.");
    }
    
    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Coin of $" + amount + " inserted. Current balance: $" + (machine.getBalance() + amount));
        machine.addBalance(amount);
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        String selectedItem = machine.getSelectedItem();
        double itemPrice = machine.getItemPrice(selectedItem);
        
        if (selectedItem == null || selectedItem.isEmpty()) {
            System.out.println("No item selected for dispensing.");
            return;
        }
        
        if (machine.getBalance() < itemPrice) {
            System.out.println("Insufficient balance. Item costs $" + itemPrice + " but balance is $" + machine.getBalance());
            return;
        }
        
        if (!machine.hasInventory(selectedItem)) {
            System.out.println("Item '" + selectedItem + "' is out of stock.");
            return;
        }
        
        System.out.println("Dispensing item '" + selectedItem + "'...");
        machine.setState(new DispensingState());
        machine.getState().dispenseItem(machine);
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now Out of Order. Please collect your coins.");
        machine.setState(new OutOfOrderState());
    }
    
    @Override
    public String toString() {
        return "ItemSelected";
    }
}
