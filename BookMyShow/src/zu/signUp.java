package zu;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name=null,email=null,mobileNo="",password=null;
		PrintWriter out=response.getWriter();
		 name=request.getParameter("name");
		 email=request.getParameter("email");
		 mobileNo=request.getParameter("mobileNo");
		 password=request.getParameter("password");
		long mobileNoInt=0;
		//out.println("name "+name+", email "+email+", mobile  "+mobileNo+", password "+password);
		
		
		try{
		     
		      if(!name.equals("") && !email.equals("") && !mobileNo.equals("") && !password.equals("")) {
		    	  mobileNoInt=Long.parseLong(mobileNo);
		  		//out.println(name+" "+email+"  "+mobileNo+" "+password+"  "+mobileNoInt);
		    // Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");
		    // Open a connection
		         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
		         Statement stmt=conn.createStatement();
		         String query="insert into user (name, email,mobileNo, password) values('"+name+"','"+email+"',"+mobileNoInt+",'"+password+"');";
		       out.println(query);
		         stmt.executeUpdate(query);
		         
		         request.getRequestDispatcher("user.jsp").forward(request,response);;
		      }else {
		    	  request.getRequestDispatcher("signUp.jsp").include(request, response); 
			         out.println("<br><br><center> Sorry, somthing wrong!<br><center></body></html>"); 
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
		
		
		/*out.println("name  "+name);
		out.println("email  "+email);
		out.println("password  "+password);*/
		 out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
