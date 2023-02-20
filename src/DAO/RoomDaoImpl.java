package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Customer;

import DTO.Room;
import Exception.RoomException;


public class RoomDaoImpl implements roomDao{

	@Override
	public String addRoom(Room room) {
		String messg = "input is invalid";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY = "INSERT INTO room VALUES (?, ?, ?,?,true)";
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the input data in query
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2, room.getRoomType());
			ps.setDouble(3, room.getPricePerNight());
			ps.setInt(4, room.getMaximumPerson());
		
			
			
			//execute update statement
			int out  = ps.executeUpdate();
			
			if(out>0) {
				messg = "Room details uploaded successfully";
			}
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			ex.printStackTrace();
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				ex.printStackTrace(); 
			}
		}
		return messg;
	}

	@Override
	public Room getRoomByRoomtype(String name) throws RoomException {
		
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY = " select * from room where roomtype=?";
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the input data in query
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				int pernight = rs.getInt(3);
				int maxper = rs.getInt(3);
				boolean isempty = rs.getBoolean(4);
				
				Room room = new Room(id,type,pernight,maxper,isempty);
				return room;
			}
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			ex.printStackTrace();
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Room> getemptyRoom() throws RoomException {
		Connection connection = null;
		List<Room> roomlist = new ArrayList<>();
		try {
			connection = DbUtils.connectToDatabase();
			String SELECT_QUERY = "SELECT * FROM room where isempty=true";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				int pernight = rs.getInt(3);
				int maxper = rs.getInt(3);
				boolean isempty = rs.getBoolean(4);
				
				Room room = new Room(id,type,pernight,maxper,isempty);
				
				roomlist.add(room);
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}	
		
		return roomlist;
	}

	@Override
	public String addCustomerToRoom(Customer customer, int roomNumber) throws RoomException {
		String mssg = "Customemr not added";
		
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY1 = " select * from room where roomnumber=?";
			PreparedStatement ps1 = connection.prepareStatement(INSERT_QUERY1);
			
			//stuff the input data in query
			ps1.setInt(1, roomNumber);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				if(rs1.getBoolean("isEmpty")== false) throw new RoomException("Room is not Empty");
				
				String INSERT_QUERY2 = " select * from customer where Customerid=?";
				PreparedStatement ps2 = connection.prepareStatement(INSERT_QUERY2);
				
				//stuff the input data in query
				ps2.setInt(1, customer.getCustomerId());
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(!rs2.next()) {
					String INSERT_QUERY3 = "insert into customer values(?,?,?,null)";
					PreparedStatement ps3 = connection.prepareStatement(INSERT_QUERY3);
					
					//stuff the input data in query
					ps3.setInt(1, customer.getCustomerId());
					ps3.setString(2, customer.getCustomerName());
					ps3.setString(3, customer.getCustomerAdd());
					
					 ps3.executeUpdate();
				}
				
				PreparedStatement ps4 = connection.prepareStatement("update customer set roomnumber=? where customerid=?");
				ps4.setInt(1, roomNumber);
				ps4.setInt(2, customer.getCustomerId());
				
				PreparedStatement ps5 = connection.prepareStatement("update room set isempty=false where roomnumber=?");
				ps5.setInt(1, roomNumber);
				
				int out = ps4.executeUpdate();
				ps5.executeUpdate();
				if(out>0) mssg = "customer added successfully";
				
				
			}else {
				throw new RoomException("invalid Room Number");
			}
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			ex.printStackTrace();
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return mssg;
	}

	@Override
	public String removeCustomerFromRoom(int customerId, int roomNumber) throws RoomException {
		String messg = "not able to remove customer from Room";
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			
			PreparedStatement ps = connection.prepareStatement("update customer set roomnumber=null where customerid=?");
			ps.setInt(1, customerId);
			
			PreparedStatement ps1 = connection.prepareStatement("update room set isEmpty=true where roomnumber=?");
			ps1.setInt(1, roomNumber);
			
		int out = ps.executeUpdate(); 
		ps1.executeUpdate();
			
			if(out>0) {
				messg = "customer removed From Room";
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
	public List<Customer> getCustomerFromParticularRoom(int roomNumber) throws RoomException {
		List<Customer> customerlist = new ArrayList<>();
		Connection connection = null;
		try {
			connection = DbUtils.connectToDatabase();
			//write code to insert record in the table
			String INSERT_QUERY = " select c.customerid,c.customername,c.address,c.roomnumber from customer c inner join room r on c.roomnumber=r.roomnumber where r.roomnumber=?";
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the input data in query
			ps.setInt(1, roomNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String add = rs.getString(3);
				int roomnumber = rs.getInt(4);
				
				Customer customer = new Customer(id,name,add,roomnumber);
				
				customerlist.add(customer);
			}
		}catch(SQLException ex) {
			//log the exception here for debugging in future
			ex.printStackTrace();
		}finally {
			try {
				DbUtils.closeConnection(connection);				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return customerlist;
	}

	@Override
	public List<Room> gerAllRoomDetails() {
		Connection connection = null;
		List<Room> roomlist = new ArrayList<>();
		try {
			connection = DbUtils.connectToDatabase();
			String SELECT_QUERY = "SELECT * FROM room";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				int pernight = rs.getInt(3);
				int maxper = rs.getInt(3);
				boolean isempty = rs.getBoolean(4);
				
				Room room = new Room(id,type,pernight,maxper,isempty);
				
				roomlist.add(room);
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}	
		
		return roomlist;
	}

}
