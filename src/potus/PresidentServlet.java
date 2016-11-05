package potus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresidentServlet extends HttpServlet {
	private PresidentDAO presidentDAO;

	@Override
	public void init() throws ServletException {
		presidentDAO = new PresidentFileDAO(getServletContext());
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		req.setAttribute("President", presidentDAO.getAllPresidents());
		req.setAttribute("length", presidentDAO.getAllPresidents().size());

		dispatcher.forward(req, resp);
	}
}
