package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DTO.Department;
import Exception.SomeThingWrongException;

public class departmentDaoImpl implements departmentDao{

	@Override
	public String addDepartment(Department dept) throws SomeThingWrongException {
		String messg = "input is invalid";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY = "INSERT INTO department VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the input data in query
			ps.setInt(1, dept.getDid());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLocation());
			
			//execute update statement
			int out  = ps.executeUpdate();
			
			if(out>0) {
				messg = "department details uploaded successfully";
			}
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			throw new SomeThingWrongException();
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				
			}
		}
		return messg;
	}

	@Override
	public List<Department> getAlldetails() {
		Connection connection = null;
		List<Department> deptlist = new ArrayList<>();
		try {
			connection = DbUtils.connectToDatabase();
			String SELECT_QUERY = "SELECT * FROM department";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int d = rs.getInt(1);
				String n = rs.getString(2);
				String l = rs.getString(3);
				Department dept = new Department(d,n,l);
				
				deptlist.add(dept);
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}	
		
		return deptlist;
		}

	@Override
	public String updateLocation(String location, int did) {
		String messg = "invalid did";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			
			PreparedStatement ps = connection.prepareStatement("update department set location=? where did=?");
			
			ps.setString(1, location);
			ps.setInt(2, did);
			
		int out = ps.executeUpdate();
			
			if(out>0) {
				messg = "department location Updated Succesfully";
			}
			
						
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			System.out.println(ex.getMessage());
			
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return messg;
	}

}
