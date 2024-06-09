<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Result to Your Email</title>
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

    .form-container {
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

    label {
        font-family: Arial, sans-serif;
        font-size: 20px;
        color: #333;
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"] {
        padding: 8px;
        width: 80%;
        margin-bottom: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
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
    <div class="form-container">
        <h1>Hello ${userGenderwithName}</h1>
        <h3>Send Result to Your Email</h3>
        <form:form action="emailSent" modelAttribute="emailDTO">
            <label>Enter Your Email</label>
            <form:input path="userEmail" placeholder="abc@gmail.com"/>
            <br>
            <form:errors path="userEmail" cssClass="error"/>
            <br>
            <input type="submit" value="Send">
            
        </form:form>
    </div>
</body>
</html>
