package com.ibm.workout.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Workout {
	@NotNull @NotBlank
	@Size(max=100)
	private String title;
	@Size(min=5, max=500)
	private String note;
	@NotNull
	private float caloriesBurnt;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	@Size(max=100)
	private String comment;
	private Category category;
	private STATUS status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getCaloriesBurnt() {
		return caloriesBurnt;
	}
	public void setCaloriesBurnt(float caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
}
