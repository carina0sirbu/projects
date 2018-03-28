package model;

import ui.Controller;
import ui.FrameStack;
import ui.View;

public class Main {

	public static void main(String[] args) {
	
		View v = new View();
		new Controller(v);
		FrameStack.push(v);

	}

}
