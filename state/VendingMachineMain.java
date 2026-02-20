package state;

public class VendingMachineMain {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  State Pattern - Vending Machine");
        System.out.println("  Author: Micole Kurt Gonda");
        System.out.println("  Lab Assignment");
        System.out.println("========================================\n");
        
        VendingMachine machine = new VendingMachine();
        machine.displayStatus();
        
        System.out.println("--- Scenario 1: Valid Transaction ---");
        machine.selectItem("Soda");
        machine.insertCoin(1.50);
        machine.dispenseItem();
        machine.displayStatus();
        
        System.out.println("--- Scenario 2: Select Item in Idle State ---");
        machine.selectItem("Chips");
        machine.displayStatus();
        
        System.out.println("--- Scenario 3: Try to Select Another Item ---");
        machine.selectItem("Candy");
        
        System.out.println("\n--- Scenario 4: Complete Transaction ---");
        machine.insertCoin(1.00);
        machine.dispenseItem();
        machine.displayStatus();
        
        System.out.println("--- Scenario 5: Insufficient Funds ---");
        machine.selectItem("Water");
        machine.insertCoin(0.25);
        machine.dispenseItem();
        System.out.println("Inserting more coins...");
        machine.insertCoin(0.25);
        machine.dispenseItem();
        machine.displayStatus();
        
        System.out.println("--- Scenario 6: Out of Stock Item ---");
        System.out.println("Attempting to dispense Candy (which is out of stock)...");
        machine.selectItem("Candy");
        machine.insertCoin(0.75);
        machine.dispenseItem();
        machine.displayStatus();
        
        System.out.println("--- Scenario 7: Machine Out of Order ---");
        machine.selectItem("Soda");
        machine.setOutOfOrder();
        System.out.println("Trying to insert coin while out of order...");
        machine.insertCoin(1.50);
        System.out.println("Trying to dispense while out of order...");
        machine.dispenseItem();
        machine.displayStatus();
        
        System.out.println("--- Scenario 8: Operations in Idle State ---");
        VendingMachine machine2 = new VendingMachine();
        System.out.println("Trying to insert coin without selecting item...");
        machine2.insertCoin(1.00);
        System.out.println("Trying to dispense without selecting item...");
        machine2.dispenseItem();
        machine2.displayStatus();
        
        System.out.println("\n========================================");
        System.out.println("  State Pattern Demonstration Complete");
        System.out.println("========================================");
    }
}
