<html>
<body>
<div align="center">
<% String message = request.getAttribute("message").toString(),
operation = request.getAttribute("operation").toString();
if(message == "success") {
 %>
<h2 style="color:green"> <%= operation %> of Employee Successful!!!</h2>
<% } else { %>
<h2 style="color:red"> <%= operation %> of Employee Failed!!! Please try again later.</h2>
<% } %>
<form action="/simpleWebApp">
<input type="submit" value="Home">
</form>
</div>
</body>
</html>
