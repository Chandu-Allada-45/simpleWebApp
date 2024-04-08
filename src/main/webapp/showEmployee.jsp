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
<b>ID     : <%=emp_id %> </b> <input type='hidden' name='emp_id' value='<%=emp_id %>'> <br /> <br />
<b>NAME   : </b> <input type='text' name='emp_name' value='<%=emp_name %>' required> <br /> <br />
<b>DOMAIN : </b> <input type='text' name='emp_domain' value='<%=emp_domain %>'> <br /> <br />
<input type='hidden' name='action' value='update'> <br /> <br />
<input type='submit' value='Update Employee'>
</form>
<% } else {
%>
<h3 style="color:red">Employee not found!! Please add if needed.</h3>
<form action='employee' method='post'>
<b>ID     : </b> <input type='text' name='emp_id'> <br /> <br />
<b>NAME   : </b> <input type='text' name='emp_name' required> <br /> <br />
<b>DOMAIN : </b> <input type='text' name='emp_domain'> <br /> <br />
<input type='hidden' name='action' value='insert'> <br /> <br />
<input type='submit' value='Add Employee'>
</form>
<%
}
%>
</div>
</body>
</html>
