package com.practice.in.OOPS;

//Enum Usage in a Switch Case
//Enums are immutable
public class EnumSwitch {
	
	public static void main(String[]args) {
		checkValue(Day.SUNDAY);
		
		HttpStatus[] allStatus = HttpStatus.values();
		for(HttpStatus status : allStatus)
			System.out.println(status+": "+status.getCode()+" "+status.getStatus());
		Config c = Config.INSTANCE;
		System.out.println(c.getConfig());
		Config c1 = Config.INSTANCE;
		c1.setConfig("Local");
	
		
	}
	public static void checkValue(Day d) {
		switch(d) {
		case SUNDAY:
			System.out.println("Found yo Sunday");
			break;
		case MONDAY:
			System.out.println("Found");
			break;
		case TUESDAY:
			System.out.println("Not");
			break;
		case THURSDAY:
			System.out.println("YOYO");
			break;
		default:
			System.out.println("No means NO");
		}
		
	}
}

enum Day{
	MONDAY,TUESDAY,THURSDAY,SATURDAY,SUNDAY
}






// ENUM with fields and constructor and getter Setter

enum HttpStatus{
	
	NOT_FOUND(400,"Bad Request"), OK(200,"Success"),INTERNAL_ERROR(500,"Internal server Error");
	private final String status;
	private final int code;
	
	
	HttpStatus(int code,String status){
		this.code = code;
		this.status = status;
	}
	
	public int getCode() {
		return this.code;
	}
	public String getStatus() {
		return this.status;
	}
	
}


// Enum to achieve Singelton Pattern

enum Config{
	INSTANCE;
	private   String config = "default";
	
	public String getConfig() {
		return this.config;
	} 
	public void setConfig(String config) {
		this.config = config;
	}
	
		
}
