package tp;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiltreAutorisation
 */
@WebServlet("/FiltreAutorisation")
public class FiltreAutorisation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilterConfig filterConfig = null;
	public void init(FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
	}
    public FiltreAutorisation() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = null;
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		Cookie[] cookies2 = request.getCookies();
		for(int i= 0 ; i < cookies2.length; i++) {
		if (cookies2[i].getName().equals("nom")) {
			 String value = cookies2[i].getValue();
			 return;
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("InscriptionClient");
			rd.forward(request, response);}
		}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
