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
body{
	background-color:white;
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
.movieImage{
	height: 50vh;
    width: 24%;
    display: inline-block;
    margin: 15vh 1%;
    background-color:black;
    cursor:pointer;
}
#movieImage1{
	margin-left:12.5%;
}
.movieImg{
	height: 100%;
    width: 100%;
    opacity:0.5;
    transition: all 0.5s;
}
.movieImg:hover{
	opacity:1;
}

</style>
</head>
<body>
<header>
<img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="admin.jsp" class="headerEle">ADMIN</a>
<a href="user.jsp" class="headerEle">USER</a>
</header>
<section class=section1>
	<a href="user.jsp" ><div class="movieImage" id="movieImage1"><img alt="movie1" src="myImg/movieImg1.jpg" class="movieImg"></div></a>
	<a href="user.jsp" ><div class="movieImage"><img alt="movie2" src="myImg/movieImg2.jpg" class="movieImg"></div></a>
	<a href="user.jsp" ><div class="movieImage"><img alt="movie3" src="myImg/movieImg3.jpg" class="movieImg"></div></a>
</section>
</body>
</html>