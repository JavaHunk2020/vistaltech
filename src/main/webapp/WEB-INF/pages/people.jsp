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
 
 <h2 style="background-color: fuchsia;">People Page!!!</h2>
 <hr/>
      <b>${message}</b>
   <form name="loginForm" action="people" method="post">
     <div style="width: 50%">
	   <h5>Email :</h5>
	   <input required="required" type="text" class="form-control" name="email"/> 
	    <br/>
	    <h5>Name :</h5>
	   <input required="required" type="text" class="form-control"  name="name"/> 
	   <br/>
	    <h5>Gender :</h5>
	   <select class="form-control"  name="gender">
	       <option>Male</option>
	       <option>Female</option>
	   </select> 
	   <br/>
	   <button type="submit" name="gogo" value="Validate" class="btn btn-primary">Save!</button>
	   &nbsp;&nbsp;
	    <button onclick="sendLink();" type="button" name="gogo" value="Reset" class="btn btn-danger">Reset </button>
	   </div>
   </form>
   <hr/>

 </div>
</body>
</html>