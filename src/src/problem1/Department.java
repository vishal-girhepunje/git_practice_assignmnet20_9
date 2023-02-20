package problem1;
/* Establish one to many relationship between the department and employee table
 * write jdbc application use Dao pattern to implement following functionalities
 * add new department
 * Register an employee without Departmentid
 * Assign a registerd employee to an existing department
 * login an employee and display his profile with a welcome massage.
 * get all department details.
 * update the department location.
 * create table employee2(empId int primary key not null,ename varchar(12),address varchar(20),email varchar(20) unique, password varchar(20) not null, salary int ,deptId int );
 */
public class Department {
	private int dId;
	private String dname;
	private String location;
	public Department() {}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
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
	public Department(int dId, String dname, String location) {
		super();
		this.dId = dId;
		this.dname = dname;
		this.location = location;
	}
	
}
