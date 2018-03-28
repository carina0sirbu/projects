package ui;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JTable;

public class TableFiller {

	public JTable createTable(List o) {

		if (o.isEmpty())
			return null;

		Class c = o.get(0).getClass();
		Field[] f = c.getDeclaredFields();
		String[] s = new String[f.length];

		for (int i = 0; i < f.length; i++) {

			s[i] = f[i].getName();
		}

		try {

			String[][] matrix = new String[o.size()][f.length];

			for (int i = 0; i < o.size(); i++) {

				for (int j = 0; j < f.length; j++) {
					
					f[j].setAccessible(true);
					matrix[i][j] = f[j].get(o.get(i)).toString();
					
				}
			}

			return new JTable(matrix, s);

		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

}
