package state;

public class IdleState implements VendingMachineState {
    
    @Override
    public void selectItem(VendingMachine machine, String itemName) {
        System.out.println("Item '" + itemName + "' selected. Machine is now in ItemSelected state.");
        machine.setSelectedItem(itemName);
        machine.setState(new ItemSelectedState());
    }
    
    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Cannot insert coin in Idle state. Please select an item first.");
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Cannot dispense item in Idle state. Please select an item first.");
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now Out of Order.");
        machine.setState(new OutOfOrderState());
    }
    
    @Override
    public String toString() {
        return "Idle";
    }
}
