package com.dto;

import java.util.Scanner;

import com.dao.DepartmentDao;
import com.dao.DepartmentDaoIml;

public class AddNewDepartment {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Department Id");
		int did=sc.nextInt();
		System.out.println("Enter Department name ");
		String dname=sc.next();
		System.out.println("Enter Location ");
		String location=sc.next();
		DepartmentDao addNew=new DepartmentDaoIml();
		addNew.addNewDepartment(did, dname, location);
		
	}

}
