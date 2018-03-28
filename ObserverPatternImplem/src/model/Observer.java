package model;

public interface Observer {
	
	public void update(Observable o, String sort, int oldSum, int currentSum);

}
