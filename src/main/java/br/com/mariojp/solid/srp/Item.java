package br.com.mariojp.solid.srp;

public class Item {
	
	
	private String name;
	private double unitPrice; 
	private int quantity;
	
	public Item(String name, double unitPrice, int quantity) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
