package com.ibm.workout.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.workout.entity.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String>{

}
