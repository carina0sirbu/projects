package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import businessLogicLayer.CustomerBLL;
import model.Customer;

public class CustomerController {

	CustomerFrame c;

	public CustomerController(CustomerFrame c) {

		this.c = c;

		c.addAddCustomerListener(new AddCustomerListener());
		c.addDeleteCustomerListener(new DeleteCustomerListener());
		c.addUpdateCustomerListener(new UpdateCustomerListener());
		c.addBackCustomerListener(new BackCustomerListener());
	}

	public class AddCustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Customer customer = new Customer(Integer.parseInt(c.getId()), c.getName(), Integer.parseInt(c.getAge()));
			CustomerBLL customerB = new CustomerBLL();
			customerB.insert(customer);

		}

	}

	public class DeleteCustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Customer customer = new Customer(Integer.parseInt(c.getId()), c.getName(), Integer.parseInt(c.getAge()));
			CustomerBLL customerB = new CustomerBLL();
			customerB.delete(customer);
			
		}

	}

	public class UpdateCustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Customer customer = new Customer(Integer.parseInt(c.getId()), c.getName(), Integer.parseInt(c.getAge()));			
			CustomerBLL customerB = new CustomerBLL();
			List<String> list = new ArrayList<String>();
			list.add(c.getName());
			list.add(c.getAge());
			
			customerB.update(Integer.parseInt(c.getId()), list);

		}

	}

	public class BackCustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameStack.pop();
		}

	}

}
