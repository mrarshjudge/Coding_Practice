package com.practice.in.Serialization_Deserialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

//Read JSON File using Jackson/Gson
public class Read_Json_File_Using_Jackson_Or_Gson {
	
	public static void main(String []args) {
		File f = new File("D:\\Core_Java\\File_IO\\file.json");
		gsonRead(f);
		
	}	
	public static void objectMapper(File f) {	
		ObjectMapper mapper = new ObjectMapper();
		try {
			Json_Pojo[] jsonArr = 	mapper.readValue(f, Json_Pojo[].class);
			
			for(Json_Pojo p : jsonArr) {
				System.out.println("Name :"+p.getName());
				System.out.println("Captial :"+p.getCapital());
				System.out.println("Population :"+p.getPopulation());
				System.out.println("Currency :"+p.getCurrency());
				System.out.println("Flag :"+p.getFlag());
				System.out.println("Region :"+p.getRegion());
				System.out.println("Languages :"+Arrays.toString(p.getLanguages()));
				System.out.println("Sub Region :"+p.getSubregion());
				
				System.out.println("-------------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//Read JSON File using Jackson/Gson
	public static void gsonRead(File f) {
		Gson gson = new Gson();
		try {
			Json_Pojo[] pojo = gson.fromJson(new FileReader(f), Json_Pojo[].class);
			for(Json_Pojo p : pojo) {
				System.out.println("Name :"+p.getName());
				System.out.println("Captial :"+p.getCapital());
				System.out.println("Population :"+p.getPopulation());
				System.out.println("Currency :"+p.getCurrency());
				System.out.println("Flag :"+p.getFlag());
				System.out.println("Region :"+p.getRegion());
				System.out.println("Languages :"+Arrays.toString(p.getLanguages()));
				System.out.println("Sub Region :"+p.getSubregion());
				
				System.out.println("----------Done with Gson-----------------");
			}
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
