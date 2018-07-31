package com.inventory.management;

public class Inventory {

	String itemName;
	double boughtAt;
	double soldAt;
	int availableQty;
	double totalValue;

	public Inventory(String itemName, double boughtAt, double soldAt) {
		this.itemName = itemName;
		this.boughtAt = boughtAt;
		this.soldAt = soldAt;
		this.availableQty = 0;
		this.totalValue = 0;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getBoughtAt() {
		return boughtAt;
	}

	public void setBoughtAt(double boughtAt) {
		this.boughtAt = boughtAt;
	}

	public double getSoldAt() {
		return soldAt;
	}

	public void setSoldAt(double soldAt) {
		this.soldAt = soldAt;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
