package tp;

import javax.servlet.http.Cookie;
import javax.servlet.http.*;

public class Identification {
	static String chercheNom (Cookie [] cookies, HttpServletRequest req) {
		Cookie[] cookies1 = req.getCookies();

		for(int i= 0 ; i < cookies1.length; i++) {
			if (cookies1[i].getName().equals("nom")) {
			 String value = cookies1[i].getValue();
			 return value;
			
			}
		}
		
		
		
		
		
		 
		
		return null;
		
	}
}
