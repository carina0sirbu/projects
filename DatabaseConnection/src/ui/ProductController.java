package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import businessLogicLayer.ProductBLL;
import model.Product;

public class ProductController {

	ProductFrame p;
	
	public ProductController(ProductFrame p) {
		
		this.p = p;
		
		p.addAddProductListener(new AddProductListener());
		p.addDeleteProductListener(new DeleteProductListener());
		p.addBackProductListener(new BackProductListener());
	}

	public class AddProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Product product = new Product(Integer.parseInt(p.getId()), p.getName(), Integer.parseInt(p.getPrice()), Integer.parseInt(p.getQuantity()));
			ProductBLL productB = new ProductBLL();
			
			productB.insert(product);

		}

	}
	
	public class DeleteProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Product product = new Product(Integer.parseInt(p.getId()), p.getName(), Integer.parseInt(p.getPrice()), Integer.parseInt(p.getQuantity()));
			ProductBLL productB = new ProductBLL();
			
			productB.delete(product);
			
		}
		
	}
	
	public class BackProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FrameStack.pop();
		}
		
	}

}
