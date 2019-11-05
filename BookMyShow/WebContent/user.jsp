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
	margin-top:90px;
}
form{
	//margin-top:25vh;
}
input{
	outline: none;
    border: none;
    border-bottom: 2px solid rgb(185, 26, 26);
    padding: 3px 10px;
    font-size: 22px;
}
.loginDiv{
	//border: 2px solid;
    margin-top: 22vh;
    padding:6vh;
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
<header>
<img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="index.jsp" class="headerEle">HOME</a></header>
<section class=section1>
<center>
<div class="loginDiv">
 	<form action="login" method="post">
        <input type="text" name="Username" placeholder="Username" required><br><br>
        <input type="password" name="Password" placeholder="Password" required><br><br>
        <input type="submit" class="" id="submitt" value="login">
    </form><br><br><br>
    create a new account.
    <a href="signUp.jsp" id="signUp">SIGN UP</a>
    <p></p>
</div>    
</center>
</section>
</body>
</html>