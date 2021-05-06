package com.ibm.workout.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.workout.entity.Category;
import com.ibm.workout.entity.Workout;
import com.ibm.workout.repository.CategoryRepository;
import com.ibm.workout.repository.WorkoutRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	WorkoutRepository workoutRepository;

	public String createCategory(Category category) {
		String title = category.getTitle();
		List<Category> result = categoryRepository.getByTitleIgnoreCase(title);
		if (result.isEmpty()) {
			Category savedCategory = categoryRepository.save(category);
			return savedCategory.getId();
		} else {
			throw new CustomIllegalArgumentException("Category already Exists");
		}
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public void updateCategory(Category category) {
		String title = category.getTitle();
		List<Category> result = categoryRepository.getByTitleIgnoreCase(title);
		if (result.isEmpty()) {
			categoryRepository.save(category);
		} else {
			throw new CustomIllegalArgumentException("Category already Exists");
		}
	}

	public void deleteCategory(String categoryId) {
		Optional<Category> result = categoryRepository.findById(categoryId);
		if(result.isPresent()) {
			String title = result.get().getTitle();
			List<Workout> workoutResult = workoutRepository.findByCategoryIgnoreCase(title);
			if (workoutResult.isEmpty()) {
				categoryRepository.deleteById(categoryId);
			} else {
				throw new CustomIllegalArgumentException("This category is used by a workout");
			}
		}
		
	}

}
