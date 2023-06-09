package com.roda.employee.service;

import java.util.LinkedList;

import com.roda.employee.dto.Employee;
import com.roda.employee.persistence.EmployeeDataAccess;
import com.roda.employee.persistence.EmployeeDataAccessImpl;

public class EmployeeBusinessLogicImpl implements EmployeeBusinessLogic {
	
private EmployeeDataAccess dataAccess=new EmployeeDataAccessImpl();
	
	private LinkedList<Employee> employeeList;
	
	public EmployeeBusinessLogicImpl() {
		try {
			employeeList=dataAccess.readRecords();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public LinkedList<Employee> getAllEmployees() {
		
		return employeeList;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		return employeeList.add(employee);
	}

	@Override
	public boolean deleteEmployee(int id) {
		for(Employee employee:employeeList) {
			if(id==employee.getEmpId())
				return employeeList.remove(employee);
		}
		return false;
	}
	
	@Override
	public Employee searchEmployee(int id) {
		for(Employee employee:employeeList) {
			if(employee.getEmpId()==id) 
				return employee;
		}
		return null;
		
	}
	
	public void saveAllEmployees() {
		try {
			dataAccess.writeRecords(employeeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

