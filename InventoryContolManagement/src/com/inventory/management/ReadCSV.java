package com.inventory.management;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {

	public static void readItems() {

		String csvFile = "Inventory.csv";
		BufferedReader br = null;
		String line = "";
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] itemDetails = line.split(",");

				Inventory item = new Inventory(itemDetails[0].toString(), Double.parseDouble(itemDetails[1]),
						Double.parseDouble(itemDetails[2]));

				InventoryOperations.setItems(item.getItemName(), item);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		readItems();
		
	}

}