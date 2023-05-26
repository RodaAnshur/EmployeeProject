package com.roda.employee.persistence;

import java.util.LinkedList;

import com.roda.employee.dto.Employee;

public interface EmployeeDataAccess {
	
	public boolean writeRecords(LinkedList<Employee> employees)throws Exception;
	public LinkedList<Employee> readRecords()throws Exception;
}
