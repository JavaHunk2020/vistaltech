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

<script type="text/javascript">
	function sendLink(){
		document.forms[0].action="passwordReset";
		document.forms[0].submit();
	}
</script>

</head>
<body>
<header style="height: 30px;background-color: yellow;">
</header>

<div class="container">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEN001Q5AoJ2REqLeVFIjweNX-DXvXVA1FDA&s"/>
 
 <h2 style="background-color: fuchsia;">Login Page!!!</h2>
 <hr/>
 
   <form name="loginForm" action="cauth" method="post">
     <div style="width: 50%">
	   <h4>Email :</h4>
	   <input required="required" type="text" class="form-control" name="email"/> 
	    <br/>
	    <h4>Password :</h4>
	   <input required="required" type="password" class="form-control"  name="ppassword"/> 
	   <br/>
	   <button type="submit" name="gogo" value="Validate" class="btn btn-primary">Validate!</button>
	   <a href="signup">
	        <button type="button" class="btn btn-warning">Signup!</button>
	   </a>
	   &nbsp;&nbsp;
	    <button onclick="sendLink();" type="button" name="gogo" value="Reset" class="btn btn-danger">Reset Password!</button>
	   </div>
   </form>
   <hr/>
   <b>${message}</b>
 </div>
</body>
</html>