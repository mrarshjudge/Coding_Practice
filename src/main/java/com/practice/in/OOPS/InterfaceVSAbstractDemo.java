package com.practice.in.OOPS;

//Interface vs Abstract Class Demo
public class InterfaceVSAbstractDemo extends RSDCollege {

	@Override
	public String getCollegeSIN() {
		return "UIB123";
	}
	@Override
	public String getAddress() {
		return "V1";
	}
	public static void main(String[]args) {
		RSDCollege rsd = new InterfaceVSAbstractDemo();
		System.out.println(rsd.getAddress());
		System.out.println(rsd.getName());
		System.out.println(rsd.getCollegeSIN());
		System.out.println(rsd.getStatus());
		System.out.println(College.getNoDepartment());
	}
	
}

interface College{
	String name="RSD";
	int department=12;
	
	default String getName() {
		return name;
	}
	static int getNoDepartment() {
		return department;
	}
	public String getAddress();
}

abstract class RSDCollege implements College{

	String collegeSIN;
	String status;
	
	public abstract String getCollegeSIN();
	public String getStatus() {
		return "Working";
	}
	

}
