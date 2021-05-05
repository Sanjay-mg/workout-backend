package com.ibm.workout.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.workout.entity.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String>{
	List<Workout> findAllByStartDateTimeBetween(Date startDateTime, Date endDate);

}
