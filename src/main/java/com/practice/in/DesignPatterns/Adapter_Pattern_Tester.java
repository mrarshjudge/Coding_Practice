package com.practice.in.DesignPatterns;

public class Adapter_Pattern_Tester {
	public static void main(String[]rgs) {
		USB usb = new USBClass();
		CPort cport = new AdapterClass(usb);
		System.out.println(cport.showType());
	}
	
}

interface USB{
	String showType();
}

interface CPort{
	String showType();
}

class USBClass implements USB{

	@Override
	public String showType() {
		return "USB Class";
	}
	
}

class CPortClass implements CPort{

	@Override
	public String showType() {
		return "C-Port";
	}
	
}
class AdapterClass implements CPort{
	USB usb;

	public AdapterClass(USB usb) {
		this.usb = usb;
	}
	public String showType() {
		return usb.showType();
	}
		
}