package com.ibm.workout.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.workout.entity.STATUS;
import com.ibm.workout.entity.Workout;
import com.ibm.workout.repository.WorkoutRepository;

class WorkoutServiceTest {

	@Test
	void testCreateWorkout() {
		WorkoutService workoutService = new WorkoutService();
		WorkoutRepository dummyRepository = new DummyWorkoutRepository();
		workoutService.setWorkoutRepository(dummyRepository);
		Workout workout = new Workout();
		String workoutId = workoutService.createWorkout(workout);
		assertNotNull(workoutId);
	}

	@Test
	void testGetWorkouts() {
		WorkoutService workoutService = new WorkoutService();
		WorkoutRepository dummyRepository = new DummyWorkoutRepository();
		workoutService.setWorkoutRepository(dummyRepository);
		List<Workout> result = workoutService.getWorkouts();
		assertNotNull(result);
	}
	
	@Test
	void testGetWorkoutByStatus() {
		WorkoutService workoutService = new WorkoutService();
		WorkoutRepository dummyRepository = new DummyWorkoutRepository();
		workoutService.setWorkoutRepository(dummyRepository);
		STATUS args = STATUS.OPEN;
		List<Workout> result = workoutService.getWorkoutByStatus(args);
		assertNotNull(result);
	}
	
	@Test
	void testGetWorkoutByDate() {
		WorkoutService workoutService = new WorkoutService();
		WorkoutRepository dummyRepository = new DummyWorkoutRepository();
		workoutService.setWorkoutRepository(dummyRepository);
		Date startDate = new Date();
		List<Workout> result = workoutService.getWorkoutByDate(startDate);
		assertNotNull(result);
	}
}
