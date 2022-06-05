package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		
		Person person1=new Person();
		person1.setName("Priya");
		person1.setAge(20);
		
		Person person2=new Person();
		person2.setName("Divya");
		person2.setAge(25);
		
		Person person3=new Person();
		person3.setName("Gopi");
		person3.setAge(16);
		
		Cab cab1=new Cab();
		cab1.setDriverName("Ruhi");
		cab1.setPhone(1478963215l);
		
		Cab cab2=new Cab();
		cab2.setDriverName("Dimple");
		cab2.setPhone(147896325l);
		
		Cab cab3=new Cab();
		cab3.setDriverName("Suleman");
		cab3.setPhone(1478963251l);
		
		List<Person> list1=new ArrayList<Person>();
		list1.add(person1);
		list1.add(person2);
		list1.add(person3);
		
		List<Person> list2=new ArrayList<Person>();
		list2.add(person1);
		list2.add(person2);
		
		List<Person> list3=new ArrayList<Person>();
		list3.add(person2);
		list3.add(person3);
		
		cab1.setPerson(list1);
		cab2.setPerson(list2);
		cab3.setPerson(list3);
		
		List<Cab> cabs1=new ArrayList<Cab>();
		cabs1.add(cab1);
		cabs1.add(cab2);
		cabs1.add(cab3);
		
		List<Cab> cabs2=new ArrayList<Cab>();
		cabs2.add(cab1);
		cabs2.add(cab2);
		
		List<Cab> cabs3=new ArrayList<Cab>();
		cabs3.add(cab2);
		cabs3.add(cab3);
		
		person1.setCab(cabs1);
		person2.setCab(cabs2);
		person3.setCab(cabs3);
		
		entityTransaction.begin();
		entityManager.persist(cabs1);
		entityManager.persist(cabs2);
		entityManager.persist(cabs3);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();
		
	}

}
