package com.personal.jdbc.employeeproj.DAO;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.personal.jdbc.employeeproj.core.Employee;

public class EmployeeDAO {
	private Connection connection;

	public EmployeeDAO() throws Exception {

		// TO get the database properties
		Properties properties = new Properties();
		properties.load(new FileInputStream("access.properties"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		System.out.println(url);
		// Connecting to Database
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connection established successfully");
	}

	public List<Employee> GetAllEmployees() throws SQLException {
		List<Employee> employList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM Employeeinfo");
			while (result.next()) {
				Employee emp = covertToEmployee(result);
				employList.add(emp);
				System.out.println(employList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employList;

	}

	public List<Employee> SearchEmployees(String department) throws SQLException {
		List<Employee> employList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement("SELECT * from employeeinfo where department like ?");
			statement.setString(1, department);
			result = statement.executeQuery();
			System.out.println(result);
			while (result.next()) {
				Employee emp = covertToEmployee(result);
				employList.add(emp);
				System.out.println(employList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employList;
	}

	public void AddNewEmployee(Employee emp) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection
					.prepareStatement("INSERT INTO employeeinfo(empid, empname, surname, age, department, salary)"
							+ " VALUES (?,?,?,?,?,?)");
			statement.setInt(1, emp.getEmpid());
			statement.setString(2, emp.getEmpname());
			statement.setString(3, emp.getSurname());
			statement.setInt(4, emp.getAge());
			statement.setString(5, emp.getDepartment());
			statement.setDouble(6, emp.getSalary());
			statement.executeUpdate();

		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}

	public void deleteEmployee(int empid){
		PreparedStatement statement = null;
		try{
			statement = connection
					.prepareStatement("DELETE FROM employeeinfo WHERE empid=?");
			statement.setInt(1, empid);
			statement.executeUpdate();
		}catch (Exception exec) {
			exec.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee emp){
		PreparedStatement statement = null;
		try {
			statement = connection
					.prepareStatement("UPDATE employeeinfo SET empname= ?, surname=?, age=?, "
							+ "department=?, salary=? WHERE empid=?");
			statement.setInt(6, emp.getEmpid());
			statement.setString(1, emp.getEmpname());
			statement.setString(2, emp.getSurname());
			statement.setInt(3, emp.getAge());
			statement.setString(4, emp.getDepartment());
			statement.setDouble(5, emp.getSalary());
System.out.println(statement);
			statement.executeUpdate();

		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}
	
	
	public Employee covertToEmployee(ResultSet result) throws SQLException {
		Employee res = null;
		try {
			int id = result.getInt("empid");
			String firstname = result.getString("empname");
			String surname = result.getString("surname");
			Double salary = result.getDouble("salary");
			int age = result.getInt("age");
			String department = result.getString("department");
			res = new Employee(id, firstname, surname, age, department, salary);
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
