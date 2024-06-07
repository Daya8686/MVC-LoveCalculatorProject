<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Form</title>
<style type="text/css">
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

    h1 {
        color: #ff4081;
        margin-bottom: 20px;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    .form-container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 500px;
        width: 100%;
    }

    .form-container form {
        display: flex;
        flex-direction: column;
    }

    .form-container input, .form-container textarea {
        margin: 10px 0;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 16px;
    }

    .form-container input[type="submit"] {
        background: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        transition: background 0.3s;
    }

    .form-container input[type="submit"]:hover {
        background: #45a049;
    }

    .form-container label {
        font-weight: bold;
        margin-top: 10px;
    }
    .error {
	color: red;
	text-align: left;
	font-size: 12px;
}
</style>
</head>
<body>
<div class="form-container">
    <h1>Feedback Form</h1>
    <form:form action="submitFeedback" method="post" modelAttribute="userFeedback">
        <form:label path="userName">Your Name:</form:label>
        <form:input path="userName" placeholder="Enter Your Name" required="required" />
        <form:errors path="userName" cssClass="error"/>

        <form:label path="userEmail">Your Email:</form:label>
        <form:input path="userEmail" placeholder="Enter Your Email" required="required" />
		 <form:errors path="userEmail" cssClass="error"/>
		 
        <form:label path="feedbackMessage">Your Feedback:</form:label>
        <form:textarea path="feedbackMessage" placeholder="Your Feedback" rows="5"  required="required"></form:textarea>
		 <form:errors path="feedbackMessage" cssClass="error"/>
		 
        <input type="submit" value="Submit Feedback" />
    </form:form>
</div>
</body>
</html>
