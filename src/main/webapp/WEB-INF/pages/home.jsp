<%@page import="com.boot.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<header style="height: 30px;background-color: yellow;">
</header>

<div class="container">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
 
 <h2 style="background-color: fuchsia;">Home Page!!!
  <a href="cauth">Logout</a>
 </h2>
 <hr/>
    
    <table class="table table-bordered">
    <thead>
      <tr>
        <th>SNO</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>
        <a href="sortByEmail?orderBy=${corderBy}">
            Email
        </a>
        </th>
         <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <h1>Coming soon!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>
 
     <%
     List<Employee> employeesList=(List<Employee>)request.getAttribute("employees");
     
     if(employeesList==null){
    	 employeesList=new ArrayList<>();
     }
     int count=1;
     for(Employee employee : employeesList){
     %>
      <tr>
      <td><%=count++%></td>
        <td><%=employee.getFirstName()%></td>
        <td><%=employee.getLastName()%></td>
        <td><%=employee.getEmail() %></td>
        <td>
          <a href="deleteEmployee?email=<%=employee.getEmail() %>">
              <button type="button" class="btn btn-danger">Del!</button>
         </a>
         </td>
      </tr>
      <%
      } %> 
     
    </tbody>
  </table>
 </div>
</body>
</html>