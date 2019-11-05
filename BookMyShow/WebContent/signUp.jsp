<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookMyShow</title>
<link rel="icon" type="text/css" href="myImg/icon.png">
<style>
*{
	margin:0;
	padding:0;
}
header{
	background-color: rgb(185, 26, 26);
	border-bottom:3px solid white;
	height:80px;
	position:fixed;
	top:0px;
	width:100%;
}

.headerEle{
	float: right;
    color: white;
    cursor: pointer;
    text-decoration: none;
    position: relative;
    margin-right: 20px;
    margin-top: 30px;
    padding: 0.1%;
	
}
.headerEle:hover{
	border-bottom:2px solid white;
}
#bookMyShow{
	color: white;
    position: relative;
    cursor: pointer;
    top: 9%;
    font-size: 25px;
    left: 4%;
}
#icon1{
	height: 50%;
    position: relative;
    top: 25%;
    left: 3%;
    
}
.section1{
	margin-top:190px;
}
#submit{
	outline:none;
}
form{
	margin-top:18vh;
}
input{
	outline: none;
    border: none;
    border-bottom: 2px solid rgb(185, 26, 26);
    padding: 3px 10px;
    font-size: 22px;
}
#submitt{
	text-decoration: none;
    border: 3px solid rgb(185, 26, 26);
    position: relative;
    top: 10px;
    padding: 5px 34px;
    border-radius: 25px;
    font-size: 22px;
    color: rgb(185, 26, 26);
    outline:none;
    cursor:pointer;
    background-color:white;
}
 
#submitt:hover{
	color:white;
	background-color:rgb(185, 26, 26);
} 

</style>
</head>
<body>
<header><img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="user.jsp" class="headerEle">Home</a>
</header>
<section class=section1>
<center>
<form method="post" action="signUp" >
	<input type="text" name="name" placeholder="enter your name" required><br><br>
	<input type="email" name="email" placeholder="enter your email" required><br><br>
	<input type="tel" name="mobileNo" placeholder="enter your mobileNo" required><br><br>
	<input type="password" name="password" placeholder="password" required><br><br>
	<input type="submit" value="submit" id="submitt">
</form>
</center>
</section>
</body>
</html>