package com.ibm.workout.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.workout.entity.Category;
import com.ibm.workout.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

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
		categoryRepository.deleteById(categoryId);
	}

}
