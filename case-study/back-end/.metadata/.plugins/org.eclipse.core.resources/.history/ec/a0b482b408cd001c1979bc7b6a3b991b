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
import com.ob.employee.employeedetails.services.RegistrationandLogin;
import com.ob.employee.employeedetails.services.EmployeeApplication;
import com.ob.employee.employeedetails.services.ManagerOrginize;

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
			RegistrationandLogin out = new RegistrationandLogin();
			out.registration();
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
			ManagerOrginize details = new ManagerOrginize();

			if (singleResult.getEmployeeType().equalsIgnoreCase("manager")) {
				System.out.println("Enter\n1.to show all leave request\n2.to Approve/reject leave request");
				int key2 = s2.nextInt();

				switch (key2) {
				case 1:

					details.showAllLeaveDetails();

					break;
				case 2:

					details.pendingLeave();

					break;
				default:
					System.out.println("invalid input");
					break;
				}
			} else if (singleResult.getEmployeeType().equalsIgnoreCase("employee")) {

				System.out.println("Enter\n1.to show all status\n2. to request for leave");
				int key3 = s2.nextInt();
				EmployeeApplication application = new EmployeeApplication();
				switch (key3) {
				case 1:
					application.showLeaveStatus(singleResult);
					break;
				case 2:
					application.applyLeave(singleResult);
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
