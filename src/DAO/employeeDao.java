package DAO;

import DTO.Employee;
import Exception.SomeThingWrongException;

public interface employeeDao {
 
	public String registeremployeewithoutDeptid(Employee emp) throws SomeThingWrongException;
	
	public String assigndDeptToEmp(int deptid,int empid);
	
	public String loginemp(String email, String password) throws SomeThingWrongException;
	
	public void employeePass(String email,String password); 
	
	
}
