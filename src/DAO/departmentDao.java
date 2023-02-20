package DAO;

import java.util.List;

import DTO.Department;
import Exception.SomeThingWrongException;

public interface departmentDao {
	
	public String addDepartment(Department dept) throws SomeThingWrongException;
	
	public List<Department> getAlldetails();
	
	public String updateLocation(String location, int did);
}
