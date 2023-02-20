package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import DTO.Employee;
import Exception.SomeThingWrongException;

public class employeeDaoImpl implements employeeDao{

	@Override
	public String registeremployeewithoutDeptid(Employee emp) throws SomeThingWrongException {
		String messg = "input is invalid";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY = "INSERT INTO employee(empid,ename,address,email,password,salary) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the input data in query
			ps.setInt(1, emp.getEmpid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getPassword());
			ps.setInt(6, emp.getSalary());
			//execute update statement
			int out  = ps.executeUpdate();
			
			if(out>0) {
				messg = "employee details uploaded successfully";
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
	public String assigndDeptToEmp(int deptid, int empid) {
		String messg = "invalid empid";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			
			PreparedStatement ps = connection.prepareStatement("update employee set deptid=? where empid=?");
			
			ps.setInt(1, deptid);
			ps.setInt(2, empid);
			
		int out = ps.executeUpdate();
			
			if(out>0) {
				messg = "employee deptid Updated Succesfully";
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

	@Override
	public String loginemp(String email, String password) throws SomeThingWrongException {
		String login = "invalid credential";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			
			PreparedStatement ps = connection.prepareStatement("select * from employee where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				login = "welcome "+ rs.getString("ename");
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
		return login;
	}

	@Override
	public void employeePass(String email, String password)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			
			PreparedStatement ps = connection.prepareStatement("update employee set password=? where email=?");
			
			ps.setString(1, password);
			ps.setString(2, email);
			
		int out = ps.executeUpdate();
			
			if(out>0) {
				System.out.println("Password Updated Succesfully");
			}else {
				System.out.println("invalid details");
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
		
	}

}
