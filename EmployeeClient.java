package com.roda.employee.client;

import java.util.Scanner;

import com.roda.employee.presentation.EmployeeUserInterface;
import com.roda.employee.presentation.EmployeeUserInterfaceImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		EmployeeUserInterface employeeUserInterface=new EmployeeUserInterfaceImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			employeeUserInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			try {
				employeeUserInterface.performMenu(choice);
			} catch (Exception e) {
				System.out.println("Something went wrong , please try after sometime!");
			}
			
		}

	}

}
