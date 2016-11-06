package potus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
	int presNum;

	public void init() throws ServletException {
		presNum = 0;
		ServletContext context = getServletContext();
		presidentDAO = new PresidentFileDAO(context);
		context.setAttribute("President", presidentDAO);

		List<String> presMenu = new ArrayList<>();
		for (int i = 1; i <= presidentDAO.getAllPresidents().size(); i++) {
			presMenu.add(i + ". " + presidentDAO.getPresident(i).getFirstName() + " " + presidentDAO.getPresident(i).getLastName());
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();
		Integer presNum = (Integer) context.getAttribute("presNum");
		String nav = (String) context.getAttribute("submit");

		if (nav.equals("next")) {
			presNum++;
		} else if (nav.equals("prev")) {
			presNum--;
		} else if (presNum == null) {
			presNum = 0;
		}

		context.setAttribute("President", presidentDAO);
		context.setAttribute("PresNum", presNum);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");

		dispatcher.forward(req, resp);
	}
}