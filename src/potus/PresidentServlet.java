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

		ServletContext context = getServletContext();
		Integer presNum = (Integer)context.getAttribute("presNum");
		String nav = (String)context.getAttribute("submit");
		if(presNum == null){
			presNum=0;
		}
		
		if(nav.equals("next")){
			presidentDAO.getNext();
		}else if(nav.equals("next")){
			presidentDAO.getPrev();
		}
		
        RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
        req.setAttribute("President", presidentDAO);
        req.setAttribute("AllPresident", presidentDAO.getAllPresidents());
        
        dispatcher.forward(req, resp);
    }

}