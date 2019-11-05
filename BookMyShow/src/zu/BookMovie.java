package zu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
@WebServlet("/BookMovie")
public class BookMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookMovie() {
        super();
        // TODO Auto-generated constructor stub
    }
     static int cost=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				
				
				String id=request.getParameter("id");
				String num=request.getParameter("num");
				String SheetClass=request.getParameter("class");
				String bookingDate=request.getParameter("bookingDate");
				
				
						
				PrintWriter out=response.getWriter();
				
				
				try {
					int number=Integer.parseInt(num);
					// Register JDBC driver
			         Class.forName("com.mysql.jdbc.Driver");
			         // Open a connection
			         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
			         Statement stmt=conn.createStatement();
			         String query="select * from myShow where id="+id+";";
			         ResultSet rs=stmt.executeQuery(query);
			         int slot=0, screen=0,mId=0, booked=0;
			         ResultSet rss=null;
			         String result="<html><head><title>BookMyShow</title><link rel=\"icon\" type=\"text/css\" href=\"myImg/icon.png\">";
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
							"    top: 104px;" + 
							"}\n" + 
							"#nextButton:hover, #backButton:hover, #proceedButton:hover{\n" + 
							"	background-color:rgb(185,26,26);\n" + 
							"	color:white;\n" + 
							"}"+
			         		"</style></head>";
			          result+="<header><img alt='icon' src='myImg/icon.png' id='icon1'><span id='bookMyShow'>BOOKMYSHOW</span><a href='logOut' class='headerEle'>LOG OUT</a></header><section>";
			         while(rs.next()) {
			        	 screen=rs.getInt("screen");
			        	 slot=rs.getInt("slot");
			        	 mId=rs.getInt("mId");
			        	 booked=rs.getInt("b"+bookingDate);
			         }
			  //System.out.println("Screen,slot, mId, booked	"+ screen+" "+slot+" "+ mId+" "+booked);
			         
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
			         
			       
			          switch(screen){
			          	case 1:
			          		if(slot==1){
			          			showS1T1 m = new showS1T1(name, genere, duration, director);
			          			m.booked=booked;
			          			if(!m.bookNew(number)){
			          				result += "<center><h2>Show Full</h2><br/></center>"; 
			          			}
			          			else{
			          				RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			          				 requestDispature.forward(request,response);
			          				
			          			}
			          		}
			          		else if(slot==2){
			          			showS1T2 m=new showS1T2(name, genere, duration, director);
			          			m.booked=booked;
			          			if(!m.bookNew(number)){
			          				result += "<center><h2>Show Full</h2><br/></center>"; 
			              		}
			              		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			              			
			              		}
			          		}
			          		else if(slot==3){
			          			showS1T3 m=new showS1T3(name, genere, duration, director);
			          			m.booked=booked;
			          			if(!m.bookNew(number)){
			          				result += "<center><h2>Show Full</h2><br/></center>"; 
			              		}
			              		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			              			
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
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			          				
			          			}
			          		}
			  				else if(slot==2){
			  					showS2T2 m=new showS2T2(name, genere, duration, director);
			  					m.booked=booked;
			  					if(!m.bookNew(number)){
			  						result += "<center><h2>Show Full</h2><br/></center>"; 
			  	          		}
			  	          		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			  	          		
			  	          		}
			  				}
			  				else if(slot==3){
			  					showS2T3 m=new showS2T3(name, genere, duration, director);
			  					m.booked=booked;
			  					if(!m.bookNew(number)){
			  						result += "<center><h2>Show Full</h2><br/></center>"; 
			  	          		}
			  	          		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			  	          		
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
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			          				
			          			}
			          		}
			          		else if(slot==2){
			  					showS3T2 m=new showS3T2(name, genere, duration, director);
			  					m.booked=booked;
			  					if(!m.bookNew(number)){
			  						result += "<center><h2>Show Full</h2><br/></center>"; 
			  	          		}
			  	          		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			  	          		
			  	          		}
			  				}
			  				else if(slot==3){
			  					showS3T3 m=new showS3T3(name, genere, duration, director);
			  					m.booked=booked;
			  					if(!m.bookNew(number)){
			  						result += "<center><h2>Show Full</h2><br/></center>"; 
			  	          		}
			  	          		else{
			              			RequestDispatcher requestDispature=request.getRequestDispatcher("food.jsp");
			              			 requestDispature.forward(request,response);
			  	          		
		            			}
			  				}
			  				break;
			  					
			  			default: result += "<center><h2>Wrong Input by Default</h2><br/></center>";
			          } 
			          result+="<section></html>";
			          out.println(result);
			         
			          result="<center><a href='movieMenu.jsp'><button id=backButton>Back</button></a></center>";
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





