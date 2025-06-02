package com.practice.in.Serialization_Deserialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Json_Pojo {
	private String name;
	private String capital;
	private long population;
	private long area;
	private String currency;
	private String[] languages;
	private String region;
	private String subregion;
	private String flag;
}
