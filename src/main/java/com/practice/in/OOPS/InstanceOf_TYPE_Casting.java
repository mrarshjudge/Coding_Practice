package com.practice.in.OOPS;

import lombok.Data;
//Use of `instanceof` and Typecasting
public class InstanceOf_TYPE_Casting {
	
	public static void main(String []args) {
		Manager m = new Manager();
		Emp e2 = new Manager();
		
		if(m instanceof Emp) {   
			System.out.println("Matching m with Emp");
		}
		
		Emp e = new Emp();

		if(e instanceof Manager) {   
			System.out.println("Matched e with Manager");
		}
		
		Emp e1 = (Emp) m;
		
		if(e1 instanceof Manager) {  
			System.out.println("Matched emp typecast from manager with Manager");
		}
		
		if(e1 instanceof Emp) {   
			System.out.println("Matched emp typecast from manager  with Emp");
		}
		
		Manager m1 = (Manager)e2;    // downcasting possible because inside e2 its maanager
		
		if(m1 instanceof Manager) {   
			System.out.println("Matched Manager typecast from Emp with Manager");
		}
		
		if(m1 instanceof Emp) {   
			System.out.println("Matched manager typecast from Emp  with Emp");
		}
		//Emp e4 = new Emp();
		//Manager m2 = (Manager) e4;   // not possible you can;t downcast emp object to manager because inside its emp not Manager
	}

}

@Data
class Emp{
	int id;
	String name;
}
class Manager extends Emp{
	
}
