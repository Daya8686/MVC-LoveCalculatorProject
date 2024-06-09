<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
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
      h1 {
        color: Black;
        margin-bottom: 20px;
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
<h1>Something Went Wrong</h1>
<p>Unable to Send Feedback 🫠.</p><br>
<p>Please Check your details !!</p>
 <a href="<c:url value='/' />">Back to Calculator</a><br>
</div>
</body>
</html>