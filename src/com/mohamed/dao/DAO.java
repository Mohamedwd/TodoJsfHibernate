package com.mohamed.dao;

import java.util.List;

import org.hibernate.Session;

import com.mohamed.entities.Task;
import com.mohamed.util.HibernateUtil;

public class DAO {
	// add a new task to the DB:
	public void addTask(Task task) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(task);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	//get all the tasks
	@SuppressWarnings("unchecked")
	public List<Task> getAllTasks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Task> allTasks = session.createQuery("from Task").list();
		session.getTransaction().commit();
		session.close();
		return allTasks;
	}
	
	//delete a task
	public void deleteTask(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Task task = new Task();
			task.setId(id);
			session.delete(task);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	public void updateTask(Task theTask) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(theTask);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	
}





