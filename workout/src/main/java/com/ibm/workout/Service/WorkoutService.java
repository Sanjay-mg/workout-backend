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

	public List<Workout> getWorkoutByDate(Date startDateTime) {
		Date endDate = new Date();
		endDate.setDate(startDateTime.getDate());
		endDate.setMonth(startDateTime.getMonth());
		endDate.setYear(startDateTime.getYear());
		endDate.setHours(23);
		endDate.setMinutes(59);
		endDate.setSeconds(59);
		System.out.println(endDate);
		return workoutRepository.findAllByStartDateTimeBetween(startDateTime,endDate);
	}

}
