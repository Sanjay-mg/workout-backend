package com.ibm.workout.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.workout.entity.Category;
import com.ibm.workout.repository.CategoryRepository;
import com.ibm.workout.repository.WorkoutRepository;

class CategoryServiceTest {
	
	@Test
	void testCreateCategory() {
		CategoryService categoryService = new CategoryService();
		CategoryRepository dummyRepository = new DummyCategoryRepository();
		WorkoutRepository workoutRepository = new DummyWorkoutRepository();
		categoryService.setCategoryRepository(dummyRepository);
		categoryService.setWorkoutRepository(workoutRepository);
		Category category = new Category();
		String categoryId = categoryService.createCategory(category);
		assertNotNull(categoryId);
	}
	
	@Test
	void testGetCategories() {
		CategoryService categoryService = new CategoryService();
		CategoryRepository dummyRepository = new DummyCategoryRepository();
		WorkoutRepository workoutRepository = new DummyWorkoutRepository();
		categoryService.setCategoryRepository(dummyRepository);
		categoryService.setWorkoutRepository(workoutRepository);
		List<Category> result = categoryService.getCategories();
		assertNotNull(result);
	}

}
