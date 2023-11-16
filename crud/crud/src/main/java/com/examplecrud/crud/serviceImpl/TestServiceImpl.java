package com.examplecrud.crud.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplecrud.crud.dto.TestDto;
import com.examplecrud.crud.model.TestEntity;
import com.examplecrud.crud.repository.TestRepo;
import com.examplecrud.crud.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	public TestRepo testRepo;
	
	@Override
	public List<TestDto> allUser() {
		List<TestEntity> tests = this.testRepo.findAll();
		List<TestDto> testList = tests.stream().map(data -> this.entityToDto(data)).collect(Collectors.toList());
		return testList;
	}
	
	@Override
	public TestDto createTest(TestDto data) {
		TestEntity tests = this.dtoToEntity(data);
		TestEntity testEntity = this.testRepo.save(tests);
		return this.entityToDto(testEntity);
	}
	
	public String deleteTest(int id) {
		try {
			TestEntity tests = this.testRepo.findById(id).orElseThrow();
			 testRepo.delete(tests);
			 return "user deleted succesfully";
		}catch(Exception e){
			return "user not deleted";
		}	
	}
	
	public TestDto updateTest(TestDto data, int id) {
		TestEntity obj = this.dtoToEntity(data);
		TestEntity testEntity = this.testRepo.findById(id).orElseThrow();
		testEntity.setId(id);
		testEntity.setName(data.getName());
		testEntity.setSurname(data.getSurname());
		testEntity.setAddress(obj.getAddress());
		TestEntity newtestEntity = this.testRepo.save(testEntity);
		TestDto testDto = this.entityToDto(newtestEntity);
		return testDto;
	}
	
	
	public TestEntity dtoToEntity(TestDto data){
		TestEntity obj = new TestEntity();
		obj.setId(data.getId());
		obj.setName(data.getName());
		obj.setSurname(data.getSurname());
		obj.setAddress(data.getAddress());
		return obj;
	}

	public TestDto entityToDto(TestEntity data) {
		TestDto obj = new TestDto();
		obj.setId(data.getId());
		obj.setName(data.getName());
		obj.setSurname(data.getSurname());
		obj.setAddress(data.getAddress());
		return obj;
	}
	
}

