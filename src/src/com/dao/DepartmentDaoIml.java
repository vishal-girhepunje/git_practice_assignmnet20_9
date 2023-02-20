package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utility.DBUtil;

public class DepartmentDaoIml implements DepartmentDao {

	@Override
	public void addNewDepartment(int did, String dname, String location) {
		// TODO Auto-generated method stub
		try(Connection conn=DBUtil.connectToDb()){
			String insert_query="insert into department values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(insert_query);
			ps.setInt(1, did);
			ps.setString(2, dname);
			ps.setString(3, location);
			if(ps.executeUpdate()>0)
			{
				System.out.println("Recorded add successfully");
			}
			else {
				System.out.println("Some thing went wrong");
			}
			
		}catch(SQLException eX){
			eX.printStackTrace();
		}

	}

}
