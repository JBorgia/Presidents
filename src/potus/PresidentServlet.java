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
		context.setAttribute("PresNum", presNum);
		// context.setAttribute("currentPresident",
		// presidentDAO.getAllPresidents().get(presNum));

		List<String> presMenu = new ArrayList<>();
		for (int i = 1; i <= presidentDAO.getAllPresidents().size(); i++) {
			presMenu.add(i + ". " + presidentDAO.getPresident(i - 1).getFirstName() + " "
					+ presidentDAO.getPresident(i - 1).getLastName());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();
		String nav = req.getParameter("submit");
		int termNumber = 1;
		if(req.getParameter("presNum")!=null){
		termNumber = Integer.parseInt(req.getParameter("presNum"));
		Integer presNum = (Integer) context.getAttribute("PresNum");
		if (nav.equals("next")) {
			presNum=termNumber++;
		} else if (nav.equals("prev")) {
			presNum=--termNumber-1;
		} else if (presNum == null) {
			presNum = 0;
		} else if (nav.equals("userInput")) {
			presNum = termNumber-1;
		}
		
		if (termNumber > presidentDAO.getAllPresidents().size()) {
			termNumber = termNumber % presidentDAO.getAllPresidents().size();
			presNum = termNumber - 1;
		} else if (termNumber < 1) {
			while(termNumber < 1){
				termNumber += presidentDAO.getAllPresidents().size();
			}
			presNum = termNumber - 1;
		}
		context.setAttribute("President", presidentDAO);
		context.setAttribute("PresNum", presNum);
		context.setAttribute("TermNum", termNumber);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");

		dispatcher.forward(req, resp);
		}
		else{
		context.setAttribute("TermNum", termNumber);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
		}
		
	}

}