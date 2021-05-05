package com.ibm.workout.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.workout.entity.Category;
import com.ibm.workout.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public String createCategory(Category category) {
		Category savedCategory = categoryRepository.save(category);
		return savedCategory.getId();
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(String categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
}
