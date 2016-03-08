package com.personal.employeeProj.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.personal.jdbc.employeeproj.DAO.EmployeeDAO;
import com.personal.jdbc.employeeproj.core.Employee;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField DepartmenttextField;
	private JTable table;
	private EmployeeDAO Employdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {

		try {
			Employdao = new EmployeeDAO();
		} catch (Exception exec) {
			JOptionPane.showMessageDialog(this, "Error:" + exec, "Error", JOptionPane.ERROR_MESSAGE);
		}
		setTitle("EmployeeApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Enter Department");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);

		DepartmenttextField = new JTextField();
		panel.add(DepartmenttextField);
		DepartmenttextField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 1. Call Department name from the text field
					String Dept = DepartmenttextField.getText();
					// 2. Call DAO and get departments from the table
					// 3. If textfield is null, return all records
					List<Employee> Employees = null;
					if (Dept != null && Dept.trim().length() > 0) {
						Employees = Employdao.SearchEmployees(Dept);
					} else
						Employees = Employdao.GetAllEmployees();

					/*
					 * for(Employee temp: Employees){
					 * System.out.println(Employees); }
					 */
					// Create the model and update the table
					EmployeeTableModel Model = new EmployeeTableModel(Employees);
					table.setModel(Model);// 4. Print out the departments
				} catch (Exception exec) {

				}
			}
		});
		panel.add(btnSearch);

		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployeeDialog deleteDialog = new DeleteEmployeeDialog(EmployeeFrame.this, Employdao);
				deleteDialog.setVisible(true);
			}
		});
		panel.add(btnDeleteEmployee);
		
		JButton btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployeeDialog updateDialog = new UpdateEmployeeDialog(EmployeeFrame.this,Employdao);
				updateDialog.setVisible(true);
			}
		});
		panel.add(btnUpdateEmployee);

		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// EmployeeDAO Employdao = null;
				AddEmployeeDialog Adddialog = new AddEmployeeDialog(EmployeeFrame.this, Employdao);
				Adddialog.setVisible(true);
			}
		});
		contentPane.add(btnAddEmployee, BorderLayout.SOUTH);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
			}
		});
		contentPane.add(scrollBar, BorderLayout.EAST);
	}

	public void refreshEmpView() {
		// TODO Auto-generated method stub
		try {
			List<Employee> EList = new ArrayList<>();
			EmployeeTableModel model = new EmployeeTableModel(EList);
			table.setModel(model);
		} catch (Exception exec) {
			JOptionPane.showMessageDialog(this, "Error:" + exec, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
