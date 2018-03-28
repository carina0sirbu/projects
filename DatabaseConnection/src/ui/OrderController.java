package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogicLayer.OrderBLL;
import model.Order;

public class OrderController {

	OrderFrame o;
	
	public OrderController(OrderFrame o) {
		
		this.o = o;
		
		o.addAddOrderListener(new AddOrderListener());
		o.addBackOrderListener(new BackOrderListener());
	}
	
	public class AddOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Order order = new Order(Integer.parseInt(o.getId()), Integer.parseInt(o.getClints_id()), Integer.parseInt(o.getProduct_id()));
			
			OrderBLL orderB = new OrderBLL();
			
			
			orderB.insert(order, Integer.parseInt(o.getProduct_id()), Integer.parseInt(o.getQuantity()));
		}
		
	}
	
	public class BackOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FrameStack.pop();
			
		}
		
	}
}
