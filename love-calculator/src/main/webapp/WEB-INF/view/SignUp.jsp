<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love Calculator</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh; /* Use min-height instead of height */
	background-color: #f0f0f0;
	margin: 0;
	font-family: Arial, sans-serif;
}

#container {
	display: flex;
	flex-direction: column;
	align-items: center;
	background: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	width: 90%;
	max-width: 1000px;
	margin-top: 20px;
	/* Add margin-top to create space between content and container */
}

h1 {
	color: #333;
	text-align: center;
	margin-bottom: 20px;
}

form {
	width: 100%;
}

label {
	font-size: 16px;
	color: #333;
	display: inline-block;
	margin-top: 10px;
}

input[type="text"], input[type="password"] {
	padding: 10px;
	width: calc(100% - 22px);
	
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	padding: 12px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
	width: 100%;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.optionsAndcheckbox {
	padding: 10px;
	font-size: 16px;
	margin: 10px 0;
}

.error {
	color: red;
	text-align: left;
	font-size: 12px;
}

h3 {
	color: #333;
	text-align: center;
	margin-top: 20px;
}

.form-section {
	margin-bottom: 20px;
}
</style>
</head>

<body>

	<div id="container">
		<h1>Love Calculator</h1>
		<form:form id="signUpForm" action="signupCheck" method="post"
			modelAttribute="signUpInfo">
			<label for=name>Name:</label>
			<br>
			<form:input type="text" id="name" path="name" />
			<br>
			<form:errors path="name" class="error" />
			<br>
			<label for=userName>User Name:</label>
			<br>
			<form:input type="text" id="userName" path="userName" />
			<br>
			<form:errors path="userName" class="error" />
			<br>
			<label for=password>Password:</label>
			<br>
			<form:password class="password" path="password" />
			<br>
			<label for=cPassword>Confirm Password:</label>
			<br>
			<form:password class="password" path="cPassword" />
			<br>
			<label for="country">Country:</label>
			<form:select path="country" class="optionsAndcheckbox">
				<form:option value="India">India</form:option>
				<form:option value="USA">USA</form:option>
				<form:option value="Australia">Australia</form:option>
			</form:select>
			<br>
			<label for="hobby">Hobby:</label>
			<form:checkbox path="hobby" value="Reading"
				class="optionsAndcheckbox" /> Reading 
			<form:checkbox path="hobby" value="Programming"
				class="optionsAndcheckbox" /> Programming 
			<form:checkbox path="hobby" value="Cooking"
				class="optionsAndcheckbox" /> Cooking 
			<form:checkbox path="hobby" value="Sports" class="optionsAndcheckbox" /> Sports <br>
			<label for="gender">Gender:</label>
				<form:radiobutton path="gender" value="Male" label="Male"
					class="optionsAndcheckbox" />
				<form:radiobutton path="gender" value="Female" label="Female"
					class="optionsAndcheckbox" />
			<br>
			<label>Age: </label>
			<form:input path="age" />
			
			<form:errors path="age" class="error" />
			<br>
			
			<h3>Communication details</h3>
			
			<label>Email:</label>
			<br>
			<form:input path="communicationDetails.email" />
			<br>
			<form:errors path="communicationDetails.email" class="error" />

			<br>
			<label>Mobile no:</label>
			<br>
			<form:input path="communicationDetails.phone" />
			<br>
			<form:errors path="communicationDetails.phone.mobileNumber"
				class="error" />
			<br>
			<form:errors path="communicationDetails.phone.countryCode"
				class="error" />


			<br>
			<input type="submit" value="Register">

		</form:form>
		
		
	</div>

</body>
</html>