package businessLogicLayer;

import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.PrepStatement;
import model.Order;
import model.OrderedProduct;
import model.Product;

public class OrderBLL implements BLLInterface {

	public void insert(Order o, int prodId, int quantity) {

		PrepStatement ps = new PrepStatement();
		Product product = (Product)ps.findById(prodId, Product.class);
		
		if (product.getQuantity() < quantity) {
			System.out.println("Not enough stock :(");
			return;
		}
		
		o.setTotalul(product.getPrice() * quantity);
		ps.insert(o);

		OrderedProduct op = new OrderedProduct(prodId, o.getId(), quantity);
		ps.insert(op);
		
		ProductBLL prod = new ProductBLL();
		prod.updateStock(prodId, product.getQuantity() - quantity);

	}
	
	public List<Order> getList() {
		
		PrepStatement ps = new PrepStatement();
		return (List<Order>) ps.selectAll(Order.class);
	}

}
