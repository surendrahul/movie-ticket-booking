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
<body >
<header>
	<img alt="icon" src="myImg/icon.png" id="icon1">
	<span id="bookMyShow">BOOKMYSHOW</span>
	<a href="logOut" class="headerEle">LOG OUT</a>
	<a href="movieMenu.jsp" class="headerEle">BACK</a>
</header>

<section class=section1><center>
<form action=BookMovie method=post>
	<table class="" style="margin-top: 30px;">
	        <thead>
	            <tr>
	            	<th>Select</th>
	                <th><b>Title</b></th>
	                <th><b>Genere</b></th>
	                <th><b>Duration(min.)</b></th>
	                <th><b>Director</b></th>
	                <!-- <th><b>Start Date</b></th>
	                <th><b>End Date</b></th> -->
	                <th><b>Screen</b></th>
	                <th><b>Time Slot</b></th>
	                <th><b>Available</b></th>
	                
	                
	            </tr>
	        </thead>
	        <tbody> 


	            <%
	               String date=request.getParameter("bookDate");
	            String deleteDate=request.getParameter("deleteDate");
	            //System.out.println(date+"  deleteDate "+deleteDate);
	                Class.forName("com.mysql.jdbc.Driver");
	                Connection conn = null;
	                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true", "root", "");
	                Statement stmt = null;
	                stmt = conn.createStatement();
	                
	                
	                Statement stmt2=conn.createStatement();
	                String query0="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='BookMyShow' AND TABLE_NAME='myShow' and column_name='b"+date+"';";
	                ResultSet myResult= stmt2.executeQuery(query0);
	                if((myResult.first())==true){
	                	//System.out.println("new  column is found");
	                }else{
	                	//System.out.println("new column is not found");
	                	stmt2.executeUpdate("alter table myShow add column b"+date+" int(11) default 0 not null;");
	                }
	                
	                query0="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='BookMyShow' AND TABLE_NAME='myShow' and column_name='b"+deleteDate+"';";
	                myResult= stmt2.executeQuery(query0);
	                if((myResult.first())==true){
	                	//System.out.println("delete column is found");
	                	stmt2.executeUpdate("alter table myShow drop column b"+deleteDate+";");
	                }else{
	                	//System.out.println("delete column is not found");
	                	
	                }
	                
	                String query = "select * from myShow order by slot;";
	                ResultSet rs = null;
	                ResultSet rss=null;
	               // out.println(query);
	                rs = stmt.executeQuery(query);
	                while(rs.next()){
	            %>
	            
	             <tr>
	                <%	int id=rs.getInt("id");
	                	int mId=rs.getInt("mId");
	                	String title=null;
	                	String genere=null;
	                	int duration=0;
	                	String director=null;
	                	String start=null;
	                	String end=null;
	                	rss=stmt2.executeQuery("select * from runningMovie where id="+mId+";");
	                	while(rss.next()){
		                	 title=rss.getString("title");
		                	 genere = rss.getString("genere"); 
		                     duration=rss.getInt("duration");
		                     director=rss.getString("director");
		                     start=rss.getString("startDate");
		                     end=rss.getString("endDate");
		                }
	                	int screen = rs.getInt("screen");
	                	int slot = rs.getInt("slot");
	                	String startTime=null, endTime=null;
	                	if(slot==1){
	                		startTime="9am ";
	                		endTime="12pm ";
	                	}else if(slot==2){
	                		startTime="1pm ";
	                		endTime="4pm ";
	                	}else if(slot==3){
	                		startTime="5pm ";
	                		endTime="8pm ";
	                	}
	                	
	                	int avail = rs.getInt("b"+date);
	                	
	                	
	                	if(screen==1){
	                		avail=100-avail;
	                	}else if(screen==2){
	                		avail=150-avail;
	                	}else if(screen==3){
	                		avail=200-avail;
	                	}
	                	
	                	
	                    
	                    
	                   // out.println(start);
	                    
	                
	                %>
	                <td><input type=radio name=id value=<%=id %>  required></td>
	                <td><%=title %></td>
	                <td><%=genere %></td>
	                <td><%=duration %></td>
	                <td><%=director %></td>
	                <%-- <td><%=start %></td> 
	                <td><%=end %></td>  --%>
	                <td><%=screen %></td>
	                <td><%=startTime %>to<%=endTime %></td>
	                <td><%=avail %> seat</td>
	            </tr>               
	              <% }  %>  
	        </tbody>
	    </table>
	    
	    
	    	
	 <div >
        <h1>Book Movie</h1><br>
       

          <input type="number" name="num" placeholder="No. Of Seats" required>
          <input type=hidden name=bookingDate value='<%=date %>'>
          <br /><br>
          <select name="class" class=sheetType>
              <option value="silver">Silver - Rs.60</option>
              <option value="gold">Gold - Rs.120</option>
              <option value="platinum">Platinum - Rs.180</option>
        </select>
          <br /><br />
          <input  type="submit" id=submitt value="BOOK NOW" ><br><br>
      
	</div>
	    
	    
</form>	    
</center></section> 

</body>

</html>


