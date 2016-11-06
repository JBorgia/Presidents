package potus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PresidentServlet extends HttpServlet {
	private PresidentDAO presidentDAO;

	public void init() throws ServletException {
		ServletContext context = getServletContext();
		presidentDAO = new PresidentFileDAO(context);
		context.setAttribute("President", presidentDAO);
		
		List<String> presMenu = new ArrayList<>();
		for (President president : presidentDAO.getAllPresidents()) {
			presMenu.add(president.getFirstName() + " " + president.getLastName()); 
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();
		Integer presNum = (Integer) context.getAttribute("presNum");
		String nav = (String) context.getAttribute("submit");

		if (nav.equals("next")) {
			presidentDAO.getNext();
		} else if (nav.equals("prev")) {
			presidentDAO.getPrev();
		} else if (presNum == null) {
			presNum = 0;
		}

		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		req.setAttribute("President", presidentDAO);

		dispatcher.forward(req, resp);
	}

}