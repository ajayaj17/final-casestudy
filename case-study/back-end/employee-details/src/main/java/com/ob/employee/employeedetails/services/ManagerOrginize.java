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

public class ManagerOrginize {
	public void showAllLeaveDetails() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			String str1 = "from EmployeeLeave";
			Query query1 = entityManager.createQuery(str1);

			List resultList = query1.getResultList();

			for (Object object : resultList) {
				EmployeeLeave employeeLeave = (EmployeeLeave) object;
				System.out.println("==> " + employeeLeave);
			}
		} catch (Exception e) {
			System.out.println("system error");
		}
	}
	public void pendingLeave() {
		try {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		System.out.println("Enter employee id:");
		int eId2 = s2.nextInt();
		System.out.println("Enter leave status");
		System.out.println("Type approved/reject ");
		String leaveStatus = s1.nextLine();
		String str2 = "update EmployeeLeave set leaveStatus =:leaveStatus where employeeId =:eId";
		Query query2 = entityManager.createQuery(str2);
		query2.setParameter("eId", eId2);
		query2.setParameter("leaveStatus", leaveStatus);
		System.out.println("Done");}catch (Exception e) {
			System.out.println("something went wrong... try again!");
		}
	}
	
}