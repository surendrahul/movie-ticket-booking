package zu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{ 
		    // Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");
		    // Open a connection
		         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
		         Statement stmt=conn.createStatement();
		         String query="select * from user where name like '"+request.getParameter("Username")+"' and password like '"+request.getParameter("Password")+"';";
		        
		         
		         ResultSet rs=stmt.executeQuery(query);
		         if (rs.last())  // valid username and password - query valid
		         {
		              
		               
		                 out.println("<html><head><title>Welcome "+request.getParameter("Username")+"</title></head>");
		         
		                 out.println("<body>Welcome "+request.getParameter("Username")+"<br>");
		             //redirecting to another webpage...on successful login
		              request.getRequestDispatcher("movieMenu.jsp").forward(request, response);
		         }
		         else{  
		         request.getRequestDispatcher("user.jsp").include(request, response); 
		         out.println("<center> Sorry, username or password error!<br><center></body></html>"); 
		           }
		   } 
		         
		catch(ClassNotFoundException se) {
		         //Handle errors for JDBC
		         out.println("Class not found .... exception ..."+se.getMessage());
		    
		    }
		catch(SQLException e) {
		         //Handle errors 
		         out.println("SQL Exception thrown");
		         e.printStackTrace();
		      } 
		  out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
