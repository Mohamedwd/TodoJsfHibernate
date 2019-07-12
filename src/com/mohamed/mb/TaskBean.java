package com.mohamed.mb;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

import com.mohamed.dao.DAO;
import com.mohamed.entities.Task;

@ManagedBean(name="task")
@SessionScoped
public class TaskBean implements Serializable{
	private Task taskObj = new Task();
	private DAO dao = new DAO();
	
	private int id;
	private String taskName;
	private String taskSeverity;
	
	public TaskBean() {
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
	
	public Task getTaskObj() {
		return taskObj;
	}

	public void setTaskObj(Task taskObj) {
		this.taskObj = taskObj;
	}
	

	//for list items 
	private static List<String> value;
	
	static {
		value = new LinkedList<>();
		value.add("Critical");
		value.add("High");
		value.add("Medium");
		value.add("Low");
	}
	
	public List<String> getItemValues(){
		return value;
	}

	//add a new task
	public void addTask() {
		taskObj.setTaskName(taskName);
		taskObj.setTaskSeverity(taskSeverity);
		dao.addTask(taskObj);
		this.taskName = null;
		this.taskSeverity = null;
	}
	
	// get all the tasks
	public List<Task> allTasks(){
		return dao.getAllTasks();
	}
	
	//delete a task
	public void deleteTask(int taskID) {
		dao.deleteTask(taskID);
	}
	
	//dispatch to edit page
	public String editTask(Task taskObj) {
		this.taskObj = taskObj;
		return "update";
	}
	
	//update Task
	public String updateTask() {
		dao.updateTask(this.taskObj);
		return "index";
	}
	
	
}






