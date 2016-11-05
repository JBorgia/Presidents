package potus;

import java.io.IOException;

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
		context.setAttribute("AllPresident", presidentDAO.getAllPresidents());
        
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PresidentFileDAO listPres = new PresidentFileDAO(getServletContext());
//        PresidentFileDAO listPres = new PresidentFileDAO();

		ServletContext context = getServletContext();
//		PresidentDAO presidentDAO = (PresidentDAO)context.getAttribute("President");
		Integer preNum = (Integer)context.getAttribute("presNum");
		
        RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
        req.setAttribute("President", presidentDAO);
        req.setAttribute("AllPresident", presidentDAO.getAllPresidents());
        
        dispatcher.forward(req, resp);
    }

}