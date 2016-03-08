package com.personal.jdbc.employeeproj.DAO;

public class Executor {
public static void main(String[] args){
	try {
		EmployeeDAO dao =  new EmployeeDAO();
		//dao.GetAllEmployees();
		dao.SearchEmployees("HR");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
