package com.ibm.workout.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ibm.workout.Service.CategoryService;
import com.ibm.workout.entity.Category;

@CrossOrigin
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	/**
	 * Used to create the category record
	 * 
	 * @param category
	 * @param bindingResult
	 * @return Id of created category
	 */
	@PostMapping("/category")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createCategory(@RequestBody @Valid Category category, BindingResult bindingResult) {
		validateModel(bindingResult);
		return categoryService.createCategory(category);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Please retry");
		}
	}

	/**
	 * Used to get all the categories in database
	 * 
	 * @return list of categories
	 */
	@GetMapping("/category")
	List<Category> getCategories() {
		return categoryService.getCategories();
	}

	/**
	 * Used to update category
	 * 
	 * @param category
	 * @param bindingResult
	 * @param categoryId
	 */
	@PutMapping("/category/{id}")
	void updateCategory(@RequestBody @Valid Category category, BindingResult bindingResult,
			@PathVariable("id") String categoryId) {
		validateModel(bindingResult);
		category.setId(categoryId);
		categoryService.updateCategory(category);
	}

	/**
	 * Used to delete category
	 * 
	 * @param categoryId
	 */
	@DeleteMapping("/category/{id}")
	void deleteCategory(@PathVariable("id") String categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
