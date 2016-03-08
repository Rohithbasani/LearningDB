package com.personal.employeeProj.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.personal.jdbc.employeeproj.DAO.EmployeeDAO;
import com.personal.jdbc.employeeproj.core.Employee;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField FirstName_textField;
	private JTextField SurName_textField;
	private JTextField Age_textField;
	private JTextField Department_textField;
	private JTextField Salary_textField;
	private JTextField EmpID_textField;
	private EmployeeDAO employDAO;
	private EmployeeFrame Empframe;
	public AddEmployeeDialog(EmployeeFrame theEmployApp,EmployeeDAO theEmployDAO){
		this();
		Empframe=theEmployApp;
		employDAO=theEmployDAO;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEmployeeDialog dialog = new AddEmployeeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEmployeeDialog() {
		setTitle("Add Employee");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblEmployId = new JLabel("Employ ID");
			contentPanel.add(lblEmployId, "4, 2");
		}
		{
			EmpID_textField = new JTextField();
			contentPanel.add(EmpID_textField, "10, 2, fill, default");
			EmpID_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("First Name");
			contentPanel.add(lblNewLabel, "4, 4, left, top");
		}
		{
			FirstName_textField = new JTextField();
			contentPanel.add(FirstName_textField, "10, 4, fill, default");
			FirstName_textField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			contentPanel.add(lblLastName, "4, 6");
		}
		{
			SurName_textField = new JTextField();
			contentPanel.add(SurName_textField, "10, 6, fill, default");
			SurName_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Age");
			contentPanel.add(lblNewLabel_1, "4, 8");
		}
		{
			Age_textField = new JTextField();
			contentPanel.add(Age_textField, "10, 8, fill, default");
			Age_textField.setColumns(10);
		}
		{
			JLabel lblDepartment = new JLabel("Department");
			contentPanel.add(lblDepartment, "4, 10");
		}
		{
			Department_textField = new JTextField();
			contentPanel.add(Department_textField, "10, 10, fill, default");
			Department_textField.setColumns(10);
		}
		{
			JLabel lblSalary = new JLabel("Salary");
			contentPanel.add(lblSalary, "4, 12");
		}
		{
			Salary_textField = new JTextField();
			contentPanel.add(Salary_textField, "10, 12, fill, default");
			Salary_textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//saveEmployee();
						//Get the employ details from GUI
					int EmpID =Integer.parseInt(EmpID_textField.getText());	
					String FirstName= FirstName_textField.getText();
					String SurName= SurName_textField.getText();
					int Age= Integer.parseInt(Age_textField.getText());
					String Department= Department_textField.getText();
					Double Salary =Double.parseDouble(Salary_textField.getText());
					Employee empdetails= new Employee(EmpID,FirstName,SurName,Age,Department,Salary);
					try {
						employDAO.AddNewEmployee(empdetails);//Save to database
						setVisible(false);//Close dialog
						dispose();
						Empframe.refreshEmpView();//refresh GUI list
						JOptionPane.showMessageDialog(Empframe, "Employee added successfully", "Employ added", JOptionPane.INFORMATION_MESSAGE);
						//show success message
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
