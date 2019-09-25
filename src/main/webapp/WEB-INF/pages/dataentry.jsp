<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>

<html>
<body>
	<h3>Student-Entry-Form</h3>
		<fr:form action="savestudent" modelAttribute="student">
		<table style="width:75%" >
		  <tr>
		    <td>rno: </td>
		    <td><fr:input  path="rno" /></td>
		    <td><fr:errors path="rno">only digits allowed</fr:errors>
		  </tr>
		  <tr>
		    <td>Name: </td>
		    <td><fr:input  path="name" /></td>
	    	<td><fr:errors path="name"/>
		  </tr>
		  <tr>
		    <td>Branch:</td>
		    <td><fr:input  path="branch" /></td>
		    <td><fr:errors path="branch"/>
		  </tr>
		  <tr>
		    <td>Semester:</td>
		    <td><fr:input  path="sem" /></td>
		    <td><fr:errors path="sem">only digits allowed</fr:errors>
		  </tr>
		  
		  <tr>
		    <td></td>
		    <td><button type="submit" name="submit">Update Book</button></td>
		    
		  </tr>
		</table>
		</fr:form>
</body>
</html>