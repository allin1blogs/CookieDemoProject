package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID="Preeti1";
	private final String password="123";
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user=request.getParameter("user");
	String pass=request.getParameter("pass");
	
	if(userID.equals(user) && password.equals(pass)) {
		Cookie loginCookie=new Cookie("user",user);
		// setting cookie is empty in 30 min
		
		loginCookie.setMaxAge(10*60);
		response.addCookie(loginCookie);
		response.sendRedirect("loginSuccess.jsp");
	}
	else {
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.html");
		PrintWriter out=response.getWriter();
	    out.print("<font color:red>User name and Password is wrong...</font>");
	    rd.include(request, response);
	}
	}

}
