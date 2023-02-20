package UI;

import java.util.List;
import java.util.Scanner;

import DAO.RoomDaoImpl;

import DTO.Customer;

import DTO.Room;
import Exception.RoomException;


public class RoomUI {
 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Add Rooms\n2. get Room by RoomType\n3. get Empty rooms Details\n4. Add customer to a Room\n5. Remove Customer from Room\n6. get customer From particular Room\n7. get All Rooms \n0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("Enter Room details");
				System.out.println("Enter RoomNumber");
				int rno = sc.nextInt();
				System.out.println("Enter  RoomType");
				String rtype = sc.next();
				System.out.println("Enter PricePerNight");
				double ppn = sc.nextDouble();
				System.out.println("Enter MaximumPerson");
				int mp = sc.nextInt();
				
				Room room = new Room(rno,rtype,ppn,mp,true);
			   RoomDaoImpl rimpl = new RoomDaoImpl();
			  System.out.println(rimpl.addRoom(room));

			}else if(choice == 2) {
				System.out.println("Enter RoomType to get Room");
				System.out.println("Enter RoomType");
				String name = sc.next();
				
				RoomDaoImpl rimpl = new RoomDaoImpl();
				try {
					Room room = rimpl.getRoomByRoomtype(name);
					System.out.println(room);
				} catch (RoomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(choice == 3) {
				System.out.println("Get empty rooms details");
				RoomDaoImpl rimpl = new RoomDaoImpl();
				try {
					List<Room> rl= rimpl.getemptyRoom();
					rl.forEach(System.out::println);
				} catch (RoomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else if(choice == 4) {
				System.out.println("Add Customer to a Room");
				System.out.println("Enter Customerid");
				int cid = sc.nextInt();
				System.out.println("Enter CustomerName");
				String name = sc.next();
				System.out.println("Enter Address");
				String add = sc.next();
				System.out.println("Enter RoomNumber");
				int rno = sc.nextInt();
				
				Customer customer = new Customer(cid,name,add,rno);
				RoomDaoImpl rimpl = new RoomDaoImpl();
				
				try {
				System.out.println(rimpl.addCustomerToRoom(customer, rno));
				} catch (RoomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(choice == 5) {
				System.out.println("Remove Customer From a Room");
				System.out.println("Enter Customerid");
				int cid = sc.nextInt();
				System.out.println("Enter RoomNumber");
				int rno = sc.nextInt();
				
				RoomDaoImpl rimpl = new RoomDaoImpl();
			try {
				System.out.println(rimpl.removeCustomerFromRoom(cid, rno));
			} catch (RoomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}else if(choice == 6) {
				System.out.println("Get Customer From Particular Room");
				System.out.println("Enter RoomNumber");
				int rno = sc.nextInt();
				
				RoomDaoImpl rimpl = new RoomDaoImpl();
				try {
					List<Customer> cl= rimpl.getCustomerFromParticularRoom(rno) ;
					
					cl.forEach(System.out::println);
				} catch (RoomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(choice == 7) {
				System.out.println("Get All Room Details");
				RoomDaoImpl rimpl = new RoomDaoImpl();
			
					List<Room> rl= rimpl.gerAllRoomDetails() ;
					
					rl.forEach(System.out::println);
				
			}
			
			
		}while(choice != 0);
		System.out.println("Thanks for using services, visit again");
		sc.close();
}
}
