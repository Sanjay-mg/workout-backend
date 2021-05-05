package com.ibm.workout.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.workout.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{

}
