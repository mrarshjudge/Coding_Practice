package com.practice.in.OOPS;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

//Create Your Own Immutable Class
@Data
@AllArgsConstructor
final class Immute {
	
	@Setter(value = AccessLevel.NONE)
	 private final int id;
	@Setter (value = AccessLevel.NONE)
	private final String name;
	
	
}

class Immutable{
	public static void main(String[]args) {
		Immute it = new Immute(12, "Arsh");
		System.out.println(it.getId() +"   "+it.getName());
	}
}
