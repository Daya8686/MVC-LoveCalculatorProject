<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love Calculation Result</title>

<script type="text/javascript">
function myImageLoader(relationName){
	console.log(relationName);
	console.log(relationName.toLowerCase() == 'enemies');
	var imageUrl;
	if(relationName.toLowerCase() === 'friends'){
		 imageUrl = "<c:url value='/Static/images/friends.png'/>";
	} else if(relationName.toLowerCase() === 'love'){
		 imageUrl = "<c:url value='/Static/images/loveCalculator.png'/>";
	}
	else if(relationName.toLowerCase() === 'enemies'){
		 imageUrl = "<c:url value='/Static/images/enemy.png'/>";
	}
	else if(relationName.toLowerCase() === 'marriage'){
		 imageUrl = "<c:url value='/Static/images/Marriage.webp'/>";
	}
	else if(relationName.toLowerCase() === 'affection'){
		 imageUrl = "<c:url value='/Static/images/Affection.png'/>";
	}
	else if(relationName.toLowerCase() === 'sister'){
		 imageUrl = "<c:url value='/Static/images/Sister.png'/>";
	}
	else {
		 imageUrl = "<c:url value='/Static/images/relation.png'/>";
	}
	let myImg = document.createElement("img");
	myImg.setAttribute("src", imageUrl);
	myImg.setAttribute("alt", "Relation Image");
	myImg.setAttribute("width", "300px");
	myImg.setAttribute("height", "250px");
	let innerDiv=document.querySelector(".inner-div");
	innerDiv.append(myImg);
	
}

window.onload = function() {
    myImageLoader("${userInfo.relationResult}");
}
</script>

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
<div class="result-container" onload="myImageLoader(${userInfo.relationResult})">
    <h1>Result</h1>
    <h3>This is the result...... don't take it seriously, it's just for fun 😁😁</h3>
    <p>You Entered Your Name: ${userInfo.yourName}</p>
    <p>You Entered your Crush's Name: ${userInfo.crushName}</p>
    <h4>Relation is (•ˋ _ ˊ•)</h4>
    <h3>${userInfo.relationResult}</h3>
    <div class="inner-div">
    </div>
    

     <a href="<c:url value="/sendEmail" />">Send The Result To Your Email!</a>
     <!-- This c tags are used to parse the URL and with this we can give only the jsp page uri without
     context and this will carry the cookies with in url if and only if cookies are disabled by user or else 
     it will not carry the cookies with url -->
</div>
</body>
</html>
