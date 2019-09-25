<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
	<fr:form action="changestudent" modelAttribute="student" cssstyle="padding-left:100px">
		<table style="width:75%" >
		  <tr>
		    <td>rno: </td>
		    <td><fr:input path="rno" readonly="true" 
		    /></td>
		    
		  </tr>
		  <tr>
		    <td>Name: </td>
		    <td><fr:input  path="name" /></td>
	    
		  </tr>
		  <tr>
		    <td>Branch:</td>
		    <td><fr:input  path="branch" /></td>
		    
		  </tr>
		  <tr>
		    <td>Semester:</td>
		    <td><fr:input  path="sem" /></td>
		    
		  </tr>
		  
		  <tr>
		    <td></td>
		    <td><button type="submit" name="submit">Update Book</button></td>
		    
		  </tr>
		</table>
		
	</fr:form>
	
</body>
</html>