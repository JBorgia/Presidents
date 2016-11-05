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
        System.out.println("init");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PresidentFileDAO listPres = new PresidentFileDAO(getServletContext());
//        PresidentFileDAO listPres = new PresidentFileDAO();
        
    	System.out.println("doget");
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
        req.setAttribute("President", presidentDAO.getAllPresidents());
        
        dispatcher.forward(req, resp);
    }

}