package UI;


import java.util.List;
import java.util.Scanner;


import DAO.departmentDaoImpl;
import DTO.Department;
import Exception.SomeThingWrongException;

public class DepartmentUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Add dept\n2. View dept\n3. Update location\n0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("Enter department details");
				System.out.println("Enter did");
				int did = sc.nextInt();
				System.out.println("Enter department name");
				String dname = sc.next();
				System.out.println("Enter location");
				String location = sc.next();
				
				departmentDaoImpl deptimpl = new departmentDaoImpl();
				Department dept = new Department(did,dname,location);
			try {
				System.out.println(deptimpl.addDepartment(dept));
			} catch (SomeThingWrongException e) {
				System.out.println(e.getMessage());
			}

			}else if(choice == 2) {
				departmentDaoImpl deptimpl = new departmentDaoImpl();
				List<Department> dl = deptimpl.getAlldetails();
				dl.forEach(System.out::println);
				
			}else if(choice == 3) {
				System.out.println("Enter department details");
				System.out.println("Enter did");
				int did = sc.nextInt();
				System.out.println("Enter location");
				String location = sc.next();
				departmentDaoImpl deptimpl = new departmentDaoImpl();
				System.out.println(deptimpl.updateLocation( location, did));
			}
			
		}while(choice != 0);
		System.out.println("Thanks for using services, visit again");
		sc.close();
	}
}
