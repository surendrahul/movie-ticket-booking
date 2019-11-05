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
	margin-top:130px;
}
table{
	border-collapse: collapse;
}
td,th{
	border:1px solid black;
	padding:0px 20px;
}
.orderButton, #backButton{
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
.orderButton:hover, #backButton:hover{
	background-color:rgb(185,26,26);
	color:white;
}


</style>
</head>
<body>
<header>
<img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="logOut" class="headerEle">LOG OUT</a></header>
<center>
	<%
	    String id=request.getParameter("id");
		String num=request.getParameter( "num");
		String SheetClass=request.getParameter( "class");
		String bookingDate=request.getParameter("bookingDate");
		
		
		Cookie ck1=new Cookie("id",id);
		Cookie ck2=new Cookie("num",num);
		Cookie ck3=new Cookie("SheetClass",SheetClass);
		Cookie ck4=new Cookie("bookingDate", bookingDate);
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.addCookie(ck3);
		response.addCookie(ck4);
		
		//System.out.println(id+"  "+num+"  "+SheetClass);
  	%>
<section class=section1>
	<form action="food" method=post>
		<table >
        <thead>
            <tr>
            	<th>Select</th>
                <th>Item</th>
                <th></th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        
            <tr>
                <td><input type="checkbox" value="food1" name="foodId1"></td>
                <td><img src="myImg/food1.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 1 medium Popcorn</td>
                <td>100</td>
            </tr> 
           <tr>
                <td><input type="checkbox" value="food2" name="foodId2"></td>
                <td><img src="myImg/food2.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 1 Small Fries + 1 Veg Burger</td>
                <td>150</td>
            </tr>
           <tr>
                <td><input type="checkbox" value="food3" name="foodId3"></td>
                <td><img src="myImg/food3.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 2 Medium fries + 2 Veg Burger</td>
                <td>200</td>
            </tr>
             <tr>
                <td><input type="checkbox" value="food4" name="foodId4"></td>
                <td><img src="myImg/food4.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">MilkShake</td>
                <td>80</td>
            </tr>
           <tr>
                <td><input type="checkbox" value="food5" name="foodId5"></td>
                <td><img src="myImg/food5.png" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">Ice-cream</td>
                <td>60</td>
            </tr>
           
        </tbody>
    </table>
    <br>
    <a href=movieMenu.jsp id=backButton>back</a>
    <input type=submit value=order class=orderButton>
	</form>
</section>	
</center>
</body>
</html>