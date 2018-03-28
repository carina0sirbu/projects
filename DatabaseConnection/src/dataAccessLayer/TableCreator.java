package dataAccessLayer;

import java.sql.Connection;
import java.sql.SQLException;

public class TableCreator {

	private Connection conn;
	private ConnectionFactory cf;
	
	public TableCreator() {

		cf = new ConnectionFactory();
	}

	public void createTable(String name) {

		String syntax = null;
		conn = cf.getConnection();
		
		if (name.equals("customers")) {
			syntax = "CREATE TABLE IF NOT EXISTS " + name
					+ " (id int unique not null, name varchar(255) not null, age int, primary key (id))";

		} else if (name.equals("orders")) {
			syntax = "CREATE TABLE IF NOT EXISTS " + name + " (id int unique not null, "
					+ "customer_id int, product_id int, totalul int, primary key (id), constraint FK_cons foreign key (customer_id) "
					+ "references customers(id))";
		
		} else if (name.equals("products")) {
			syntax = "CREATE TABLE IF NOT EXISTS " + name + " (id int unique not null, name varchar(255), price int, "
					+ "quantity int, primary key (id))";
			
		} else if (name.equals("orderedProducts")) {
			syntax = "CREATE TABLE IF NOT EXISTS " + name + " (product_id int not null, order_id int not null, "
					+ "quantity int, constraint cons1 foreign key (product_id) references products(id), constraint cons2 foreign key (order_id)"
					+ " references orders(id))";
		}
		System.out.println(syntax);
		try {
			conn.prepareStatement(syntax).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cf.closeConnection(conn);
	}
}
