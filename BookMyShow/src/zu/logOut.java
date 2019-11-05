package zu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.*;


@WebServlet("/logOut")
public class logOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public logOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    out.println("<b>Logging you out.. !... </b><br>");
	    
	      
	  
	    HttpSession sessionobj=request.getSession(); // reading an existing session... 
	    out.println("<body> You have successfully logged out ! "+sessionobj.getAttribute("userinfo")+"<br>");

	    sessionobj.invalidate();
	    response.sendRedirect("user.jsp");  //redirect back to login page
	 
	    out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
