package com.simpleWebApp.controller;

import java.io.IOException;

import com.simpleWebApp.dao.EmployeeDAO;
import com.simpleWebApp.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		EmployeeDAO ed = new EmployeeDAO();
		Employee e = ed.getEmployee(emp_id);
		
		request.setAttribute("emp_id", e.getId());
		request.setAttribute("emp_name", e.getName());
		request.setAttribute("emp_domain", e.getDomain());

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showEmployee.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Employee e = new Employee();
		EmployeeDAO ed = new EmployeeDAO();
		e.setId(Integer.parseInt(request.getParameter("emp_id")));
		e.setName(request.getParameter("emp_name"));
		e.setDomain(request.getParameter("emp_domain"));
		String action = request.getParameter("action"),msg = "";
		
		if("update".equals(action)) {
			request.setAttribute("operation", "UPDATE");
			msg = ed.updateEmployeee(e);
		}else if ("insert".equals(action)) {
			request.setAttribute("operation", "ADD");
			msg = ed.addEmployeee(e);
		}
		
		request.setAttribute("message", msg);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}
}
