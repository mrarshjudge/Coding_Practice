package com.practice.in.OOPS;


//Cloneable Interface Example
public class CloneableInterface {
	public static void main(String[]args) {
		Student e = new Student(101,"Arsh");
		try {
			Student e1 = (Student)e.clone();
			System.out.println(e1.toString());
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		System.out.println(e.toString());
		
	}

}


class Student implements Cloneable{
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	// Copy Constructor
	public Student(Student s) {
		super();
		this.id = s.id;
		this.name = s.name;
	}
	//Factory Method
	public static Student instanceOf(Student s) {
		return new Student(s.id,s.name);
	}	
	//Clone method
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
