package com.ibm.workout.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.workout.entity.STATUS;
import com.ibm.workout.entity.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String>{
	List<Workout> findByStartDateTimeBetween(Date startDateTime, Date endDate);
	List<Workout> findByCategoryIgnoreCase(String category);
	List<Workout> findByStatus(STATUS status);
}	
