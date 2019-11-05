<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookMyShow</title>
<style type="text/css">
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
section{
	margin-top:120px;
}
input{
	margin:6px;
}
input{
	outline:none;
	border:none;
}
#card{
	border: 1px solid;
    border-radius: 16px;
    width: 300px;
    padding: 15px;
    background:linear-gradient(-57deg, #DADEE3 50%, #D2D6DE 50%);
}
.label{
    float: left;
    margin-left: 20px;
}
.cardNo, .cardHolder{
	width: 75%;
    padding: 5px 20px;
}

#nextButton, #backButton,#proceedButton{
	padding: 6px 20px;
    margin: 20px 10px 50px 10px;
    font-size: 22px;
    border-radius: 13px;
    border: 2px solid rgb(185,26,26);
    color: rgb(185,26,26);
    background-color: white;
    cursor: pointer;
    text-decoration:none;
}
#nextButton:hover, #backButton:hover, #proceedButton:hover{
	background-color:rgb(185,26,26);
	color:white;
}
#pin{
	border: none;
    outline: none;
    font-size: 22px;
    border-bottom: 2px solid rgb(185,26,26);
    padding: 5px 20px;
}
</style>
</head>
<body>
<header>
<img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="logOut" class="headerEle">LOG OUT</a></header>
<center>
	<section>
	 <%
		String foodCost=request.getParameter("foodCost");
		String FoodName=request.getParameter("FoodName");
		
	%> 
	
	<form method=post action=ticket>
	<h2 id=h21>Enter card details</h2>
	<div id=card>
		<label class=label>Card Number</label><br>
		<input type=number name=cardNo placeholder="Card NO" class=cardNo required ><br>
		<label class=label>Name</label><br>
		<input type=text name=cardHolder placeholder="Name of cardholder" class=cardHolder required  ><br>
		<label>Expiry</label>
		<input type=month name=expiry  class=expiry   required ><br>
		<label>CVV</label>
		<input type=number name=cvv placeholder="CVV" class=cvv required  >
	</div><br><br>
	<div id=div2>
	<h2>Enter your pin</h2>
		<input type=password placeholder="****" name=atmPin id=pin  required><br>
		<input type=submit value=Proceed id=proceedButton>
	</div>
		  
   		  <input type=hidden name=foodCost value='<%=foodCost%>'>
   		  <input type=hidden name=FoodName value='<%=FoodName%>'>
	</form>
	 <a href=movieMenu.jsp id=backButton>Back</a>
	</section>
</center>	
</body>

</html>




