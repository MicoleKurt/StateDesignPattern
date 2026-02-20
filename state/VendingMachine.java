package state;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private VendingMachineState state;
    private String selectedItem;
    private double balance;
    private Map<String, Integer> inventory;
    private Map<String, Double> priceList;
    
    public VendingMachine() {
        this.state = new IdleState();
        this.selectedItem = null;
        this.balance = 0;
        this.inventory = new HashMap<>();
        this.priceList = new HashMap<>();
        initializeInventory();
    }
    
    private void initializeInventory() {
        inventory.put("Soda", 10);
        inventory.put("Chips", 15);
        inventory.put("Candy", 20);
        inventory.put("Water", 8);
        
        priceList.put("Soda", 1.50);
        priceList.put("Chips", 1.00);
        priceList.put("Candy", 0.75);
        priceList.put("Water", 0.50);
    }
    
    public void selectItem(String itemName) {
        state.selectItem(this, itemName);
    }
    
    public void insertCoin(double amount) {
        state.insertCoin(this, amount);
    }
    
    public void dispenseItem() {
        state.dispenseItem(this);
    }
    
    public void setOutOfOrder() {
        state.setOutOfOrder(this);
    }
    
    public VendingMachineState getState() {
        return state;
    }
    
    public void setState(VendingMachineState state) {
        this.state = state;
    }
    
    public void setSelectedItem(String itemName) {
        this.selectedItem = itemName;
    }
    
    public String getSelectedItem() {
        return selectedItem;
    }
    
    public void addBalance(double amount) {
        this.balance += amount;
    }
    
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getItemPrice(String itemName) {
        return priceList.getOrDefault(itemName, 0.0);
    }
    
    public boolean hasInventory(String itemName) {
        return inventory.getOrDefault(itemName, 0) > 0;
    }
    
    public void removeFromInventory(String itemName) {
        if (inventory.containsKey(itemName)) {
            inventory.put(itemName, inventory.get(itemName) - 1);
        }
    }
    
    public int getInventoryCount(String itemName) {
        return inventory.getOrDefault(itemName, 0);
    }
    
    public Map<String, Integer> getInventory() {
        return inventory;
    }
    
    public Map<String, Double> getPriceList() {
        return priceList;
    }
    
    public void displayStatus() {
        System.out.println("\n========== VENDING MACHINE STATUS ==========");
        System.out.println("Current State: " + state.toString());
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("Selected Item: " + (selectedItem != null ? selectedItem : "None"));
        System.out.println("\n--- Inventory ---");
        for (String item : inventory.keySet()) {
            int count = inventory.get(item);
            double price = priceList.get(item);
            System.out.println(item + ": " + count + " units @ $" + String.format("%.2f", price));
        }
        System.out.println("==========================================\n");
    }
}
