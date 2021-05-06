package com.ibm.workout.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.workout.Service.CustomIllegalArgumentException;
import com.ibm.workout.Service.WorkoutService;
import com.ibm.workout.entity.STATUS;
import com.ibm.workout.entity.Workout;

@CrossOrigin
@RestController
public class WorkoutController {
	@Autowired
	WorkoutService workoutService;

	/**
	 * Used to create workout record
	 * 
	 * @param workout
	 * @param bindingResult
	 * @return Id of the created record
	 */
	@PostMapping("/workout")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createWorkout(@RequestBody @Valid Workout workout, BindingResult bindingResult) {
		validateModel(bindingResult);
		return workoutService.createWorkout(workout);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new CustomIllegalArgumentException("Something went wrong. Please retry");
		}
	}

	/**
	 * Used to get all workout records in database
	 * 
	 * @return list of all workouts
	 */
	@GetMapping("/workout")
	List<Workout> getWorkouts() {
		return workoutService.getWorkouts();
	}

	/**
	 * Used to get record for given day
	 * @param startDateTime
	 * @return list of workout for given date
	 */
	@GetMapping("/workout/{date}")
	List<Workout> getWorkoutsByDate(
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date startDateTime) {
		return workoutService.getWorkoutByDate(startDateTime);
	}

	@GetMapping("/workout/status/{status}")
	List<Workout> getWorkoutByStatus(@PathVariable("status") STATUS status){
		return workoutService.getWorkoutByStatus(status);
	}
	/**
	 * Used to update workout record
	 * 
	 * @param workout
	 * @param bindingResult
	 * @param workoutId
	 */
	@PutMapping("/workout/{id}")
	void updateWorkout(@RequestBody @Valid Workout workout, BindingResult bindingResult,
			@PathVariable("id") String workoutId) {
		validateModel(bindingResult);
		workout.setId(workoutId);
		workoutService.updateWorkout(workout);
	}

	/**
	 * Used to delete a workout record
	 * 
	 * @param workoutId
	 */
	@DeleteMapping("/workout/{id}")
	void deleteWorkout(@PathVariable("id") String workoutId) {
		workoutService.deleteWorkout(workoutId);
	}
}
