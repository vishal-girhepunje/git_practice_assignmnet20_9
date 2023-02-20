package com.dto;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

import problem1.Employee;

public class RegisterEmployeWithoutEmpId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee emp=new Employee();
		System.out.println("Enter empId");
		emp.setEmpInd(sc.nextInt());
		System.out.println("Enter empName ");
		emp.setEmpname(sc.next());
		System.out.println("Enter the address: ");
		emp.setAddress(sc.next());
		System.out.println("enter the email");
		emp.setEmail(sc.next());
		System.out.println("Enter the password");
		emp.setPassword(sc.next());
		System.out.println("Enter the salary");
		emp.setSalary(sc.nextInt());
		EmployeeDao empd=new EmployeeDaoImpl();
		empd.regidterEmployeeWithoutDeptId(emp);
	}

}
