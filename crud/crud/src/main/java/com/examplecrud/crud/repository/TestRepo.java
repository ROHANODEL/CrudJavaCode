package com.examplecrud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplecrud.crud.model.TestEntity;

public interface TestRepo extends JpaRepository<TestEntity, Integer> {

}
