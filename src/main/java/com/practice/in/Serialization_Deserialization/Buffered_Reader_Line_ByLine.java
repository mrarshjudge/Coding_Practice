package com.practice.in.Serialization_Deserialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered_Reader_Line_ByLine {
	
	public static void main(String[]args) {
		File f = new File("D:\\Core_Java\\File_IO\\Test.txt");
		readFile(f);
		writeFile(f);
		readFile(f);
	}
	
	//Read File Line-by-Line using BufferedReader
	public static void readFile(File f) {
		
		if(!f.exists()) {
			System.out.println("File is not available to read. Sorry!!!");
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			String line = "";
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//Write Text to File using BufferedWriter
	public static void writeFile(File f) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
			bw.write("Arsh deep is starting to write in the file \n");
			bw.write("I am done with writing in it");	
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
