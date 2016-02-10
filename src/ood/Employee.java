package ood;

public class Employee {
	private int id;
	private String name;
	private String department;
	private boolean working;
	
	public Employee(int id, String name, String department, boolean working) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.working = working;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", working=" + working + "]";
	}
	
}

class ClientModule{
	public static void hireNewEmployee(Employee emp){
		EmployeeDAO edao = new EmployeeDAO();
		edao.saveEmployee(emp);
	}
	
	public static void terminateEmployee(Employee emp){
		EmployeeDAO edao = new EmployeeDAO();
		edao.deleteEmployee(emp);
	}
	
	public static void printEmployeeReport(Employee emp){
		
	}
}

class EmployeeDAO{
	
	public void saveEmployee(Employee emp){
		
	}
	
	public void deleteEmployee(Employee emp){
		
	}
	
}

class DatabaseConnectionManager{
	public static DatabaseConnectionManager getInstance(){
		return null;
	};
	public void connect(){
		
	}
}
