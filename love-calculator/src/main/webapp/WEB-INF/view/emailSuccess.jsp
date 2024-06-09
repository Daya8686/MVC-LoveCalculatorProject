<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Sent</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f0f0;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .message-container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 50%;
        max-width: 500px;
        min-width: 300px;
    }

    h1 {
        color: #ff4081;
        margin-bottom: 20px;
    }

    h3 {
        color: #333;
        margin-bottom: 20px;
    }

    a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <div class="message-container">
        <h1>Hello ${userGenderwithName}</h1>
        <h3>Successfully sent the result to ${emailDTO.userEmail}</h3>
        <a href="<c:url value='/' />">Back to Calculator</a><br>
        <a href="<c:url value="/feedback" />">Send Feedback </a>
    </div>
</body>
</html>
