package state;

public interface VendingMachineState {
    void selectItem(VendingMachine machine, String itemName);
    void insertCoin(VendingMachine machine, double amount);
    void dispenseItem(VendingMachine machine);
    void setOutOfOrder(VendingMachine machine);
}
