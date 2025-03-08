// Grocery Store Inventory Fix
// During the holiday rush, Rahul, a grocery store manager, accidentally miscounted stock records, 
// mixing unique and duplicate items in the inventory.

// The store follows a simple rule to fix errors:
// • Keeping unique items unchanged
// • Removing original duplicates and restocking them in double quantity

// Help Rahul correct the inventory by identifying unique and duplicate items, applying the rule, and printing the final stock list.

// Your task is to:
// • Identify unique and duplicate items in the inventory.
// • Remove the original duplicate entries.
// • Restock duplicates in double quantity.
// • Print the corrected Final Inventory and Duplicate Items list.

// Sample Test Case:
// Sample Input:
// 8 9 8 9 10 8
// Expected Output:
// Final Inventory: [10, 16, 18]
// Duplicate Items: [8, 9]


import java.util.*;

public class Grocery_Store {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inventory = new ArrayList<>();
        
        // Taking 6 inputs
        for (int i = 0; i < 6; i++) {
            inventory.add(sc.nextInt());
        }
        
        Set<Integer> seenItems = new HashSet<>();
        Set<Integer> duplicateItems = new HashSet<>();
        ArrayList<Integer> finalInventory = new ArrayList<>();
        
        // Identify unique and duplicate items
        for (int item : inventory) {
            if (!seenItems.add(item)) {
                duplicateItems.add(item);   // Mark it as duplicate 
            }
        }
        
        // Process the final inventory
        for (int item : seenItems) {
            if (!duplicateItems.contains(item)) {
                finalInventory.add(item);   // Keep unique items unchanged
            }
        }
        
        // Replace duplicates with doubled values
        for (int item : duplicateItems) {
            finalInventory.add(item * 2);
        }
        
        // Print results
        System.out.println("Final Inventory: " + finalInventory);
        System.out.println("Duplicate Items: " + duplicateItems);
    }
}
