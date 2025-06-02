package com.practice.in.String;

import java.util.Arrays;
import java.util.stream.Collectors;

//Word Reversal in a Sentence
public class word_reversal_Sentence {
	public static void main(String[]args) {
		String sentence = "My name is Anthony Gunzalwis. Mei    Dunia mei akela hu";
		String[] strArr = sentence.strip().split("//s+");
		StringBuilder sb = new StringBuilder();
		for(String st : strArr) {
			if(!st.isBlank())
				sb.append(new StringBuffer(st).reverse()+" ");
		}
		System.out.println(sb.toString());
		
		System.out.println(Arrays.stream(sentence.strip().split("\\s+"))
							.map(word->new StringBuilder(word.replaceAll("[^0-9A-Za-z]", "")).reverse()
							.toString()).collect(Collectors.joining(" ")));
		
		
	
	}
}
