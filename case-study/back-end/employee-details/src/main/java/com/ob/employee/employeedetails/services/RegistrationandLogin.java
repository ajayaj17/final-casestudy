package com.ob.employee.employeedetails.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ob.employee.employeedetails.dto.EmployeeLeave;
import com.ob.employee.employeedetails.dto.Employees;

public class RegistrationandLogin {

	public void registration() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			Scanner s1 = new Scanner(System.in);
			Scanner s2 = new Scanner(System.in);

			Employees employee = new Employees();

			System.out.println("Enter details to register");
			System.out.println("=============================================");
			System.out.println("Enter Employee id");
			int eId = s2.nextInt();
			System.out.println("Enter Employee Name");
			String eName = s1.nextLine();
			System.out.println("Enter Employee Type");
			String eType = s1.nextLine();
			System.out.println("Enter Employee Email");
			String email = s1.nextLine();
			System.out.println("Enter Employee Password");
			String password = s1.nextLine();

			employee.setEmployeeId(eId);
			employee.setEmployeeName(eName);
			employee.setEmployeeType(eType);
			employee.setEmail(email);
			employee.setPassword(password);
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			System.out.println("Registration successful");
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	
}
