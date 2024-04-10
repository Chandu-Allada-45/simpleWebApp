package com.simpleWebApp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.simpleWebApp.model.Employee;
import com.simpleWebApp.util.DBConnection;

public class EmployeeDAO {
	private Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
	private Connection db = DBConnection.getInstance();
	public Employee getEmployee(int emp_id) {
		Employee emp = new Employee();
		try {			
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("select * from employee_table where id = "+emp_id);
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setDomain(rs.getString("domain"));
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return emp;	
	}
	
	public String addEmployeee(Employee e) {
		int i = 0;
		try {
			Statement st = db.createStatement();
			String name = e.getName()==null?"": e.getName();
			i = st.executeUpdate("insert into employee_table values (" + e.getId() +",\"" +
			name + "\",\"" +e.getDomain()+"\")");
			st.close();
		} catch (SQLException e1) {
			logger.log(Level.SEVERE, e1.getMessage());
		}
		return i!=0?"success":"failure";
	}
	
	public String updateEmployeee(Employee e) {
		int i = 0;
		try {
			Statement st = db.createStatement();
			String name = e.getName()==null?"": e.getName(), query = "update employee_table set name = \""+ name
					+"\", domain = \"" +
					e.getDomain()+"\" where id = " + e.getId();
			i = st.executeUpdate(query);
			st.close();
		} catch (SQLException e1) {
			logger.log(Level.SEVERE, e1.getMessage());
		}
		return i!=0?"success":"failure";
	}

}
