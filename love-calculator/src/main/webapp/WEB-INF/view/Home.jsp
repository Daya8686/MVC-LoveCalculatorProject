<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculation Application</title>
<script type="text/javascript">
	function validateInput() {
		var yourName = document.getElementById("yourName").value;
		var crushName = document.getElementById("crushName").value;
		if (yourName.length == 0 || crushName.length == 0) {
			alert("Your Name Or Crush Name can not be left empty!");
			return false;
		} else if (yourName.length < 3 || crushName.length < 3) {
			alert("Your Name Or Crush Name must contain atleast 3 Characters");
			return false;
		} else {
			var res;
			var termsAndCondition = document
					.getElementById("termsAndCondition").checked;
			console.log(termsAndCondition);
			if (!termsAndCondition) {
				alert("You need to accept the terms and conditions to proceed");
				res = false;
			} else {
				res = true;
			}
			return res;
		}

	}
</script>
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
	color: white;
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

.error {
	color: red;
	text-align: left;
}
</style>
</head>
<body>
	<div id="outerContainer">
		<h1>Love Calculator</h1>
		<hr />
		<div class="container">
			<form:form id="loveForm" action="processData" method="post" modelAttribute="userInfo" onsubmit="return validateInput()">
				<label for="yourName:">Your Name:</label>
				<br>
				<form:input id="yourName" path="yourName" />
				<form:errors path="yourName" class="error" />
				<br>
				<label for="crushName:">Crush Name:</label>
				<br>
				<form:input id="crushName" path="crushName" />
				<form:errors path="crushName" class="error" />
				<br>
				<form:checkbox path="termsAndCondition" id="termsAndCondition" />
				<label for="termsAndCondition">Agreeing Terms and
					Conditions<i>(This is only for fun)</i>
				</label>
				<br>
				<form:errors path="termsAndCondition" class="error"  />
				<br><br/>
				<input type="submit" value="calculate">
			</form:form>
		</div>
	</div>

</body>
</html>