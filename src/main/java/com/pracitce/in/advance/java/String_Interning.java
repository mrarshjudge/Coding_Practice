package com.pracitce.in.advance.java;
//String Interning Demo
public class String_Interning {
	public static void main(String[]rgs) {
		String s = new String("Arsh");
		String s1 = "Arsh";
		String s2 = s1.toLowerCase();
		String s3 = new String("Deep");
		String s4 = s+s3.intern();
		String s5 = "ArshDeep";
		String s6 = s.toUpperCase().intern();
		System.out.println(s==s1);// false
		System.out.println(s1==s2); //false
		System.out.println(s3==s4); //false
		System.out.println(s4==s5);//false
		System.out.println(s6=="ARSH");//true
	}

}
