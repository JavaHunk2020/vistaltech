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
  <%
  for(int x=1;x<=2;x++) {
	 %>
    <h1>Welcome JSP!!!!!!!!!!!!!!!<span style="background-color: yellow;"><%=x%></span>!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>
 <%} %>
 <a href="hola">CALL SERVLET</a>
 <hr/>
   <form action="hola">
	   <h4>Name :</h4>
	   <input type="text" name="pname"/> 
	    <br/><br/>
	   <button type="submit" class="btn btn-primary">Go!</button>
   </form>
   <hr/>
   <b>${message}</b>
 </div>
</body>
</html>