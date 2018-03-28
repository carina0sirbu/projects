package model;

public interface Observable {
	
	public void addObserver(Observer o);
	
	public void deleteObsever();
	
	public void notifyObserver(int oldSum, int currentSum, String sort);

}
