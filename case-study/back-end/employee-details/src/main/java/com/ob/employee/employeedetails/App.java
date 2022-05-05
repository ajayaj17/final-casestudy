package com.ob.employee.employeedetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ob.employee.employeedetails.dto.EmployeeLeave;
import com.ob.employee.employeedetails.dto.Employees;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);

		System.out.println("Press 1.Register\n2.Login");
		int key1 = s2.nextInt();

		switch (key1) {
		case 1:
			Employees employee = new Employees();
			EmployeeLeave leave = new EmployeeLeave();
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
			break;

		case 2:
			System.out.println("Welcome to Login");
			System.out.println("Please Enter your id");
			int eId1 = s2.nextInt();
			System.out.println("Please Enter your Password");
			String password1 = s1.nextLine();
			String str = "from Employees where employeeId =:eId and password=:password";
			Query query = entityManager.createQuery(str);
			query.setParameter("eId", eId1);
			query.setParameter("password", password1);

			Employees singleResult = (Employees) query.getSingleResult();

			if (singleResult.getEmployeeType().equalsIgnoreCase("manager")) {
				System.out.println("Enter\n1.to show all leave request\n2.to Approve/reject leave request");
				int key2 = s2.nextInt();

				switch (key2) {
				case 1:
					String str1 = "from EmployeeLeave";
					Query query1 = entityManager.createQuery(str1);

					List resultList = query1.getResultList();

					for (Object object : resultList) {
						EmployeeLeave employeeLeave = (EmployeeLeave) object;
						System.out.println("==> " + employeeLeave);
					}
					break;
				case 2:
					System.out.println("Enter employee id:");
					int eId2 = s2.nextInt();
					System.out.println("Enter leave status");
					System.out.println("Type approved/reject ");
					String leaveStatus = s1.nextLine();
					String str2 = "update EmployeeLeave set leaveStatus =:leaveStatus where employeeId =:eId";
					Query query2 = entityManager.createQuery(str2);
					query2.setParameter("eId", eId2);
					query2.setParameter("leaveStatus", leaveStatus);
					System.out.println("Done");
					break;
				default:
					System.out.println("invalid input");
					break;
				}
			} else if (singleResult.getEmployeeType().equalsIgnoreCase("employee")) {

				System.out.println("Enter\n1.to to show all status\n2. to request for leave");
				int key3 = s2.nextInt();

				switch (key3) {
				case 1:
					String str4 = "from EmployeeLeave where employeeId=:eId";
					Query query4 = entityManager.createQuery(str4);
					int eId4 = singleResult.getEmployeeId();
					query4.setParameter("eId", eId4);
					List resultList = query4.getResultList();

					for (Object object : resultList) {
						EmployeeLeave employeeLeave = (EmployeeLeave) object;
						System.out.println("==> " + employeeLeave);
					}
					break;
				case 2:
					EmployeeLeave employeeLeave = new EmployeeLeave();
					int eId5 = singleResult.getEmployeeId();
					System.out.println("======"+(eId5));
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
					break;

				default:
					System.out.println("invalid input");
					break;
				}
			}

			break;
		default:
			System.out.println("invalid input");
			break;
		}
	}
}
