package com.personal.employeeProj.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.personal.jdbc.employeeproj.core.Employee;

class EmployeeTableModel extends AbstractTableModel {
	private static final int EMP_ID_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int LAST_NAME_COL = 2;
	private static final int AGE_COL = 3;
	private static final int DEPARTMENT_COL = 4;
	private static final int SALARY_COL= 5;

	private String[] columnNames = { "Employ ID", "First Name", "Last Name", "Age",
		"Department","Salary" };
	private List<Employee> employees;

	public EmployeeTableModel(List<Employee> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Employee tempEmployee = employees.get(row);

		switch (col) {
		case EMP_ID_COL:
			return tempEmployee.getEmpid();
		case LAST_NAME_COL:
			return tempEmployee.getSurname();
		case FIRST_NAME_COL:
			return tempEmployee.getEmpname();
		case AGE_COL:
			return tempEmployee.getAge();
		case SALARY_COL:
			return tempEmployee.getSalary();
		case DEPARTMENT_COL:
			return tempEmployee.getDepartment();
		default:
			return tempEmployee.getDepartment();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
