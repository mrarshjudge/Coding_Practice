package com.practice.in.Serialization_Deserialization;

import java.io.File;
import java.util.Arrays;

//Directory Traversal using File API
public class Directory_Traversal {
	
	public static void main(String[]args) {
		//traversal("D:\\Core_Java\\File_IO");
		//traversal("D:\\Core_Java\\File_IO\\test.txt");
		File f = new File("D:\\Core_Java\\File_IO");
		traversalRecursive(f);
		
	}
	public static void traversal(String path) {
		File f = new File(path);
		if(!f.isDirectory()) {
			System.out.println("its not a directory");
			return;
		}
		File[] fileList = f.listFiles();
		if(fileList==null || fileList.length<1) return;
		Arrays.stream(fileList).forEach(file->System.out.println(file.getName()));
	}
	
	public static void traversalRecursive(File f) {
		if(!f.exists())return;
		
		if(f.isFile()) {
			System.out.println(f.getName());
			return;
		}
		
		File[] fileList = f.listFiles();
		if(fileList==null || fileList.length<1) return;
		for(File f1 : fileList) {
			traversalRecursive(f1);
		}
		
		
	}

}
