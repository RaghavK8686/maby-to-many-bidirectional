package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("Anita");
		student1.setAge(25);
		
		Student student2=new Student();
		student2.setName("Deepa");
		student2.setAge(19);
		
		Student student3=new Student();
		student3.setName("Hari");
		student3.setAge(23);

		
		Course course1=new Course();
		course1.setName("java");
		course1.setDuration("1 year");
		
		Course course2=new Course();
		course2.setName("Python");
		course2.setDuration("4 years");
		
		Course course3=new Course();
		course3.setName("css");
		course3.setDuration("1.5 years");
		
		List<Student> students1=new ArrayList<Student>();
		students1.add(student1);
		students1.add(student2);
		students1.add(student3);
		
		List<Student> students2=new ArrayList<Student>();
		students2.add(student1);
		students2.add(student2);
		
		List<Student> students3=new ArrayList<Student>();
		students3.add(student1);
		students3.add(student2);
		
		course1.setStudent(students1);
		course2.setStudent(students2);
		course3.setStudent(students3);
		
		
		List<Course> list1=new ArrayList<Course>();
		list1.add(course1);
		list1.add(course2);
		list1.add(course3);
		
		List<Course> list2=new ArrayList<Course>();
		list2.add(course1);
		list2.add(course2);
		list2.add(course3);
		
		List<Course> list3=new ArrayList<Course>();
		list3.add(course1);
		list3.add(course2);
		list3.add(course3);
		
		
		student1.setCourse(list1);
		student2.setCourse(list2);
		student3.setCourse(list3);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
		
	}

}
