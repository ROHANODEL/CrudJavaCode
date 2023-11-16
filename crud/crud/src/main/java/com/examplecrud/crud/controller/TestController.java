package com.examplecrud.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examplecrud.crud.dto.TestDto;
import com.examplecrud.crud.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	public TestService testService;
	
	@GetMapping("/testData")
	public ResponseEntity<List<TestDto>> allUser() {
		return ResponseEntity.ok(this.testService.allUser());
	}
	
	@PostMapping("/testData")
	public ResponseEntity<TestDto> createTest(@Valid @RequestBody TestDto testDto){
		TestDto obj = this.testService.createTest(testDto);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/testData/{id}")
	public String deleteTest(@PathVariable("id") int id) {
		return this.testService.deleteTest(id);
	}

	@PutMapping("/testData/{id}")
	public TestDto updateTest(@Valid @RequestBody TestDto testDto, @PathVariable("id") int id) {
		return this.testService.updateTest(testDto, id);
	}
	
	
}

