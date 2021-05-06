package com.ibm.workout.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import com.ibm.workout.Service.CustomIllegalArgumentException;

public class Workout {
	@Id
	private String id;
	@NotNull @NotBlank
	@Size(max=100)
	private String title;
	@NotNull @NotBlank
	@Size(min=5, max=500)
	private String note;
	@NotNull
	private float caloriesBurnt;
	private Date startDateTime;
	private Date endDateTime;
	@Size(min=5,max=100)
	private String comment;
	@NotNull @NotBlank
	private String category;
	private STATUS status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		if(endDateTime.compareTo(new Date())<0) {
			throw new CustomIllegalArgumentException("End Date cannot be a past date");
		}
		this.endDateTime = endDateTime;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		if(startDateTime.compareTo(new Date())<0) {
			throw new CustomIllegalArgumentException("Start Date cannot be a past date");
		}
		this.startDateTime = startDateTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
}
