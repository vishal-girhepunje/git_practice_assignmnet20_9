package com.dto;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

public class assignNewDept {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter DId ");
		int empid=sc.nextInt();
		System.out.println("Enter the EmpId");
		int dId=sc.nextInt();
		EmployeeDao em=new EmployeeDaoImpl();
		
		System.out.println(em.assignDeptToEmp(dId, empid));
		
	}

}
