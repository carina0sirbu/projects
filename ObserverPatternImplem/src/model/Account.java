package model;

import java.io.Serializable;
import java.util.UUID;

public abstract class Account implements Serializable, Observable {

	protected String id;
	protected int sum;
	protected Observer observer;

	public Account(int sum) {

		this.id = UUID.randomUUID().toString();
		this.sum = sum;
	}

	public String toString() {

		return id;
	}

	@Override
	public void addObserver(Observer o) {
		
		this.observer = o;
	}

	@Override
	public void deleteObsever() {
		
		this.observer = null;
	}

	@Override
	public void notifyObserver(int oldSum, int currentSum, String sort) {
		
		observer.update(this, sort, oldSum, currentSum);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
