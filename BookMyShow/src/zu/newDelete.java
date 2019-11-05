package zu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/newDelete")
public class newDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public newDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("ShowId");
		int newId=Integer.parseInt(id);
		
		try{
		     
		    // Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");
		    // Open a connection
		         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
		         Statement stmt=conn.createStatement();
		         String query="delete  from myShow where id=("+newId+");";
		        out.println(query);
		         stmt.executeUpdate(query);
		         
		         //request.getRequestDispatcher("user.jsp").forward(request,response);;
		         conn.close();
		         response.sendRedirect("adminOption.jsp");
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
