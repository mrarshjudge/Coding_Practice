package com.practice.in.java8;

//Static and Default Methods in Interface
public class Static_Default_Methods_Interface implements Static_Default_Methods{
	public static void main(String[]args) {
		Static_Default_Methods.m();
		Static_Default_Methods_Interface sb = new Static_Default_Methods_Interface();
		System.out.println(sb.provideConfig("MySql"));
		
		Static_Default_Methods sm = new Static_Default_Methods_Interface();
		System.out.println(sm.provideConfig("MySql"));
		Static_Default_Methods defaultImpl = new Static_Default_Methods() {};
		System.out.println(defaultImpl.provideConfig("MySql"));

	}
	
	@Override
	public String provideConfig(String ab) {
		return "Class Method";
	}
}

interface Static_Default_Methods {
	int value = 15;
	String owner = "Arsh";
	
	
	
	  public static void m() { 
		  System.out.println(value);
		  System.out.println("Am the owner "+owner);
	  
	  }
	 
	
	default String provideConfig(String DB) {
		if(DB.equals("MySql"))
			return "http://localhost:8081:user:password";
		if(DB.equals("MS-SQL"))
			return "http://locahost:8081:msSQL:user:password";
		return "DB not Available";
	}

}

