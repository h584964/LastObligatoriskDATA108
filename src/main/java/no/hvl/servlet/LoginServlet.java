package no.hvl.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.database.Deltager;
import no.hvl.database.DeltagerDAO;
import no.hvl.hjelpeklasser.InnloginUtil;
import no.hvl.hjelpeklasser.Passord;
import no.hvl.hjelpeklasser.PassordUtil;
import no.hvl.hjelpeklasser.ValideringForDeltager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    DeltagerDAO deltagerDAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feilmelding = "";
		
		if(request.getParameter("invalidBrukernavn") != null) {
			feilmelding = "Ugyldig brukernavn/og eller passord";
		}
		
		request.setAttribute("feilmelding", feilmelding);
		
//		if(InnloginUtil.isInnlogget(request)) {
//			
//		}
		
		
		//Sjekker om man er innlogget hvis ikke --> Feilmelding
		
		 request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
 		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Hvis innloget sendredirect til deltakerListeServlet
		//Hvis ikke send redirect til loginServlet
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		
		
		
		if(!ValideringForDeltager.erGyldigMobil(mobil) || !ValideringForDeltager.erGydligPassord(passord)) {
			response.sendRedirect("login?invalidBrukernavn=");
			
		}else {
			
			Deltager deltager = deltagerDAO.hentDeltager(mobil);
			Passord pass = deltager.getPassord();
			String salt = pass.getPwd_salt();
			String passordHash = pass.getPwd_hash();
			
			if(PassordUtil.validerMedSalt(passord, salt, passordHash)) {
				
				InnloginUtil.loggInnMedBruker(request, deltager);;
//				InnloginUtil.loggInnMedTimeout(request, 100);
				response.sendRedirect("liste");
			}
		}
	}

}
