package model;

import java.util.List;

public class Customer {

	private int id;
	private String name;
	private int age;
	
	
	public Customer() {
		
	}
	
	public Customer (List<String> list) {
		
		this.id = Integer.parseInt(list.get(0));
		this.name = list.get(1);
		this.age = Integer.parseInt(list.get(2));
	}
	
	public Customer (int id, String name, int age) {
		
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	public String toString() {
		
		return id + " " + name + " " + age + " ";
	}
	
	public boolean equals(Object o) {
		
		if (this == o)   //compares pointers
			return true;
		
		if (o == null)
			return false;
		
		if (!(o instanceof Customer))
			return false;
		
		Customer c = (Customer)o;
		
		return this.name.equals(c.name) && this.age == c.age;
		
	}
	
	public String[] splitString() {
		
		return new String[] {Integer.toString(id), name, Integer.toString(age)};
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
