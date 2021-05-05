package com.ibm.workout.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.workout.entity.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String>{
	@Query("{'startDateTime':?0}")
	List<Workout> findByDate(Date bugdate);

}
