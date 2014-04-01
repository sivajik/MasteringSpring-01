package com.mastspring.lesson01;

public class Employee {
	// this is mandatory for setter based injection if you have other constructors already.
	public Employee() {}
	
	public Employee(String name, int empId, byte age, double salary) {
		super();
		this.name = name;
		this.empId = empId;
		this.age = age;
		this.salary = salary;
	}
	
	private String name;
	private int empId;
	private byte age;
	private double salary;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "Name: " + name + " EmpId: " + empId + " Age: " + age + " Salary: " + salary;
	}
}
