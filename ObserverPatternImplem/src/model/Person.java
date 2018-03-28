package model;

import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable, Observer {

	private String ssn; // social security number
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {

		this.ssn = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {

		return firstName + " " + lastName;
	}

	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (o == null) {
			return false;
		}

		if (!(o instanceof Person)) {
			return false;
		}

		Person pers = (Person) o;

		return this.firstName.equals(pers.firstName) && this.lastName.equals(pers.lastName);
	}

	public int hashCode() {

		return firstName.hashCode() * lastName.hashCode();
	}

	@Override
	public void update(Observable o, String sort, int oldSum, int currentSum) {

		if (sort.equals("withdraw")) {
			System.out.println(this.toString() + ", your account " + o + " has been updated. You have withdrawn "
					+ Integer.toString(oldSum - currentSum) + " euro. Your current balance is " + currentSum + " euro.");
		}
		
		else if (sort.equals("deposit")) {
			System.out.println(this.toString() + ", you have deposited " + Integer.toString(currentSum - oldSum) 
					+ " euro to your account " + o + ". Your current balance is " + currentSum + " euro.");
		}
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
