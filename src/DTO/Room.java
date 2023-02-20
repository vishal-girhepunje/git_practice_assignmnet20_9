package DTO;

public class Room {
  private int roomNumber;
  private String roomType;
  private double pricePerNight;
  private int maximumPerson;
  private boolean Empty;
  
	  
	public Room() {
	}
	
	
	public Room(int roomNumber, String roomType, double pricePerNight, int maximumPerson, boolean Empty) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.maximumPerson = maximumPerson;
		this.Empty = Empty;
	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public String getRoomType() {
		return roomType;
	}
	
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	public double getPricePerNight() {
		return pricePerNight;
	}
	
	
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	
	public int getMaximumPerson() {
		return maximumPerson;
	}
	
	
	public void setMaximumPerson(int maximumPerson) {
		this.maximumPerson = maximumPerson;
	}
	
	
	public boolean getEmpty() {
		return Empty;
	}
	
	
	public void setEmpty(boolean Empty) {
		this.Empty = Empty;
	}
	
	
	@Override
	public String toString() {
		return "roomNumber=" + roomNumber + ", roomType=" + roomType + ", pricePerNight=" + pricePerNight
				+ ", maximumPerson=" + maximumPerson + ", isEmpty=" + Empty + "";
	}
  

  
}
