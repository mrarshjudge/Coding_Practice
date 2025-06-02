package com.practice.in.Serialization_Deserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Object Serialization and Deserialization
public class Serialization_Deserialization {
	public static void main(String[]args) {
		Employee e1 = new Employee(121, "Arsh", "Fzr");
		String filePath = "D:/Core_Java/File_IO/Test.txt";

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
) {
			oos.writeObject(e1);
			Employee e2 = (Employee) ois.readObject();
			System.out.println(e2);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String address;
}