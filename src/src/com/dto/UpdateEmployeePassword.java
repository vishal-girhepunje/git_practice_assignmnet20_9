package com.dto;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;


public class UpdateEmployeePassword {
	public static void main(String[] args) {
		EmployeeDao edao= new EmployeeDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		String empID=sc.next();
		System.out.println("Enter password ");
		String password=sc.next();
		
		edao.employeePassword(empID, password);
	}

}
