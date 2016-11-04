package potus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PresidentServlet extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String middleName = req.getParameter("middleName");
		String lastName = req.getParameter("lastName");
		String startYear = req.getParameter("startYear");
		String endYear = req.getParameter("endYear");
		String party = req.getParameter("party");
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		req.setAttribute("firstName", firstName);
		req.setAttribute("middleName", middleName);
		req.setAttribute("lastName", lastName);
		req.setAttribute("startYear", startYear);
		req.setAttribute("endYear", endYear);
		req.setAttribute("party", party);
		dispatcher.forward(req, resp);
	}

}
