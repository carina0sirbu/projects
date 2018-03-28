package dataAccessLayer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrepStatement {

	private Connection conn;
	private ConnectionFactory cf;

	public PrepStatement() {

		cf = new ConnectionFactory();

	}

	public void insert(Object o) {

		conn = cf.getConnection();
		try {

			Field[] f = o.getClass().getDeclaredFields();
			String s = new String();

			for (Field field : f) {
				field.setAccessible(true);
				s = s + "'" + field.get(o).toString() + "', ";
			}
			
			s = s.substring(0, s.length() - 2);

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO " + o.getClass().getSimpleName() + "s VALUES (" + s + ")");
			System.out.println(ps.toString());
			ps.executeUpdate();
			ps.close();

		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | SQLException e) {
			e.printStackTrace();
		}
		cf.closeConnection(conn);
	}

	public void delete(int id, Class<?> c) {

		conn = cf.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM " + c.getSimpleName() + "s WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		cf.closeConnection(conn);
	}

	public void update(int id, Class<?> c, String[] column, Object[] newValues) {

		conn = cf.getConnection();

		String s = "UPDATE " + c.getSimpleName() + "s SET ";

		for (int i = 0; i < column.length; i++) {
			s = s + column[i] + " = '" + newValues[i] + "', ";
		}
		s = s.substring(0, s.length() - 2);

		s = s + " WHERE id = " + id;

		System.out.println(s);

		try {

			PreparedStatement ps = conn.prepareStatement(s);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		cf.closeConnection(conn);
	}

	public Object findById(int id, Class<?> c) {

		conn = cf.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + c.getSimpleName() + "s WHERE id = " + id);
			ResultSet res = ps.executeQuery();
			res.next();

			List<String> list = new ArrayList<String>();
			for (int i = 0; i < c.getDeclaredFields().length; i++) {

				list.add(i, res.getString(i + 1));

			}
			Constructor<?> cons = c.getDeclaredConstructor(List.class);

			res.close();
			ps.close();

			cf.closeConnection(conn);
			return cons.newInstance(list);

		} catch (SQLException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		cf.closeConnection(conn);

		return null;
	}

	public List selectAll(Class c) {

		conn = cf.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + c.getSimpleName() + "s");
			ResultSet res = ps.executeQuery();

			List<Object> tableRows = new ArrayList<Object>();
			Constructor con = c.getDeclaredConstructor(List.class);

			while (res.next()) {

				List<String> row = new ArrayList<String>();
				for (int i = 0; i < c.getDeclaredFields().length; i++) {

					row.add(res.getString(i + 1));
				}

				tableRows.add(con.newInstance(row));
			}
			res.close();
			ps.close();

			cf.closeConnection(conn);
			return tableRows;

		} catch (SQLException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		cf.closeConnection(conn);
		return null;
	}

}
