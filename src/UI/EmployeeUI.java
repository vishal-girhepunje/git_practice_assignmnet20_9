package UI;


import java.util.Scanner;


import DAO.employeeDaoImpl;
import DTO.Employee;
import Exception.SomeThingWrongException;

public class EmployeeUI {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int choice = 0;
	do {
		System.out.println("1. login employee\n2. Change password\n3. register employee\n4 assign department \n0. Exit");
		System.out.print("Enter selection ");
		choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("Enter employee details");
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter  password");
			String password = sc.next();
		  employeeDaoImpl empimpl = new employeeDaoImpl();
		  
		  try {
			System.out.println(empimpl.loginemp(email, password));
		} catch (SomeThingWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}else if(choice == 2) {
			System.out.println("Enter employee email to change password");
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter  password");
			String password = sc.next();
			employeeDaoImpl empimpl = new employeeDaoImpl();
			
			empimpl.employeePass(email, password);
		}else if(choice == 3) {
			System.out.println("Enter employee details");
			System.out.println("Enter empid");
			int empid = sc.nextInt();
			System.out.println("Enter  name");
			String ename = sc.next();
			System.out.println("Enter  address");
			String address = sc.next();
			System.out.println("Enter  email");
			String email = sc.next();
			System.out.println("Enter  password");
			String password = sc.next();
			System.out.println("Enter salary");
			int salary = sc.nextInt();
			
			Employee emp = new Employee(empid, ename,address,email,password,salary,0);
		    employeeDaoImpl empimpl = new employeeDaoImpl();
		  
		  try {
			System.out.println(empimpl.registeremployeewithoutDeptid(emp));
		} catch (SomeThingWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(choice == 4) {
			System.out.println("Enter employee details to assign department");
			System.out.println("Enter deptid");
			int deptid = sc.nextInt();
			System.out.println("Enter  empid");
			int empid = sc.nextInt();
		  employeeDaoImpl empimpl = new employeeDaoImpl();
		  
		  System.out.println(empimpl.assigndDeptToEmp(deptid, empid));
		}
		
	}while(choice != 0);
	System.out.println("Thanks for using services, visit again");
	sc.close();
}
}
