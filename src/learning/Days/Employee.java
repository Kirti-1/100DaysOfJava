package learning.Days;

public class Employee {

	String EmployeeCode;
	long Salary;
	String Department;
	Boolean testCleared;
	
	public Employee(String employeeCode, long salary, String department, Boolean testCleared) {
		super();
		EmployeeCode = employeeCode;
		Salary = salary;
		Department = department;
		this.testCleared = testCleared;
	}
	public Boolean getTestCleared() {
		return testCleared;
	}
	public void setTestCleared(Boolean testCleared) {
		this.testCleared = testCleared;
	}
	public Employee() {
		
	}
	
	public String getEmployeeCode() {
		return EmployeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		EmployeeCode = employeeCode;
	}
	public long getSalary() {
		return Salary;
	}
	public void setSalary(long salary) {
		Salary = salary;
	}
	
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	
	
	@Override
	public String toString() {
		return "Employee [EmployeeCode=" + EmployeeCode + ", Salary=" + Salary + ", Department=" + Department
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}	
