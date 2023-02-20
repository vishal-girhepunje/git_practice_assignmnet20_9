package com.dto;

import java.util.Scanner;

import com.dao.EmployeeDaoImpl;
import com.dao.EmployeeDao;

public class EmployeeLogin {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee Email: ");
		String email=sc.next();
		System.out.println("Enter employee Password");
		String pass =sc.next();
		EmployeeDao empdao=new EmployeeDaoImpl();
		String result=empdao.loginEmployee(email, pass);
		System.err.println(result);
	}
}

