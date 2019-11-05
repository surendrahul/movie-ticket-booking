package zu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ticket")
public class ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardNo=request.getParameter("cardNo");
		String cardHolder=request.getParameter("cardHolder");
		String expiryDate=request.getParameter("expiry");
		String cvv=request.getParameter("cvv");
		String atmPin=request.getParameter("atmPin");
		//System.out.println("cardNo cardHolder expiaryDate cvv atmPin "+cardNo+", "+cardHolder+", "+expiryDate+" "+cvv+", "+atmPin);
		
		String foodCst=request.getParameter("foodCost");
		String foodName=request.getParameter("FoodName");
		//System.out.println(foodCst+" "+foodName);
		
		
		String id=null;
		String num=null;
		String SheetClass=null;
		String bookingDate=null;
		Cookie cookiearray[] =request.getCookies();
		for(Cookie cookie : cookiearray){
			if (cookie.getName().equals("id")) {
				id=cookie.getValue();
			}
			if (cookie.getName().equals("num")) {
				num=cookie.getValue();
			}
			if (cookie.getName().equals("SheetClass")) {
				SheetClass=cookie.getValue();
			}
			if (cookie.getName().equals("bookingDate")) {
				bookingDate=cookie.getValue();
			}
			
			
		}
		//System.out.println(id+" "+num+" "+SheetClass);
		PrintWriter out=response.getWriter();
		
		try {
			int number=Integer.parseInt(num);
			int cost=0;
			int foodCost=Integer.parseInt(foodCst);			// Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");
	         // Open a connection
	         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
	         Statement stmt=conn.createStatement();
	         String query="select * from myShow where id="+id+";";
	         ResultSet rs=stmt.executeQuery(query);
	         int slot=0, screen=0,mId=0, booked=0;
	         ResultSet rss=null;
	         String result="<html><head><title>BookMyShow</title><link rel=\"icon\" type=\"text/css\" href=\"myImg/icon.png\"></head>";
	         result+="<style>*{\n" + 
		         		"	margin:0;\n" + 
		         		"	padding:0;\n" + 
		         		"}\n" + 
		         		"\n" + 
		         		"header{\n" + 
		         		"	background-color: rgb(185, 26, 26);\n" + 
		         		"	border-bottom:3px solid white;\n" + 
		         		"	height:80px;\n" + 
		         		"	position:fixed;\n" + 
		         		"	top:0px;\n" + 
		         		"	width:100%;\n" + 
		         		"}\n" + 
		         		"\n section{"
		         		+ "margin-top:100px;}" + 
		         		".headerEle{\n" + 
		         		"	float: right;\n" + 
		         		"    color: white;\n" + 
		         		"    cursor: pointer;\n" + 
		         		"    text-decoration: none;\n" + 
		         		"    position: relative;\n" + 
		         		"    margin-right: 20px;\n" + 
		         		"    margin-top: 30px;\n" + 
		         		"    padding: 0.1%;\n" + 
		         		"	\n" + 
		         		"}\n" + 
		         		".headerEle:hover{\n" + 
		         		"	border-bottom:2px solid white;\n" + 
		         		"}#bookMyShow{\n" + 
		         		"	color: white;\n" + 
		         		"    position: relative;\n" + 
		         		"    cursor: pointer;\n" + 
		         		"    top: 9%;\n" + 
		         		"    font-size: 25px;\n" + 
		         		"    left: 4%;\n" + 
		         		"}\n" + 
		         		"#icon1{\n" + 
		         		"	height: 50%;\n" + 
		         		"    position: relative;\n" + 
		         		"    top: 25%;\n" + 
		         		"    left: 3%;\n" + 
		         		"    \n" + 
		         		"}"+
		         		"h2,h3,p{\n" + 
		         		"	margin:7px;" +  
		         		"}"+
						"#nextButton, #backButton,#proceedButton{\n" + 
						"	padding: 6px 20px;\n" + 
						"    margin: 10px 0px 0px;\n" + 
						"    font-size: 22px;\n" + 
						"    border-radius: 13px;\n" + 
						"    border: 2px solid rgb(185,26,26);\n" + 
						"    color: rgb(185,26,26);\n" + 
						"    background-color: white;\n" + 
						"    cursor: pointer;\n" + 
						"    text-decoration: none;\n" + 
						"    position: relative;\n" + 
						
						"}\n" + 
						"#nextButton:hover, #backButton:hover, #proceedButton:hover{\n" + 
						"	background-color:rgb(185,26,26);\n" + 
						"	color:white;\n" + 
						"}"+
		         		"</style></head>";
		          result+="<header><img alt='icon' src='myImg/icon.png' id='icon1'><span id='bookMyShow'>BOOKMYSHOW</span><a href='logOut' class='headerEle'>LOG OUT</a></header><section>";
		          result+="<center><h1 style='color:blue; margin:30px; font-size:40px;'>your ticket is booked!!!!</h1></center>";
	         while(rs.next()) {
	        	 screen=rs.getInt("screen");
	        	 slot=rs.getInt("slot");
	        	 mId=rs.getInt("mId");
	        	 booked=rs.getInt("b"+bookingDate);
	         }
	  //out.println("Screen,slot, mId, booked	"+ screen+" "+slot+" "+ mId+" "+booked);
	         
	         query="select * from runningMovie where id="+mId;
	         rss=stmt.executeQuery(query);
	         String name=null, genere =null,director=null;
	         int duration=0;
	         while(rss.next()) {
	        	 name=rss.getString("title");
	        	 genere=rss.getString("genere");
	        	 director=rss.getString("director");
	        	 duration =rss.getInt("duration");
	         }
	  //out.println("movieName, genere, derector and time :"+name+", "+genere+", "+ director +", "+duration);
	         
	         if(SheetClass.equals("silver")) {
	        	 cost=60;
	         }else if(SheetClass.equals("gold")) {
	        	 cost=120;
	         }else if(SheetClass.equals("platinum")) {
	        	 cost=180;
	         }
	         cost=cost*number;
	   // out.println("cost for single ticket : 	"+cost);
	   //out.println("Total cost for "+number+" tickets : 	"+cost);
	   
	  
	         String time=bookingDate+"  ";
	         if(slot==1) {
	        	 time+="9am to 12pm";
	         }
	         else if(slot==2) {
	        	 time+="1pm to 4pm";
	         }
	         else if(slot==3) {
	        	 time+="5pm to 8pm";
	         }
	         
	         int totalCost=cost+foodCost;
	         
	         
	          switch(screen){
	          	case 1:
	          		if(slot==1){
	          			showS1T1 m = new showS1T1(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				result += "<center><h2>Show Full</h2><br/></center>"; 
	          			}
	          			else{
	          				result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
	          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
	          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
	          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
	          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
	          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
	          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
	          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";
	  	          			query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	  	          			//System.out.println(query);
	  	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  	          			preparedStmt.execute();
	          			}
	          		}
	          		else if(slot==2){
	          			showS1T2 m=new showS1T2(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				result += "<center><h2>Show Full</h2><br/></center>"; 
	              		}
	              		else{
	              			result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
	          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
	          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
	          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
	          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
	          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
	          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
	          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	      	          		
	              			query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	  	          			//System.out.println(query);
	  	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  	          			preparedStmt.execute();
	              		}
	          		}
	          		else if(slot==3){
	          			showS1T3 m=new showS1T3(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				result += "<center><h2>Show Full</h2><br/></center>"; 
	              		}
	              		else{
	              			result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
	          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
	          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
	          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
	          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
	          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
	          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
	          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	      	          		
	              			query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	  	          			//System.out.println(query);
	  	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  	          			preparedStmt.execute();
	              		}
	          		}
	          		break;
	          			
	          	case 2: 
	          		if(slot==1){
	          			showS2T1 m=new showS2T1(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				result += "<center><h2>Show Full</h2><br/></center>"; 
	          			}
	          			else{
	          				result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
	          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
	          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
	          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
	          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
	          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
	          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
	          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	
	          				query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	  	          			//System.out.println(query);
	  	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  	          			preparedStmt.execute();
	          			}
	          		}
	  				else if(slot==2){
	  					showS2T2 m=new showS2T2(name, genere, duration, director);
	  					m.booked=booked;
	  					if(!m.bookNew(number)){
	  						result += "<center><h2>Show Full</h2><br/></center>"; 
	  	          		}
	  	          		else{
	  	          		result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	
	  	          		query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	          			//System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	          			preparedStmt.execute();
	  	          		}
	  				}
	  				else if(slot==3){
	  					showS2T3 m=new showS2T3(name, genere, duration, director);
	  					m.booked=booked;
	  					if(!m.bookNew(number)){
	  						result += "<center><h2>Show Full</h2><br/></center>"; 
	  	          		}
	  	          		else{
	  	          		result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";
	  	          		query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	          			//System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	          			preparedStmt.execute();
	  	          		}
	  				}
	  				break;
	  					
	          	case 3: 
	          		if(slot==1){
	          			showS3T1 m=new showS3T1(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				result += "<center><h2>Show Full</h2><br/></center>"; 
	          			}
	          			else{
	          				result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
	          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
	          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
	          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
	          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
	          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
	          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
	          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	
	          				query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	  	          			//System.out.println(query);
	  	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  	          			preparedStmt.execute();
	          			}
	          		}
	          		else if(slot==2){
	  					showS3T2 m=new showS3T2(name, genere, duration, director);
	  					m.booked=booked;
	  					if(!m.bookNew(number)){
	  						result += "<center><h2>Show Full</h2><br/></center>"; 
	  	          		}
	  	          		else{
	  	          		result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	
	  	          		query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	          			//System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	          			preparedStmt.execute();
	  	          		}
	  				}
	  				else if(slot==3){
	  					showS3T3 m=new showS3T3(name, genere, duration, director);
	  					m.booked=booked;
	  					if(!m.bookNew(number)){
	  						result += "<center><h2>Show Full</h2><br/></center>"; 
	  	          		}
	  	          		else{
	  	          		result += "<center><div style='border:1px solid black; border-radius:3px; width:800px;'>"
          						+ "<h2 style='background-color:rgb(185, 26, 26); padding:10px; margin:0px; color:white'>Tickets </h2><br/>"
          						+ "<h3>Ticket Cost Rs." + cost + "</h3><br><hr>"
          						+ "<p>Order: "+ number+" x " +SheetClass+" tickets(Rs."+cost/number+")<br>"
          						+ "Movie: "+name+"- ("+duration+" minutes)</p><hr>"
          						+ "<h2>Screen: "+screen+"</h2><h2>time: "+time+"</h2><hr>"
          						+ "<h2>Food</h2>food cost Rs."+foodCost+"<br>"+foodName+"<hr>"
          						+ "<h2>Total Cost</h2><h3> Ticket+ Food Rs."+totalCost+"<h3></div></center>";	
	  	          		query = "update myShow set b"+bookingDate+"="+m.booked+" where id="+id;
	          			//System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	          			preparedStmt.execute();
            			}
	  				}
	  				break;
	  					
	  			default: result += "<center><h2>Wrong Input by Default</h2><br/></center>";
	          } 
	          result+="</html>";
	          out.println(result);
	          result="<center><h1 style='color:red; margin:30px; font-size:40px;'>THANKYOU!!!!</h1><br><a href='logOut'><button id=backButton>Log out</button></a></center>";
	          out.println(result);
		}catch(Exception e) {
			out.println("<html><center><h2>Wrong Input by catch</h2><br/></center></html>");
			System.out.print(e);
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
