package DTO;

public class Department {
   private int did;
   private String dname;
   private String location;
   
   public Department() {}
   
   public Department(int did, String dname, String location) {
	super();
	this.did = did;
	this.dname = dname;
	this.location = location;
   }

	public int getDid() {
		return did;
	}
	
	public void setDid(int did) {
		this.did = did;
	}
	
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "did=" + did + ", dname=" + dname + ", location=" + location +"";
	}
	   
   
}
