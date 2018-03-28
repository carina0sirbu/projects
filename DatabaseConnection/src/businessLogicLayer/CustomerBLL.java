package businessLogicLayer;

import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.PrepStatement;
import model.Customer;

public class CustomerBLL implements BLLInterface {

	public void insert(Customer c) {

		if (validate(c)) {
			PrepStatement ps = new PrepStatement();
			ps.insert(c);
		}

	}

	public void delete(Customer c) {

		PrepStatement ps = new PrepStatement();
		ps.delete(c.getId(), Customer.class);

	}

	public void update(int id, List<String> newValues) {

		PrepStatement ps = new PrepStatement();
		ps.update(id, Customer.class, new String[] { "name", "age" }, newValues.toArray());

	}

	private boolean validate(Customer c) {

		PrepStatement ps = new PrepStatement();
		for (Object o : ps.selectAll(Customer.class)) {
			if (((Customer) o).equals(c)) {
				return false;
			}

		}
		return true;
	}

	public List<Customer> getList() {

		PrepStatement ps = new PrepStatement();
		return (List<Customer>) ps.selectAll(Customer.class);
	}

}
