package com.ibm.workout.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.workout.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{

	List<Category> getByTitleIgnoreCase(String title);
}
