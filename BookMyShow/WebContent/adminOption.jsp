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
margin-top:90px;
}
.adminChoice{
	//height: 50vh;
    width: 24%;
    border: 1px solid rgb(185, 26, 26);
    display: inline-block;
    margin: 15vh 1%;
}
#adminChoice1{
	margin-left:12.5%;
}
h1{
text-align:center;
padding:5px 0px;
color:white;
background-color:rgb(185, 26, 26);
}

input{
	text-align: center;
    width: 100%;
    padding: 5px;
    box-sizing: border-box;
    outline: none;
    border: none;
    border: 1px solid rgb(185, 26, 26);
    font-size:18px;
}
.sheetType{
	
    width: 100%;
    padding: 5px;
    box-sizing: border-box;
    outline: none;
    border: none;
    border: 1px solid rgb(185, 26, 26);
    font-size:18px;
    text-align: center;
    background-color:white;
}
.submitButton{
    background-color: white;
    cursor: pointer;
    border-radius: 13px;
    width: 60%;
    margin-left: 20%;
    border: 2px solid rgb(185,26,26);

}
.submitButton:hover{
	color:white;
	background-color: rgb(185, 26, 26);
}
td,tr,th{
	border:1px solid ;
	text-align:left;
	padding:5px 15px;
}
table{
	width:80%;
	border-collapse: collapse;
	margin: 10px 0px 30px 0px;
}
td{
	width:12.5%;
}
#deleteShow{
	background-color:white;
	border:2px solid rgb(185, 26, 26);
	border-radius:10px;
	cursor:pointer;
}
#deleteShow:hover{
	color:white;
	background-color: rgb(185, 26, 26);
}


</style>
</head>
<body>
<header>
	<img alt="icon" src="myImg/icon.png" id="icon1">
	<span id="bookMyShow">BOOKMYSHOW</span>
	<a href="index.jsp" class="headerEle">LOG OUT</a>
</header>
<section class=section1>
	<div class="adminChoice" id="adminChoice1">
		<h1>add movie</h1>
		<form action="addMovie" method="POST">
		  <input type="text" name="movieName" placeholder="Movie Name" required/><br>
		  <input type="text" name="genere" placeholder="Type(Action/Horor/../etc)" required/><br>
		  <input type="text" name="duration" placeholder="Duration in minute" required/><br>
		  <input type="text" name="director" placeholder="Director" required/><br>
		  <input type="text" name="startDate" placeholder="star date 'YYYYMMDD'" required=true><br>
		  <input type="text" name="endDate" placeholder="end date 'YYYYMMDD'" required=true><br>
		  <input type="submit" value="ADD"  class=submitButton>
		 </form>
	</div>
	<div class="adminChoice">
		<h1>schedule movie</h1>
		<form action="scheduleMovie" method="POST">
			  <input type="text" name="movieId" placeholder="Movie ID" required><br>
	         <select name="screen" class=sheetType>
              <option value=1>Screen 1</option>
              <option value=2>Screen 2</option>
              <option value=3>Screen 3</option>
        	</select><br>
        	<select name="slot" class=sheetType>
              <option value="1">9am to 12pm</option>
              <option value="2">1pm to 4pm</option>
              <option value="3">5pm to 8pm</option>
        	</select><br>
			   <input type="submit" value="SCHEDULE" class=submitButton>
		</form>
	</div>
	<div class="adminChoice">
		<h1>delete movie</h1>
		<form action="deleteMovie" method="POST">
        	<input type="text" name="movieName" placeholder="Movie Name" required><br>
		    <input type="submit" value="DELETE" class=submitButton>
		 </form>
	</div>
</section>
<section>
<center>
	<table class="" style="margin-top: 0px;">
	        <thead>
	            <tr>
	            	<th><b>ID(movie)</b></th>
	                <th><b>Title</b></th>
	                <th><b>Genere</b></th>
	                <th><b>Duration(min.)</b></th>
	                <th><b>Director</b></th>
	                <th><b>Start Date 'YYYYMMDD'</b></th>
	                <th><b>End Date 'YYYYMMDD'</b></th>
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
	                <td><%=start %></td> 
	                <td><%=end %></td>
	            </tr>                

	            <%      
	                 }  
	            %>

	        </tbody>
	    </table>
	    
	    <table class="" style="margin-top: 0px;">
	        <thead>
	            <tr>
	            	<th><b>ID(show)</b></th>
	                <th><b>movie Id</b></th>
	                <th><b>movie name</b></th>
	                <th><b>Slot</b></th>
	                <th><b>Screen</b></th>
	                
	                 <th><b>Delete</b></th>
	            </tr>
	        </thead>
	        <tbody>


	            <%
	               
	                String query1 = "select * from myShow order by slot;";
	               // String query2="select * from runningMovie";
	                ResultSet rss = null;
	                ResultSet rss2=null;
	                Statement stmt2=conn.createStatement();
	                //out.println(query);
	                rss = stmt.executeQuery(query1);
	                String title1=null;
	                 while(rss.next()){
	            %>
	            <tr>
	                <%
	                	 int id = rss.getInt("id");
	                    int mId = rss.getInt("mId");
	                    rss2=stmt2.executeQuery("select * from runningMovie where id="+mId+";");
	                   //  title1=rss2.getString("title");
	                   while(rss2.next()){
	                	   title1=rss2.getString("title");
	                   }
	                    int slot = rss.getInt("slot"); 
	                    int screen=rss.getInt("screen");
	                    int booked=rss.getInt("booked");
	                    
	                   // out.println(start);
	                   String time=null;
				         if(slot==1) {
				        	 time="9am to 12pm";
				         }
				         else if(slot==2) {
				        	 time="1pm to 4pm";
				         }
				         else if(slot==3) {
				        	 time="5pm to 8pm";
				         }
	                    
	                
	                %>
	                 <td><%=id %></td>
	                <td><%=mId %></td>
	                <td><%=title1 %></td>
	                <td><%=time %></td>
	                <td><%=screen %></td>
	                <td> <form action="newDelete" method="post">
	                	<input type=hidden name=ShowId value=<%=id %> >
	                	<input type=submit id=deleteShow value=delete>
	                </form></td>
	            </tr>                

	            <%      
	                 }  
	            %>

	        </tbody>
	    </table>
</center>
</section>
</body>
</html>









