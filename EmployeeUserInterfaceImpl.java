package com.roda.employee.presentation;

import java.util.LinkedList;
import java.util.Scanner;

import com.roda.employee.dto.Employee;
import com.roda.employee.service.EmployeeBusinessLogic;
import com.roda.employee.service.EmployeeBusinessLogicImpl;

public class EmployeeUserInterfaceImpl implements EmployeeUserInterface {

	private EmployeeBusinessLogic businessLogic=new EmployeeBusinessLogicImpl();
	
	
	@Override
	public void showMenu() {
		System.out.println("1. List All Employees");
		System.out.println("2. Add New Employee");
		System.out.println("3. Delete Existing Employee");
		System.out.println("4. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1: 
			LinkedList<Employee> employees=businessLogic.getAllEmployees();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			break;
		case 2:
			Employee employee=new Employee(choice, null, null, null, choice);
			System.out.println("Enter Employee ID : ");
			employee.setEmpId(scanner.nextInt());
			System.out.println("Enter Employee Name : ");
			employee.setEmpName(scanner.next());
			System.out.println("Enter Employee Designation : ");
			employee.setEmpDesignation(scanner.next());
			System.out.println("Enter Employee Department : ");
			employee.setEmpDepartment(scanner.next());
			System.out.println("Enter Employee Salary : ");
			employee.setEmpSalary(scanner.nextDouble());
			
			boolean status=businessLogic.addEmployee(employee);
			
			if(status)
				System.out.println("Employee Added!");
			else
				System.out.println("Employee Not Added!");
			break;
		case 3:
			System.out.println("Enter Employee ID whoes record you want to delete : ");
			int id=scanner.nextInt();
			if(businessLogic.deleteEmployee(id))
				System.out.println("Record Deleted");
			else
				System.out.println("Employee with id "+id+" does not exist");
			break;
		case 4:
			try {
				businessLogic.saveAllEmployees();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thanks for Using Employee Management System");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}
}
