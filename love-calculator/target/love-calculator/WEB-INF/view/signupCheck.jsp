<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    h3 {
        color: #333;
    }

    p {
        margin: 5px 0;
    }

    .output-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        margin: 0 auto;
    }
</style>
</head>
<body>
	<h1>Love Calculator</h1>
	<div class="output-container">
		<p>This are the values you have entered to register</p>
		<h3>SignUp details are:</h3>
		<p>name ${signUpInfo.name}</p>
		<p>userName ${signUpInfo.userName}</p>
		<p>password ${signUpInfo.password}</p>
		<p>Confirm password ${signUpInfo.cPassword}</p>
		<p>country ${signUpInfo.country}</p>
		<p>hobby :
			<c:forEach var="res" items="${signUpInfo.hobby}">
				${res}
			</c:forEach>
		</p>
		<p>Age: ${signUpInfo.age}</p>
		<p>Gender ${signUpInfo.gender}</p>
		<p>Email: ${signUpInfo.communicationDetails.email}</p>
		<p>Mobile: ${signUpInfo.communicationDetails.phone}</p>
	</div>
</body>
</html>
