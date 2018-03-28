package businessLogicLayer;

import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.PrepStatement;
import model.Product;

public class ProductBLL implements BLLInterface {

	public void insert(Product p) {

		PrepStatement ps = new PrepStatement();
		Product prod = validate(p);

		if (prod == null) {

			ps.insert(p);
		} else {

			this.updateStock(prod.getId(), prod.getQuantity() + p.getQuantity());
		}
	}

	public void updateStock(int id, int newQuantity) {

		PrepStatement ps = new PrepStatement();

		ps.update(id, Product.class, new String[] { "quantity" }, new Integer[] { newQuantity });

	}

	public void delete(Product p) {

		PrepStatement ps = new PrepStatement();
		ps.delete(p.getId(), Product.class);

	}

	private Product validate(Product p) {
		
		PrepStatement ps = new PrepStatement();
		for (Object o: ps.selectAll(Product.class)) {
			if (((Product)o).equals(p)) {
				return (Product)o;
			}
		}
		return null;
	}
	
	public List<Product> getList() {
		
		PrepStatement ps = new PrepStatement();
		return (List<Product>) ps.selectAll(Product.class);
	}
	
	
	
	
}
