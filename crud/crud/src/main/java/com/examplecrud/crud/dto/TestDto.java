package com.examplecrud.crud.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class TestDto {

	private int id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@NotEmpty
	private String address;
	
}


