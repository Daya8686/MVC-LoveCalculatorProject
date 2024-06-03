<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love Calculation Result</title>
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

    .result-container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 500px;
        width: 100%;
    }

    h1 {
        color: #ff4081;
        margin-bottom: 20px;
    }

    h3 {
        color: #333;
        margin-bottom: 20px;
    }

    p {
        color: #555;
        margin: 10px 0;
    }

    h4 {
        color: #ff4081;
        margin: 20px 0;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background 0.3s;
    }

    a:hover {
        background: #45a049;
    }
</style>
</head>
<body>
<div class="result-container">
    <h1>Result</h1>
    <h3>This is the result...... don't take it seriously, it's just for fun 😁😁</h3>
    <p>You Entered Your Name: ${userInfo.yourName}</p>
    <p>You Entered your Crush's Name: ${userInfo.crushName}</p>
    <h4>Relation is (•ˋ _ ˊ•)</h4>
    <h3>Friends</h3>
    <a href="/love-calculator/sendEmail">Send The Result To Your Email!</a>
</div>
</body>
</html>
