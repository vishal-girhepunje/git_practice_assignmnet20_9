package DAO;

import java.util.List;

import DTO.Customer;
import DTO.Room;
import Exception.RoomException;

public interface roomDao {
public String addRoom(Room room);
public Room getRoomByRoomtype(String name) throws RoomException;
public List<Room> getemptyRoom()throws RoomException;
public String addCustomerToRoom(Customer customer,int roomNumber) throws RoomException;
public String removeCustomerFromRoom(int customerId,int roomNumber) throws RoomException;
public List<Customer> getCustomerFromParticularRoom(int roomNumber)throws RoomException;
public List<Room> gerAllRoomDetails();
}
