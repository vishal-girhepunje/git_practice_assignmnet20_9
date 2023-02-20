package problem1;

public class Employee {
	private int empInd;
	private String empname;
	private String address;
	private String email;
	private String password;
	private int salary;
	private int deptid;
	public Employee() {}
	public int getEmpInd() {
		return empInd;
	}
	public void setEmpInd(int empInd) {
		this.empInd = empInd;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public Employee(int empInd, String empname, String address, String email, String password, int salary, int deptid) {
		super();
		this.empInd = empInd;
		this.empname = empname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.deptid = deptid;
	}
	
	

}
