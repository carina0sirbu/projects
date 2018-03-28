package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class FrameStack {

	private static List<JFrame> stack = new ArrayList<JFrame>();

	public static JFrame peek() {

		return stack.get(0);
	}

	public static void pop() {

		peek().setVisible(false);
		stack.remove(0);
		peek().setVisible(true);

	}

	public static void push(JFrame f) {

		if (!(stack.isEmpty()))
			peek().setVisible(false);

		stack.add(0, f);

	}
}
