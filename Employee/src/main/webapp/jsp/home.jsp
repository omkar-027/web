<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
     <%@page import="com.Employee.bean.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>

<style>
table, th, td {
  border: 3px solid;
}
</style>
</head>
<body>

<h1>Home page</h1>

<% List <Employee> list = (List)session.getAttribute("Employee"); %>

<%String name =(String) session.getAttribute("loginname"); %>

<%if (name==null){ %>
 <h1>login Here</h1>
  <%} else{ %>
  <h1><%=name %></h1>
  
  <form action="logout">
    <button type="submit">LOGOUT</button>
    </form>
    
    <%} %>

<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
     <th>City</th>
      <th>Gender</th>
       <th>Address</th>
        <th>Password</th>
        <th>Email</th>
  </tr>
<%for(Employee e : list) { %>
<tr>
 <td><%=e.getId() %></td>
<td><%=e.getName() %></td>
<td><%=e.getCity() %></td>
<td><%=e.getGender() %></td>
<td><%=e.getAddress() %></td>
<td><%=e.getPassword() %></td>
<td><%=e.getEmail() %></td>

<td>

<form action="updateEmployee">

 <input type="hidden" name ="id" value="<%=e.getId() %>">
   <input type="hidden" name ="name" value="<%=e.getName() %>">
    <input type="hidden" name ="city" value="<%=e.getCity() %>">
     <input type="hidden" name ="Gender" value="<%=e.getGender() %>">
      <input type="hidden" name ="Address" value="<%=e.getAddress() %>">
       <input type="hidden" name ="Password" value="<%=e.getPassword() %>">
       <input type="hidden" name ="Email" value="<%=e.getEmail() %>">
     <button type="submit">Update</button>

</form>
</td>
<td>


    <form action="deleteEmployee">
       <input type="hidden" name="id" value="<%= e.getId() %>">
       <button type="submit">Delete</button>
    
    </form>
    </td>
</tr>
<%} %>
</table>

<a href="login">Login</a>

</body>
</html>