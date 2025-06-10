package com.practice.in.DesignPatterns;

//Factory Pattern for Notification Services
public class Factory_Pattern_Tester {
	public static void main(String[]args) {
		NotificationFactory.sendNotification("SMS");
		NotificationFactory.sendNotification("email");
		NotificationFactory.sendNotification("Video Call");
		
	}
}

interface Notification{
	public void sendNotification();
}

class EmailNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println("Email notification has been sent!!!");
		
	}
	
}
class SMSNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println("SMS notification has been sent!!!");
		
	}
	
}

class NotificationFactory{
	
	private NotificationFactory() {}
	
	public static void sendNotification(String str) {
		 Notification obj;

		switch(str.toLowerCase()) {
			case "email":{
				obj = new EmailNotification();
				break;
			}
			case "sms":{
				obj = new SMSNotification();
				break;
			}
			default:
				throw new IllegalArgumentException();
			}
		obj.sendNotification();
	}
}