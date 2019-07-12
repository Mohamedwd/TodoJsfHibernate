package com.mohamed.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="task_severity")
	private String taskSeverity;

	public Task() {
	}

	public Task(String taskName, String taskSeverity) {
		this.taskName = taskName;
		this.taskSeverity = taskSeverity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskSeverity() {
		return taskSeverity;
	}

	public void setTaskSeverity(String taskSeverity) {
		this.taskSeverity = taskSeverity;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", taskSeverity=" + taskSeverity + "]";
	}
	
}






