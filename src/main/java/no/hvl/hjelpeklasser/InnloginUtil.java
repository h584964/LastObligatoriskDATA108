package no.hvl.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.database.Deltager;

public class InnloginUtil {
	public static boolean isGyldigPassord(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}

	public static boolean isInnlogget(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("mobil") != null;
	}

	public static void loggInnMedTimeout(HttpServletRequest request, int timeoutISekunder) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("mobil", "JEPP");
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
	public static void loggInnMedBruker(HttpServletRequest request, Deltager deltager) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1000);
		session.setAttribute("mobil", deltager);
	}
	
	
}
