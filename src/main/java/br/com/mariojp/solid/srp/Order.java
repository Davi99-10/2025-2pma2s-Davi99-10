package br.com.mariojp.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	
	private final List<Item> items = new ArrayList<>();

	public void add(Item i) {
		items.add(i);
	}

	public List<Item> getItems() {
		return items;
	}
	
	
}
