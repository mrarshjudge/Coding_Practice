	package com.practice.in.DesignPatterns;
	
	//Template Pattern for Algorithm Steps
	public class Template_Pattern_Tester {
		public static void main(String[]args) {
			Template_Pattern obj = new Imple_Class();
			obj.processOrder();
		}
	
	}
	
	 abstract class Template_Pattern{
		
		 Template_Pattern(){}
		 
		 public  abstract void display_Type();
		 
		 public abstract void payType() ;
		 
		 public final void processOrder() {
			 System.out.println("Order is processed by: "+this.getClass().getName());
			 display_Type();
			 payType();
		}
		 
	}
	 
	 class Imple_Class extends Template_Pattern{
	
		@Override
		public void display_Type() {
			System.out.println("Display OLED for LED TV");
			
		}
	
		@Override
		public void payType() {
			System.out.println("Only offer for AXIS Credit Card holders");
		}
		 
	 }
