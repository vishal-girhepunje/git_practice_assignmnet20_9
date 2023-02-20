package com.dao;

import problem1.Employee;

public interface EmployeeDao {
	public String regidterEmployeeWithoutDeptId(Employee emp);
	public String assignDeptToEmp(int deptId, int empId);
	public String loginEmployee(String email, String password);
	public void employeePassword(String email, String password);

}
