package com.inventory.management;

import java.util.Map;
import java.util.TreeMap;

public class InventoryOperations {

	static double profitOnselling = 0, lossOnDeleting = 0;

	static Map<String, Inventory> items = new TreeMap<String, Inventory>();

	public static Map<String, Inventory> getItems() {
		return items;
	}

	public static Inventory getItem(String itemName) {

		return items.get(itemName);
	}

	public static void deleteItem(String itemName) {

		lossOnDeleting += items.get(itemName).getAvailableQty() * items.get(itemName).getBoughtAt();

		items.remove(itemName);
	}

	public static void setItems(String itemName, Inventory item) {
		items.put(itemName, item);
	}

	public static void updateQuantity(String itemName, int quantity) {
		
		Inventory obj = items.get(itemName);
		
		int total = obj.getAvailableQty() + quantity;
		obj.setAvailableQty(total);
		obj.setTotalValue(total*obj.getBoughtAt());
		if(quantity < 0) {
			
			profitOnselling += (obj.getSoldAt()-obj.getBoughtAt())*(-quantity); 
		}
	}
}
