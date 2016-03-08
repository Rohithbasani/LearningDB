package com.personal.employeeProj.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.personal.jdbc.employeeproj.DAO.EmployeeDAO;
import com.personal.jdbc.employeeproj.core.Employee;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField empid_textField;
	private JTextField fname_textField;
	private JTextField surname_textField;
	private JTextField Age_textField;
	private JTextField Dept_textField;
	private JTextField Salary_textField;
	private EmployeeDAO employeeDAO;
	private EmployeeFrame empframe;
	public UpdateEmployeeDialog(EmployeeFrame theEmployApp,EmployeeDAO theEmployDAO){
		this();
		empframe=theEmployApp;
		employeeDAO=theEmployDAO;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateEmployeeDialog dialog = new UpdateEmployeeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateEmployeeDialog() {
		setTitle("Update Employee Details");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel EmployID_Label = new JLabel("Employee ID");
			GridBagConstraints gbc_EmployID_Label = new GridBagConstraints();
			gbc_EmployID_Label.insets = new Insets(0, 0, 5, 5);
			gbc_EmployID_Label.gridx = 2;
			gbc_EmployID_Label.gridy = 1;
			contentPanel.add(EmployID_Label, gbc_EmployID_Label);
		}
		{
			empid_textField = new JTextField();
			GridBagConstraints gbc_empid_textField = new GridBagConstraints();
			gbc_empid_textField.insets = new Insets(0, 0, 5, 0);
			gbc_empid_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_empid_textField.gridx = 5;
			gbc_empid_textField.gridy = 1;
			contentPanel.add(empid_textField, gbc_empid_textField);
			empid_textField.setColumns(10);
		}
		{
			JLabel FirstName_Label = new JLabel("FirstName");
			GridBagConstraints gbc_FirstName_Label = new GridBagConstraints();
			gbc_FirstName_Label.insets = new Insets(0, 0, 5, 5);
			gbc_FirstName_Label.gridx = 2;
			gbc_FirstName_Label.gridy = 2;
			contentPanel.add(FirstName_Label, gbc_FirstName_Label);
		}
		{
			fname_textField = new JTextField();
			GridBagConstraints gbc_fname_textField = new GridBagConstraints();
			gbc_fname_textField.insets = new Insets(0, 0, 5, 0);
			gbc_fname_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_fname_textField.gridx = 5;
			gbc_fname_textField.gridy = 2;
			contentPanel.add(fname_textField, gbc_fname_textField);
			fname_textField.setColumns(10);
		}
		{
			JLabel SurName_Label = new JLabel("SurName");
			GridBagConstraints gbc_SurName_Label = new GridBagConstraints();
			gbc_SurName_Label.insets = new Insets(0, 0, 5, 5);
			gbc_SurName_Label.gridx = 2;
			gbc_SurName_Label.gridy = 3;
			contentPanel.add(SurName_Label, gbc_SurName_Label);
		}
		{
			surname_textField = new JTextField();
			GridBagConstraints gbc_surname_textField = new GridBagConstraints();
			gbc_surname_textField.insets = new Insets(0, 0, 5, 0);
			gbc_surname_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_surname_textField.gridx = 5;
			gbc_surname_textField.gridy = 3;
			contentPanel.add(surname_textField, gbc_surname_textField);
			surname_textField.setColumns(10);
		}
		{
			JLabel Age_Label = new JLabel("Age");
			GridBagConstraints gbc_Age_Label = new GridBagConstraints();
			gbc_Age_Label.insets = new Insets(0, 0, 5, 5);
			gbc_Age_Label.gridx = 2;
			gbc_Age_Label.gridy = 4;
			contentPanel.add(Age_Label, gbc_Age_Label);
		}
		{
			Age_textField = new JTextField();
			GridBagConstraints gbc_Age_textField = new GridBagConstraints();
			gbc_Age_textField.insets = new Insets(0, 0, 5, 0);
			gbc_Age_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_Age_textField.gridx = 5;
			gbc_Age_textField.gridy = 4;
			contentPanel.add(Age_textField, gbc_Age_textField);
			Age_textField.setColumns(10);
		}
		{
			JLabel Dept_Label = new JLabel("Department");
			GridBagConstraints gbc_Dept_Label = new GridBagConstraints();
			gbc_Dept_Label.insets = new Insets(0, 0, 5, 5);
			gbc_Dept_Label.gridx = 2;
			gbc_Dept_Label.gridy = 5;
			contentPanel.add(Dept_Label, gbc_Dept_Label);
		}
		{
			Dept_textField = new JTextField();
			GridBagConstraints gbc_Dept_textField = new GridBagConstraints();
			gbc_Dept_textField.insets = new Insets(0, 0, 5, 0);
			gbc_Dept_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_Dept_textField.gridx = 5;
			gbc_Dept_textField.gridy = 5;
			contentPanel.add(Dept_textField, gbc_Dept_textField);
			Dept_textField.setColumns(10);
		}
		{
			JLabel Salary_Label = new JLabel("Salary_Label");
			GridBagConstraints gbc_Salary_Label = new GridBagConstraints();
			gbc_Salary_Label.insets = new Insets(0, 0, 5, 5);
			gbc_Salary_Label.gridx = 2;
			gbc_Salary_Label.gridy = 6;
			contentPanel.add(Salary_Label, gbc_Salary_Label);
		}
		{
			Salary_textField = new JTextField();
			GridBagConstraints gbc_Salary_textField = new GridBagConstraints();
			gbc_Salary_textField.insets = new Insets(0, 0, 5, 0);
			gbc_Salary_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_Salary_textField.gridx = 5;
			gbc_Salary_textField.gridy = 6;
			contentPanel.add(Salary_textField, gbc_Salary_textField);
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
						int empid=Integer.parseInt(empid_textField.getText());
						String FirstName= fname_textField.getText();
						String SurName= surname_textField.getText();
						int Age= Integer.parseInt(Age_textField.getText());
						String Department= Dept_textField.getText();
						Double Salary =Double.parseDouble(Salary_textField.getText());
						Employee empdetails= new Employee(empid,FirstName,SurName,Age,Department,Salary);
						try {
							employeeDAO.updateEmployee(empdetails);//Save to database
							setVisible(false);//Close dialog
							dispose();
							empframe.refreshEmpView();//refresh GUI list
							JOptionPane.showMessageDialog(empframe, "Employee updated successfully", "Employ updated", JOptionPane.INFORMATION_MESSAGE);
							//show success message
						} catch (Exception e1) {
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
