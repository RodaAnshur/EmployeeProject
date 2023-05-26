package com.roda.employee.service;

import java.util.LinkedList;

import com.roda.employee.dto.Employee;

public interface EmployeeBusinessLogic {

		LinkedList<Employee> getAllEmployees();
		boolean addEmployee(Employee employee);
		boolean deleteEmployee(int id);
		public void saveAllEmployees()throws Exception;
		Employee searchEmployee (int id);
		
	}
