package model;

public class OrderedProduct {

	private int orders_id;
	private int products_id;
	private int quantity;

	public OrderedProduct() {

	}

	public OrderedProduct(int orders_id, int products_id, int quantity) {

		this.orders_id = orders_id;
		this.products_id = products_id;
		this.quantity = quantity;
	}

	
	public boolean equals (Object o) {
		
		if (this == o)
			return true;
		
		if (o == null) 
			return false;
		
		if (!(o instanceof OrderedProduct))
			return false;
		
		OrderedProduct op = (OrderedProduct)o;
		
		return this.orders_id == op.orders_id && this.products_id == op.products_id && this.quantity == op.quantity;
	}	
	

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getProducts_id() {
		return products_id;
	}

	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
