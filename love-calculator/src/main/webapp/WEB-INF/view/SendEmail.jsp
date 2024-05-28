<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
}
h1 {
	text-align: center;
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
	width: 70%;
	margin-bottom: 10px;
	box-sizing: border-box;
}
.error {
	color: red;
	text-align: left;
}

</style>
</head>
<body>
	<h1>Hello</h1>
	<br>
	<h3>Send Result to your email</h3>
	<br>
	<form:form action="emailSent" modelAttribute="emailDTO">
	<label>Enter your email</label>
	<form:input path="userEmail" />
	<input type="submit" value="send">
	<br>
	<form:errors path="userEmail" cssClass="error"/>
	</form:form>
</body>
</html>