package com.pracitce.in.advance.java;

//Final, Finally, and Finalize Quiz
final class Final_Finally_Finalize {
	final int i;
	 public Final_Finally_Finalize(int val) {
		this.i = val;
	}
	 
	 public final void calculate(int a) {
		 try {
			System.out.println(i/a);
		 }finally {
			 System.out.println("Finally runs here");
		 }
	 }
	 
	 @Override
	 public void finalize() {
		 System.out.println("Doing cleanup activities");
	 }
}
