package com.ibm.workout.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ibm.workout.entity.STATUS;
import com.ibm.workout.entity.Workout;
import com.ibm.workout.repository.WorkoutRepository;

public class DummyWorkoutRepository implements WorkoutRepository {

	@Override
	public List<Workout> findAll() {
		Workout workout = new Workout();
		List<Workout> result = new ArrayList<Workout>();
		result.add(workout);
		return result;
	}

	@Override
	public List<Workout> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Workout save(Workout workout) {
		workout.setId("workoutId");
		return workout;
	}
	@Override
	public <S extends Workout> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Workout> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Workout> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Workout> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Workout> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Workout> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Workout arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Workout> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Workout> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Workout> findById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public <S extends Workout> S save(S arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public <S extends Workout> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Workout> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Workout> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Workout> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workout> findByStartDateTimeBetween(Date startDateTime, Date endDate) {
		Workout workout = new Workout();
		List<Workout> result = new ArrayList<Workout>();
		return result;
	}

	@Override
	public List<Workout> findByCategoryIgnoreCase(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workout> findByStatus(STATUS status) {
		Workout workout = new Workout();
		List<Workout> result = new ArrayList<Workout>();
		return result;
	}

}
