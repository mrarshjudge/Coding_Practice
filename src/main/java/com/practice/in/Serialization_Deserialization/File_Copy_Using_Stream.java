package com.practice.in.Serialization_Deserialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//89. File Copy using Streams
public class File_Copy_Using_Stream {
	
	public static void main(String[]args) {
		String target = "D:\\Core_Java\\File_IO\\Test.txt";
		String destination = "D:\\\\Core_Java\\\\File_IO\\\\Test12.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(target));
			BufferedWriter bw = new BufferedWriter(new FileWriter(destination))){
			String line = "";
			while((line = br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
				System.out.println(line);
			}
            System.out.println("File copied successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
