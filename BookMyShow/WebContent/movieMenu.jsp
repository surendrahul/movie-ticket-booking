<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookMyShow</title>
<link rel="icon" type="text/css" href="myImg/icon.png">
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
.section1{
	margin-top:130px;
}
td,tr,th{
	border:1px solid ;
	text-align:left;
	padding:5px 15px;
}
table{
	width:96%;
	border-collapse: collapse;
	margin: 10px 0px 30px 0px;
}
td{
	width:11%;
}

div{
	border: 1px solid;
    width: 25%;   
}
h1{
	padding:5px;
	background-color:rgb(185, 26, 26);
	color:white;
}
input {
	outline: none;
    border: none;
    border-bottom: 2px solid rgb(185, 26, 26);
    padding: 3px 10px;
    font-size: 22px;
}
.sheetType {
	outline: none;
    border: none;
    border-bottom: 2px solid rgb(185, 26, 26);
    padding: 3px 10px;
    font-size: 22px;
    background-color:white;
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

.section0{
	position: relative;
    top: 100px;
}
.section0 div{
	border:none;
	width:100%;
}
.dayOfWeek{
    margin: 3px;
   cursor:pointer;
    background-color: white;
    border: none;
    font-size:13px;
    padding:5px;
    border-radius:5px;
    color:#1ce4c2;
}
.dayOfWeek:hover{
	color:#1ce4c2;
	
}
</style>
</head>
<body onload="myfunction()">
<header>
<img alt="icon" src="myImg/icon.png" id="icon1">
<span id="bookMyShow">BOOKMYSHOW</span>
<a href="logOut" class="headerEle">LOG OUT</a></header>

<section class=section0><center>
	<div id=selectDate>
		
	
	</div>
</center></section>

 <section class=section1><center>
<table class="" style="margin-top: 0px;">
	        <thead>
	            <tr>
	            	<th><b>ID(movie)</b></th>
	                <th><b>Title</b></th>
	                <th><b>Genere</b></th>
	                <th><b>Duration(min.)</b></th>
	                <th><b>Director</b></th>
	               <!--  <th><b>Start Date</b></th>
	                <th><b>End Date</b></th> -->
	            </tr>
	        </thead>
	        <tbody>


	            <%
	                Class.forName("com.mysql.jdbc.Driver");
	                Connection conn = null;
	                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true", "root", "");
	                Statement stmt = null;
	                stmt = conn.createStatement();
	                String query = "select * from runningMovie;";
	                ResultSet rs = null;
	                //out.println(query);
	                rs = stmt.executeQuery(query);
	                 while(rs.next()){
	            %>
	            <tr>
	                <%
	                	 int id = rs.getInt("id");
	                    String title = rs.getString("title");
	                    String genere = rs.getString("genere"); 
	                    int duration=rs.getInt("duration");
	                    String director=rs.getString("director");
	                    String start=rs.getString("startDate");
	                    String end=rs.getString("endDate");
	                   // out.println(start);
	                    
	                
	                %>
	                 <td><%=id %></td>
	                <td><%=title %></td>
	                <td><%=genere %></td>
	                <td><%=duration %></td>
	                <td><%=director %></td>
	                <%-- <td><%=start %></td> 
	                <td><%=end %></td> --%>
	            </tr>                

	            <%      
	                 }  
	            %>

	        </tbody>
	    </table>   
</center></section> 



</body>
<script type="text/javascript">

	function myfunction(){
		var myDate=new Date();
		var deleteDate=new Date;
		deleteDate.setDate(myDate.getDate()-1);
		
		var div1=document.getElementById("selectDate");
		result="";
		var days=["SUN","MON","TUE","WED","THU","FRI","SAT"];
		
		for(var i=1;i<=7; i++){
			var date="a"+i;
			date=new Date();
			date.setDate(myDate.getDate()+i);
			result+="<form action='newMovieMenu' method=post><input class=dayOfWeek type=submit  id="+date.getDate()+" onclick='selectDate(this)' value='"+date.getDate()+" "+days[date.getDay()]+"'>"+
			"<input type=hidden value='"+date.getFullYear()+(date.getMonth()+1)+date.getDate()+"' name=bookDate><input type=hidden value='"+deleteDate.getFullYear()+(deleteDate.getMonth()+1)+deleteDate.getDate()+"' name=deleteDate></form>";
			
		}
		console.log(result);
		div1.innerHTML=result;		
		document.getElementsByClassName('dayOfWeek')[0].value+=" /TOMM";		
	}
	function selectDate(obj){
		var myId=obj.id;
		
		for(var i=0; i<7; i++){
			document.getElementsByClassName('dayOfWeek')[i].style.backgroundColor="white";
			document.getElementsByClassName('dayOfWeek')[i].style.color="#1ce4c2";
		}
		
		document.getElementById(myId).style.backgroundColor="#1ce4c2";
		document.getElementById(myId).style.color="white";
	}

</script>

</html>


