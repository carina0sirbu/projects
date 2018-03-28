package model;

public class Task implements Comparable {

	private int arrivalTime;
	private int processingTime;
	private int id;

	public Task(int arrivalTime, int processingTime) {

		this.arrivalTime = arrivalTime;
		this.processingTime = processingTime;
	}

	public void decrProcTime() {
		processingTime--;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	@Override
	public int compareTo(Object a) {

		if (a.equals(this))
			return 0;

		if (a == null)
			return 1;

		if (!(a instanceof Task))
			return 1;

		Task t = (Task) a;

		return this.arrivalTime - t.arrivalTime;
	}

	public String toString() {

		return "processing time: " + processingTime + ", arrival time: " + arrivalTime;

	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
