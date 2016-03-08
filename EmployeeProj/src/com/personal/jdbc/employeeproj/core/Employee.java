package com.personal.jdbc.employeeproj.core;

public class Employee {
private int empid;
private String empname;
private String surname;
private int age;
private double salary;
private String department;
public Employee(int empid, String empname, String surname, int age, String department, Double salary) {
this.empid=empid;
this.empname=empname;
this.surname=surname;
this.age=age;
this.department=department;
this.salary=salary;
// TODO Auto-generated constructor stub
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
@Override
public String toString() {
	return String.format("Employee [empid=%s, empname=%s, surname=%s, age=%s, department=%s, salary=%s]",
					empid, empname, surname, age,department, salary);
}


	
}

