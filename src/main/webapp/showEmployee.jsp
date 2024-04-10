<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div align="center">
<h2>Employee Details</h2>
<%
String emp_id = request.getAttribute("emp_id").toString();
String emp_name = request.getAttribute("emp_name") == null ? "" : request.getAttribute("emp_name").toString();
String emp_domain = request.getAttribute("emp_domain") == null ? "" : request.getAttribute("emp_domain").toString();
if(emp_name != ""){ %>
<form action='employee' method='post'>
<table>
<tr><td><b>ID     </b></td> <td>: <b><%=emp_id %></b><input type='hidden' name='emp_id' value='<%=emp_id %>'></td></tr>
<tr><td><b>NAME   </b></td> <td>: <input type='text' name='emp_name' value='<%=emp_name %>' required></td></tr>
<tr><td><b>DOMAIN </b></td> <td>: <input type='text' name='emp_domain' value='<%=emp_domain %>'></td></tr>
<tr><td colspan=2><input type='hidden' name='action' value='update'></td></tr>
<tr><td colspan=2 align="center"><input type='submit' value='Update Employee'></td></tr>
</table>
</form>
<% } else {
%>
<h3 style="color:red">Employee not found!! Please add if needed.</h3>
<form action='employee' method='post'>
<table>
<tr><td><b>ID     </b></td> <td>: <input type='text' name='emp_id'></td></tr>
<tr><td><b>NAME   </b></td> <td>: <input type='text' name='emp_name' required></td></tr>
<tr><td><b>DOMAIN </b></td> <td>: <input type='text' name='emp_domain'></td></tr>
<tr><td colspan=2><input type='hidden' name='action' value='insert'></td></tr>
<tr><td colspan=2 align="center"><input type='submit' value='Add Employee'></td></tr>
</table>
</form>
<%
}
%>
</div>
</body>
</html>
