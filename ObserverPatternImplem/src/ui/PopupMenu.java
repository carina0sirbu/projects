package ui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu {

	private JMenuItem delete;
	
	public PopupMenu() {
		
		delete = new JMenuItem("delete");
		this.add(delete);		
	}
	
	public void addDeleteListener(ActionListener e) {
		delete.addActionListener(e);
	}
}
