package com.practice.in.Serialization_Deserialization;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

//Write JSON File using Jackson/Gson
public class Json_Write_Using_Jackson_Gson {
	public static void main(String[]args) {
		File sourceFile = new File("D:\\Core_Java\\File_IO\\file.json");
		File targetFile = new File("D:\\Core_Java\\File_IO\\newfile.json");
		File targetFile1 = new File("D:\\Core_Java\\File_IO\\newfileGson.json");
		writeUsingJackson(sourceFile,targetFile);
		writeUsingGSon(sourceFile, targetFile1);
	}
	
	
	public static void writeUsingJackson(File sourceFile, File targetFile) {
		ObjectMapper om = new ObjectMapper();
		try {
		
			List<Json_Pojo> pojoList = om.readValue(sourceFile, new TypeReference<List<Json_Pojo>>() {} );
			targetFile.createNewFile();
			//om.writeValue(targetFile, pojoList);
			om.writerWithDefaultPrettyPrinter().writeValue(targetFile, pojoList);

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void writeUsingGSon(File sourceFile, File targetFile) {
		Gson gson =  new GsonBuilder().setPrettyPrinting().create();   //new Gson();
		try {
			Json_Pojo[] pojoArr = gson.fromJson(new FileReader(sourceFile), Json_Pojo[].class);
			
			gson.toJson(pojoArr,new FileWriter(targetFile));
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
