<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
<style>
#container {
    display: flex;
    justify-content: center; /* Centers content horizontally */
    margin-left:30%;
    height: 100vh; /* Optional: Set height to full viewport height */
}
h1{
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
.password {
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
.optionsAndcheckbox{
padding: 10px;
font-size: 20px;
margin: 10px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>

<body>
<h1>Love Calculator</h1>
	<div id="container">
		
		<form:form id="signUpForm" action="signupCheck" method="post" modelAttribute="signUpInfo">
			<label for=name>Name:</label><br>
			<form:input type="text" id="name" path="name" />
			<br>
			<label for=userName>User Name:</label><br>
			<form:input type="text" id="userName" path="userName" />
			<br>
			<label for=password>Password:</label><br>
			<form:password  class="password" path="password" />
			<br>
			<label for=cPassword>Confirm Password:</label><br>
			<form:password  class="password" path="cPassword" />
			<br>
			<label for="country">Country:</label>
			<form:select path="country" class="optionsAndcheckbox">
				<form:option value="India">India</form:option>
				<form:option value="USA">USA</form:option>
				<form:option value="Australia">Australia</form:option>
			</form:select>
			<br>
			<label for="hobby">Hobby:</label>
			<form:checkbox path="hobby" value="Reading" class="optionsAndcheckbox"/> Reading 
			<form:checkbox path="hobby" value="Programming" class="optionsAndcheckbox"/> Programming 
			<form:checkbox path="hobby" value="Cooking" class="optionsAndcheckbox" /> Cooking 
			<form:checkbox path="hobby" value="Sports" class="optionsAndcheckbox" /> Sports <br>
			<label for="gender">Gender:</label>
			<form:radiobutton path="gender" value="Male" label="Male" class="optionsAndcheckbox" />
			<form:radiobutton path="gender" value="Female" label="Female" class="optionsAndcheckbox" />

			<br> <input type="submit" value="Register">

		</form:form>
	</div>

</body>
</html>