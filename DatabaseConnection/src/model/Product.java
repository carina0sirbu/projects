package model;

import java.util.List;

public class Product {

	private int id;
	private String name;
	private int price;
	private int quantity;

	public Product() {

	}
	
	public Product(List<String> list) {
		
		this.id = Integer.parseInt(list.get(0));
		this.name = list.get(1);
		this.price = Integer.parseInt(list.get(2));
		this.quantity = Integer.parseInt(list.get(3));
	}

	public Product(int id, String name, int price, int quantity) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	
	public boolean equals(Object o) {
		
		if (this == o) 
			return true;
		
		if (o == null)
			return false;
		
		if (!(o instanceof Product))
			return false;
		
		Product p = (Product)o;
		
		return this.name.equals(p.name) && this.price == p.price;
	}
	
	public String[] splitString() {
		
		return new String[] {Integer.toString(id), name, Integer.toString(price), Integer.toString(quantity)};
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
