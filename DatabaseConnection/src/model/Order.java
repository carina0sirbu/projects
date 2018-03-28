package model;

import java.util.List;

public class Order {

	private int id;
	private int clients_id;
	private int product_id;
	private int totalul;

	public Order() {

	}
	
	public Order(List<String> list) {
		
		this.id = Integer.parseInt(list.get(0));
		this.clients_id = Integer.parseInt(list.get(1));
		this.product_id = Integer.parseInt(list.get(2));
		this.totalul = Integer.parseInt(list.get(3));
		
	}

	public Order(int id, int clients_id, int product_id) {

		this.id = id;
		this.clients_id = clients_id;
		this.product_id = product_id;
	}

	
	
	public boolean equals (Object o) {
		
		if (this == o) 
			return true;
		
		if (o == null)
			return false;
		
		if (!(o instanceof Order))
			return false;
		
		Order ord = (Order)o;
		
		return this.totalul == ord.totalul;
	}
	
	public String[] splitString() {
		
		return new String[] {Integer.toString(id), Integer.toString(clients_id), Integer.toString(product_id), Integer.toString(totalul)};
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClients_id() {
		return clients_id;
	}

	public void setClients_id(int clients_id) {
		this.clients_id = clients_id;
	}

	public int getTotalul() {
		return totalul;
	}

	public void setTotalul(int totalul) {
		this.totalul = totalul;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}
