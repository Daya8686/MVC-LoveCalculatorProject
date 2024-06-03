<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Bill Page</title>
</head>
<style>
h1 {
	font-size: 50px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

input[type="text"] {
	padding: 8px;
	width: 70%;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="number"] {
	padding: 8px;
	width: 70%;
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

div>form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: auto;
}

.error {
	color: red;
	text-align: left;
}
</style>
<body>
	<h1>Bill</h1>
	<div>

		<br> <br>
		<form:form action="billDetails" method="POST"
			modelAttribute="billInfo">
			<label>Credit Card Number:</label>
			<br>
			<form:input path="creditCard" />
			<form:errors path="creditCard" />
			<br>
			<label>Total bill Amount</label>
			<br>
			<form:input path="amount" />
			<br>
			<form:errors path="amount" />
			<br>
			<label>Purchase Date: </label>
			<br>
			<form:input path="date" />
			<br>
			<form:errors path="date" class="error" />
			<input type="submit" value="Pay">
		</form:form>
	</div>
</body>
</html>