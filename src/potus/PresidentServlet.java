package potus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		context.setAttribute("presMenu", presMenu);

		Set<String> statesMenu = new HashSet<>();
		for (int i = 1; i <= presidentDAO.getAllPresidents().size(); i++) {
			statesMenu.add(presidentDAO.getPresident(i - 1).getStateElected());
		}
		context.setAttribute("statesMenu", statesMenu);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		ServletContext context = getServletContext();
		String nav = req.getParameter("submit");
		if (nav!=null && nav.equals("reset")){
			presidentDAO = new PresidentFileDAO(context);
		}
			
		Filter filter = new Filter(presidentDAO);
//		System.out.println(req.getParameter("stateElected"));
		filter.getFilter(
						Double.parseDouble(req.getParameter("yearsInOfficeMin")==null? "0":req.getParameter("yearsInOfficeMin").equals("")? "0":req.getParameter("yearsInOfficeMin")),
						Double.parseDouble(req.getParameter("yearsInOfficeMax")==null? "0":req.getParameter("yearsInOfficeMax").equals("")? "0":req.getParameter("yearsInOfficeMax")),
						Double.parseDouble(req.getParameter("rangeYearMin")==null? "0":req.getParameter("rangeYearMin").equals("")? "0":req.getParameter("rangeYearMin")),
						Double.parseDouble(req.getParameter("rangeYearMax")==null? "0":req.getParameter("rangeYearMax").equals("")? "0":req.getParameter("rangeYearMax")),  
						Integer.parseInt(req.getParameter("ageAtInAugMin")==null? "0":req.getParameter("ageAtInAugMin").equals("")? "0":req.getParameter("ageAtInAugMin")),  
						Integer.parseInt(req.getParameter("ageAtInAugMax")==null? "0":req.getParameter("ageAtInAugMax").equals("")? "0":req.getParameter("ageAtInAugMax")),
						req.getParameter("stateElected"),
						Integer.parseInt(req.getParameter("totalElectoralVotesMin")==null? "0":req.getParameter("totalElectoralVotesMin").equals("")? "0":req.getParameter("totalElectoralVotesMin")),
						Integer.parseInt(req.getParameter("totalElectoralVotesMax")==null? "0":req.getParameter("totalElectoralVotesMax").equals("")? "0":req.getParameter("totalElectoralVotesMax")),
//						Integer.parseInt(req.getParameter("popularVotesMax").equals("")? "0":req.getParameter("popularVotesMax")),
//						Integer.parseInt(req.getParameter("popularVotesMin").equals("")? "0":req.getParameter("popularVotesMin")),
						0,
						0,
						Integer.parseInt(req.getParameter("ratingPointsMin")==null? "0":req.getParameter("ratingPointsMin").equals("")? "0":req.getParameter("ratingPointsMin")),
						Integer.parseInt(req.getParameter("ratingPointsMax")==null? "0":req.getParameter("ratingPointsMax").equals("")? "0":req.getParameter("ratingPointsMax")),
						req.getParameter("party"),
						null,
						null,
						null,
						null,
						null,
						null);
//		req.getParameter("occupation"),
//		req.getParameter("college"),
//		req.getParameter("electoralPercentageMin"),
//		req.getParameter("electoralPercentageMax"), 
//		req.getParameter("popularPercentageMin"), 
//		req.getParameter("popularPercentageMax"));
		
		
				int termNumber = 1;
		if (req.getParameter("presNum") != null) {
			Integer presNum = (Integer) context.getAttribute("PresNum");
			try {
				termNumber = Integer.parseInt(req.getParameter("presNum"));
			} catch (NumberFormatException e) {
				termNumber = presNum + 1;
			}
			
			if (nav.equals("next")) {
				presNum = termNumber++;
			} else if (nav.equals("prev")) {
				presNum = --termNumber - 1;
			} else if (presNum == null) {
				presNum = 0;
			} else if (nav.equals("userInput")) {
				presNum = termNumber - 1;
			}
			
			if(((PresidentDAO)filter).getAllPresidents().size()==0){
				termNumber=0;
			}else if (termNumber > ((PresidentDAO)filter).getAllPresidents().size()) {
				termNumber = termNumber % ((PresidentDAO)filter).getAllPresidents().size();
				presNum = termNumber - 1;
			} else if (termNumber < 1) {
				while (termNumber < 1) {
					termNumber += ((PresidentDAO)filter).getAllPresidents().size();
				}
				presNum = termNumber - 1;
			}
			context.setAttribute("President", ((PresidentDAO)filter));
			context.setAttribute("PresNum", presNum);
			context.setAttribute("TermNum", termNumber);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");

			dispatcher.forward(req, resp);
		} else {
			context.setAttribute("TermNum", termNumber);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		}

	}

}