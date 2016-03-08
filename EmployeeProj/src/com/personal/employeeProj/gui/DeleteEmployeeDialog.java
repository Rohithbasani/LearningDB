package com.personal.employeeProj.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.personal.jdbc.employeeproj.DAO.EmployeeDAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField EmpID_textField;
	private EmployeeDAO employDAO;
	private EmployeeFrame Empframe;
	public DeleteEmployeeDialog(EmployeeFrame theEmployApp,EmployeeDAO theEmployDAO){
		this();
		Empframe=theEmployApp;
		employDAO=theEmployDAO;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteEmployeeDialog dialog = new DeleteEmployeeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteEmployeeDialog() {
		setTitle("Delete Employee");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Enter Employee ID to delete");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			EmpID_textField = new JTextField();
			GridBagConstraints gbc_EmpID_textField = new GridBagConstraints();
			gbc_EmpID_textField.insets = new Insets(0, 0, 0, 5);
			gbc_EmpID_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_EmpID_textField.gridx = 2;
			gbc_EmpID_textField.gridy = 2;
			contentPanel.add(EmpID_textField, gbc_EmpID_textField);
			EmpID_textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int empToDelete= Integer.parseInt(EmpID_textField.getText());
						try{
						employDAO.deleteEmployee(empToDelete);
						setVisible(false);
						dispose();
						Empframe.refreshEmpView();//refresh GUI list
						JOptionPane.showMessageDialog(Empframe, "Employee deleted successfully", "Employ deleted", JOptionPane.INFORMATION_MESSAGE);
						//show success message
					} catch(Exception exec) {
						// TODO Auto-generated catch block
						exec.printStackTrace();
					}	
						
					}});
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
