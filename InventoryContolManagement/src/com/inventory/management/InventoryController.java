package com.inventory.management;

import java.util.Scanner;
import java.util.Map.Entry;

public class InventoryController {

	public static void main(String[] args) {
		
		//to Load from CSV
		//

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println(
					"Please enter the operation to be performed and values required or done to exit operation");

			String line = scanner.nextLine();

			if (line.equals("done")) {
				System.exit(0);
			}

			String[] operation = line.split(" ");

			if (operation[0].equals("create")) {

				Inventory item = new Inventory(operation[1], Double.parseDouble(operation[2]),
						Double.parseDouble(operation[3]));

				InventoryOperations.setItems(operation[1], item);

			} else if (operation[0].equals("updateBuy")) {

				InventoryOperations.updateQuantity(operation[1], Integer.parseInt(operation[2]));

			} else if (operation[0].equals("updateSell")) {

				InventoryOperations.updateQuantity(operation[1], -Integer.parseInt(operation[2]));

			} else if (operation[0].equals("report")) {

				double totalValue = 0;
				double profit = InventoryOperations.profitOnselling - InventoryOperations.lossOnDeleting;

				System.out.println("                      INVENTORY REPORT                      ");
				System.out.println("Item Name \tBought At \tSold At \tAvailableQty \tValue");
				System.out.println("-----------------------------------------------------------------------------");
				for (Entry<String, Inventory> entry : InventoryOperations.items.entrySet()) {

					Inventory item = entry.getValue();

					System.out.println(item.getItemName() + "\t\t" + item.getBoughtAt() + "\t\t" + item.getSoldAt()
							+ "\t\t" + item.getAvailableQty() + "\t\t" + item.getTotalValue());
					totalValue += item.getTotalValue();

				}
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Total Value \t\t\t\t\t\t\t" + Math.round(totalValue*100.0)/100.0);
				System.out.println("Profit since previous report \t\t\t\t\t" + Math.round(profit*100.0)/100.0);

			}
		}
	}

}
