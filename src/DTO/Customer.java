package DTO;

public class Customer {
 private int customerId;
 private String customerName;
 private String customerAdd;
 private int roomNumnber;
 
    
	public Customer() {
    }


	public Customer(int customerId, String customerName, String customerAdd, int roomNumnber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.roomNumnber = roomNumnber;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerAdd() {
		return customerAdd;
	}


	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}


	public int getRoomNumnber() {
		return roomNumnber;
	}


	public void setRoomNumnber(int roomNumnber) {
		this.roomNumnber = roomNumnber;
	}


	@Override
	public String toString() {
		return "customerId=" + customerId + ", customerName=" + customerName + ", customerAdd=" + customerAdd
				+ ", roomNumnber=" + roomNumnber + "";
	}
    
	
 
}
