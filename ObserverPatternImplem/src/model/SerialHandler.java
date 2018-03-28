package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialHandler {
	
	public void writeObject(Object o) {
		
		File f = new File("bank.ser");
		
		try {
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(o);
			objOut.close();
			fileOut.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object readObject() {		
		
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			o = objIn.readObject();
			objIn.close();
			fileIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return o;
	}

}
