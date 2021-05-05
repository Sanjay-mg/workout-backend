package com.ibm.workout.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.workout.entity.Workout;
import com.ibm.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {
	@Autowired
	WorkoutRepository workoutRepository;

	public String createWorkout(Workout workout) {
		Workout savedWorkout = workoutRepository.save(workout);
		return savedWorkout.getId();
	}

	public List<Workout> getWorkouts() {
		return workoutRepository.findAll();
	}

	public void updateWorkout(Workout workout) {
		workoutRepository.save(workout);
	}

	public void deleteWorkout(String workoutId) {
		workoutRepository.deleteById(workoutId);
	}

	public List<Workout> getWorkoutByDate(Date bugdate) {
			return workoutRepository.findByDate(bugdate);
	}
}
