package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogicLayer.CustomerBLL;
import businessLogicLayer.OrderBLL;
import businessLogicLayer.ProductBLL;

public class Controller {

	private View v;
	
	public Controller(View v) {
		
		this.v = v;
		
		v.addOrderListener(new OrderListener());
		v.addCustomerListener(new CustomerListener());
		v.addProductListener(new ProductListener());

	}
	
	private class OrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			TableFiller t = new TableFiller();
			OrderFrame o = new OrderFrame(t.createTable((new OrderBLL()).getList()));
			FrameStack.push(o);
			
			OrderController oc = new OrderController(o);
			
		}
		
	}
	
	private class CustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			TableFiller t = new TableFiller();
			CustomerFrame c = new CustomerFrame(t.createTable((new CustomerBLL()).getList()));
			FrameStack.push(c);
			
			CustomerController cc = new CustomerController(c);
		}
		
	}
	
	private class ProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			TableFiller t = new TableFiller();
			ProductFrame p = new ProductFrame(t.createTable((new ProductBLL()).getList()));
			FrameStack.push(p);
			
			ProductController pc = new ProductController(p);
			
		}
		
	}
	
}
