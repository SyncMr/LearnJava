<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC - HelloWeb Index Page</title>
</head>
<body>
 
	<center>
		<h2>Hello Web</h2>
		<h3>
			<a href="hello?name=Anit">Click Here</a>
		</h3>
	</center>
	
    <table>
       <tr>
           <td><label> Enter the password to enter: </label></td>
           <td><input type="password" name="password"/></td>
       </tr>
       <tr>
           <td></td>
           <td><input type="submit" value="Enter"/></td>
           <a href="LoginServlet?name=password">Enter</a>
       </tr>
   </table>  
</body>
</html>