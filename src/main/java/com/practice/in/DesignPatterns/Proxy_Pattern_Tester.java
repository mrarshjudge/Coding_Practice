package com.practice.in.DesignPatterns;

public class Proxy_Pattern_Tester {
	public static void main(String[]args) {
		ReaderWriterClass readerWriterObject = new ReaderWriterClass(Role.MANAGER);
		Controller controller = new AuthProxy(readerWriterObject);
		System.out.println(controller.writeData("Data is here"));
		System.out.println(controller.readData());
		
		ReaderWriterClass readerWriterObject2 = new ReaderWriterClass(Role.VENDOR);
		Controller controller2 = new AuthProxy(readerWriterObject2);
		System.out.println(controller2.writeData("Data is here"));
		System.out.println(controller2.readData());
		
		ReaderWriterClass readerWriterObject3 = new ReaderWriterClass(Role.EMPLOYEE);
		Controller controller3 = new AuthProxy(readerWriterObject3);
		System.out.println(controller3.writeData("Data is here"));
		System.out.println(controller3.readData());
		
	}
}

interface Controller{
	boolean authentication();
	boolean writeData(String data);
	String readData();
}
enum Role{
	MANAGER,EMPLOYEE,HR,VENDOR,CLIENT;
}

class ReaderWriterClass implements Controller{
	String data;
	Role role;
	
	ReaderWriterClass(Role role){
		this.role = role;
	}
	
	@Override
	public boolean writeData(String data) {
		this.data = data;
		return true;

	}
	@Override
	public String readData() {
		return this.data;
	}
	@Override
	public boolean authentication() {
		return false;
		
	}
	
	public Role getRole() {
		return this.role; 
	}
}

class AuthProxy implements Controller{
	private ReaderWriterClass obj;
	
	public AuthProxy(ReaderWriterClass obj) {
		this.obj = obj;
	}
	
	@Override
	public boolean authentication() {
		
		switch (obj.getRole()) {
		case MANAGER:return true;
		case VENDOR:return true;
		default: return false;
		}
	}

	@Override
	public boolean writeData(String data) {
		if(authentication()) {
			return obj.writeData(data);
		}else {
			System.out.println("User not authenticated");
			return false;
		}
	}

	@Override
	public String readData() {
		if(authentication())
			return obj.readData();
		return "User not authenticated. You dont have permission to read!!!";
	}
	
}