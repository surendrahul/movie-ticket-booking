package zu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String AdminName=request.getParameter("AdminName");
		String AdminPassword=request.getParameter("AdminPassword");
		PrintWriter out=response.getWriter();
		
		if(AdminName.equals("admin") && AdminPassword.equals("admin")) {
			response.sendRedirect("adminOption.jsp");
			
		}else {
			request.getRequestDispatcher("admin.jsp").include(request, response); 
	         out.println("<center> Sorry, username or password is wrong!<br><center></body></html>"); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






