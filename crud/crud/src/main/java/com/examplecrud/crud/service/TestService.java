package com.examplecrud.crud.service;

import java.util.List;

import com.examplecrud.crud.dto.TestDto;

public interface TestService {

	public List<TestDto> allUser();

	public TestDto createTest(TestDto data);
	
	public String deleteTest(int id);
	
	public TestDto updateTest(TestDto data, int id);
	
}
