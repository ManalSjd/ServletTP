package tp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InscriptionClient
 */
@WebServlet("/InscriptionClient")
public class InscriptionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InscriptionClient() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomRecu=null, motPasseRecu=null;
		String nomCookie=null, motPasseCookie=null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (nomCookie==null && nomRecu==null){
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >");
			out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
			out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
			out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
			out.print(" <form action='sinscrire' method='GET' > ");
			out.println("nom");
			out.println("<input type='text' size='20' name='nom' >");
			out.println("<br>");
			out.println("mot de passe");
			out.println("<input type='password' size='20' name='motdepasse'> <br>");
			out.println("<input type='submit' value='inscription'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			} else if (nomCookie==null && nomRecu!=null){
				
				out.println("<html>");
				out.println("<body>");
				out.println("<head>");
				out.println("<title> inscription d'un client </title>");
				out.println("</head>");
				out.println("<body bgcolor='white' >");
				out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
				out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
				out.print(" <form action='sinscrire' method='GET' > ");
				out.println("nom");
				out.println("<input type='text' size='20' name='nom' >");
				out.println("<br>");
				out.println("mot de passe");
				out.println("<input type='password' size='20' name='motdepasse'> <br>");
				out.println("<input type='submit' value='inscription'>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
		}
			else if (identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie))
			{   
				RequestDispatcher rd=request.getRequestDispatcher("achat");
				rd.forward(request, response);
	            
			}
			else {
				out.print("You are successfully logged in!");  
	            out.print("<br>Welcome, "+nomRecu);  
	            Cookie ck=new Cookie("userName",nomRecu);  
	            response.addCookie(ck);  
			}
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	boolean identique (String recu, String cookie) {
		return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
		}
}
