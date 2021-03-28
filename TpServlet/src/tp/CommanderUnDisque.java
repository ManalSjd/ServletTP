package tp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CommanderUnDisque")
public class CommanderUnDisque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommanderUnDisque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = null;
		int nbreProduit = 0;
		Cookie[] cookies = request.getCookies();
		nom = Identification.chercheNom(cookies, request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title> votre commande </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h3>" + "Bonjour "+ nom + " voici votre commande" + "</h3>");
		
		out.println(request.getAttributeNames());
		String ajouter;
		if (request.getParameter("order")!=null) {
			Cookie c1 = new Cookie(request.getParameter("code"), request.getParameter("prix"));
			response.addCookie(c1);
			
		}
		
		out.println("<A HREF=achat> Vous pouvez commandez un autre disque </A><br> ");
		out.println("<A HREF=enregistre> Vous pouvez enregistrer votre commande </A><br> ");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
