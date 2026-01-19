<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.Employee.bean.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<h1>Update Form  -</h1>
<%Employee e=(Employee)session.getAttribute("updateEmployee") ;%>

<form action="updateEmployeeData">

 ID :<input type="text" name ="id" value="<%=e.getId() %>"  ><br><br>
   Name :<input type="text" name ="name" value="<%=e.getName() %>"><br><br>
    City :<input type="text" name ="city"  value="<%=e.getCity() %>"><br><br>
     Gender :<input type="text" name ="Gender"  value="<%=e.getGender() %>"><br><br>
      Address :<input type="text" name ="Address"  value="<%=e.getAddress() %>"><br><br>
       Password :<input type="text" name ="Password"  value="<%=e.getPassword() %>"><br><br>
       Email :<input type="text" name ="Email"  value="<%=e.getEmail() %>"><br><br>
       <button type="submit">Submit</button>
</form>



</body>
</html>