<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill Info</title>
</head>
<style>
h1 {
	font-size: 50px;
	display: flex;
	flex-direction: column;
	align-items: center;
}
p{
font-size: 20px;
}
</style>
<body>
	<h1>Bill Info</h1>
	<p>BILL AGAINST THE CREDIT CARD NUMBER ${billInfo.creditCard} for
		an amount of ${billInfo.amount} has been generated ${billInfo.date}</p>

</body>
</html>