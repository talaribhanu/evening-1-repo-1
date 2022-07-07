<%@ page contentType="text/html; charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>


	<head>
		<title>My First JSP</title>
	</head>
	
	<body>
		<a href="/logout">Logout</a>
		<h1>Welcome Content</h1>
		
		<form action="/addstudent" method = "GET">
		<label>Student Id</label>
		<input type = "number" name = "id" required>
		<br>
		<label>Age</label>
		<input type = "number" name = "age" required>
		<br>
		<label>FirstName</label>
		<input type = "text" name = "firstname" required>
		<br>
		<label>LastName</label>
		<input type = "text" name = "lastname" required>
		<br>
		
		<button type = "submit">AddStudent</button>
		
		</form>
		<c:forEach items = "${message}" var = "temp">
			<p>
				${temp.getId()}
				<br>
				${temp.getFirstName()}
				
				<a href = "delete?id=${temp.getId() }">Delete</a>
				<hr>
			</p>	
		</c:forEach>	
	</body>



</html>