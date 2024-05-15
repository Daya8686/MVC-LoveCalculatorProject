<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
</head>
<body>
	<h1>Love Calculator</h1>
	<p>This are the values you have entered to register</p>
	<h3>SignUp details are:</h3>
	<p>name ${signUpInfo.name}</p>
	<p>userName ${signUpInfo.userName}</p>
	<p>password ${signUpInfo.password}</p>
	<p>Confirm password ${signUpInfo.cPassword}</p>
	<p>country ${signUpInfo.country}</p>
	<p>
		hobby :
		<c:forEach var="res" items="${signUpInfo.hobby}">
	${res}
</c:forEach>

	</p>
	<p>Gender ${signUpInfo.gender}</p>
</body>
</html>