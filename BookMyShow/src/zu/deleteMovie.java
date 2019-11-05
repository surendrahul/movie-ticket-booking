package zu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteMovie")
public class deleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public deleteMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String movieName=request.getParameter("movieName");
		
		try{
		     
		      
		    // Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");
		    // Open a connection
		         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookMyShow?useSSL=true","root","");
		         Statement stmt=conn.createStatement();
		         String query="delete  from runningMovie where title=('"+movieName+"');";
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
