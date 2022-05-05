package com.ob.employee.employeedetails.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ob.employee.employeedetails.dto.EmployeeLeave;
import com.ob.employee.employeedetails.dto.Employees;

public class EmployeeApplication {
	public void showLeaveStatus(Employees employees) {

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			Scanner s1 = new Scanner(System.in);
			Scanner s2 = new Scanner(System.in);

			String str4 = "from EmployeeLeave where employeeId=:eId";
			Query query4 = entityManager.createQuery(str4);
			int eId4 = employees.getEmployeeId();
			query4.setParameter("eId", eId4);
			List resultList = query4.getResultList();

			for (Object object : resultList) {
				EmployeeLeave employeeLeave = (EmployeeLeave) object;
				System.out.println("==> " + employeeLeave);
			}
		} catch (Exception e) {
			System.out.println("system error");
		}

	}

	public void applyLeave(Employees singleResult) {
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			Scanner s1 = new Scanner(System.in);
			Scanner s2 = new Scanner(System.in);

			EmployeeLeave employeeLeave = new EmployeeLeave();
			int eId5 = singleResult.getEmployeeId();
			System.out.println("======" + (eId5));
			String leaveStatus1 = "pending";
			System.out.println("Enter date for leave");
			String leaveDate = s1.nextLine();

			employeeLeave.setLeaveStatus(leaveStatus1);
			employeeLeave.setLeaveDate(leaveDate);
			employeeLeave.setEmployeeId(eId5);

			entityTransaction.begin();
			entityManager.persist(employeeLeave);
			entityTransaction.commit();

			System.out.println("Leave applied");
		} catch (Exception e) {
			System.out.println("application failed!!!  Try again");
		}
	}


}
