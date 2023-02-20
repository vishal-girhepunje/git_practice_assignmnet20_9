package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.DBUtil;

import problem1.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String regidterEmployeeWithoutDeptId(Employee emp) {
			String ans="null";
		try(Connection conn=DBUtil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement("insert into employee(empId,ename,address,email,password,salary)values(?,?,?,?,?,?)");
			ps.setInt(1,emp.getEmpInd());
			ps.setString(2, emp.getEmpname());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getPassword());
			ps.setInt(6, emp.getSalary());		
			
			if(ps.executeUpdate()>0){
				ans+=emp.getEmpname()+"Added Successfully";
			}			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ans;
	}

	@Override
	public String assignDeptToEmp(int deptId, int empId) {
		// TODO Auto-generated method stub
		String msg="Invalid EmpId";
			try(Connection conn=DBUtil.connectToDb()){
				PreparedStatement ps =conn.prepareStatement("UPDATE employee SET deptId =? WHERE empId = ?");
				ps.setInt(1, deptId);
				ps.setInt(2, empId);
				int out=ps.executeUpdate();
				if(out>0){
					msg="Deapt update successfully";
				}
				
			}catch(SQLException ex) {
				ex.getMessage();
			}
		return msg;
	}

	@Override
	public String loginEmployee(String email, String password) {
		// TODO Auto-generated method stub 
		
		String login="Invalid credetials";
		try(Connection conn=DBUtil.connectToDb()) {
			PreparedStatement ps=conn.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				login="Welcome"+rs.getString("ename");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public void employeePassword(String email, String password) {
		// TODO Auto-generated method stub
		try(Connection conn=DBUtil.connectToDb()) {
			PreparedStatement ps=conn.prepareStatement("update employee set password=? where email=?");
			ps.setString(1, password);
			ps.setString(2,email);
			
			int out=ps.executeUpdate();
			if(out>0)
			{
				System.out.println("Password update Successfully");
			}
			else {
				System.out.println("Employee not found with this details.....");
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	

}
