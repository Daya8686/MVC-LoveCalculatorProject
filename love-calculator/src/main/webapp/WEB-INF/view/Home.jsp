<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculation Application</title>
<style>
#outerContainer {
	display: flex;
	flex-direction: column;
	align-items: center;
	background: rgba(0, 0, 0, 0.7);
	height: 500px;
	width: auto;
	margin-left: 300px;
	margin-right: 300px;
	border-radius: 10px;
}

.container {
	width: 90%;
	display: flex;
	justify-content: center;
	height: 400px;
	align-items: center;
	text-align: center;
}

h1 {
	color: white;
}

form {
	width: 100%;
}

label {
	font-family: Arial, sans-serif;
	font-size: 20px;
}

input[type="text"] {
	padding: 8px;
	width: 100%;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div id="outerContainer">
		<h1>Love Calculator</h1>
		<hr />
		<div class="container">
			<form:form id="loveForm" action="processData" method="post" modelAttribute="userInfoDefault">
				<label for="yourName:">Your Name:</label><br>
				 <form:input type="text" id="yourName" path="yourName"/>
				 <br>
				<label for="crushName:">Crush Name:</label><br>
				 <form:input type="text" id="crushName" path="crushName" />
				 <br>
				<br> <input type="submit">
			</form:form>
		</div>
	</div>

</body>
</html>