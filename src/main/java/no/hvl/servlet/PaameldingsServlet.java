package no.hvl.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.database.Deltager;
import no.hvl.database.DeltagerDAO;
import no.hvl.hjelpeklasser.Passord;
import no.hvl.hjelpeklasser.Paameldingsskjema;


/**
 * Servlet implementation class PåmeldingServlet
 */
@WebServlet(name = "PaameldingServlet", urlPatterns = "/paamelding")
public class PaameldingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	@EJB
	private DeltagerDAO deltagerDAO;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward "påmeldingsskjema"
		
	 request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn = request.getParameter("fornavn");

		String etternavn = request.getParameter("etternavn");

		String mobil = request.getParameter("mobil");

		String passord = request.getParameter("passord");

		String passordRe = request.getParameter("passordRe");

		String kjonn = request.getParameter("kjonn");
		
		
		Paameldingsskjema skjema = new Paameldingsskjema(request);
		
		System.out.println(skjema.gyldigInnput());
		System.out.println(deltagerDAO);
		
		
		if(skjema.gyldigInnput() && !deltagerDAO.finnesMobilNr(mobil)) {
			//&& !deltagerDAO.hentDeltager(mobil)
			
//			Passord hashPassord = Passord.lagPassord(passord);
			
			Deltager deltager = skjema.lagdeltager();
			deltagerDAO.leggTilNyDeltager(deltager);
			
			HttpSession session = request.getSession(true);
	           	

	            session.setAttribute("deltager", deltager);
	           
			session.setAttribute("fornavn", fornavn);
			session.setAttribute("etternavn", etternavn);
			session.setAttribute("mobil", mobil);
			session.setAttribute("kjonn", kjonn);
		
			
			response.sendRedirect("bekreftelse");
		}else {
			skjema.feilMeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("paamelding");
		}
		

			
		
			
			
			
			
			
			
			
//			
//			request.setAttribute("fornavn", fornavn);
//			request.setAttribute("etternavn", etternavn);
//			request.setAttribute("mobil", mobil);
//			request.setAttribute("hashPassord", passord);
//			request.setAttribute("kjonn", kjonn);
			
			
//			response.sendRedirect("bekreftelse");
		
//		}else {
			////Skjema.feilMeldinger();
//			
//			response.sendRedirect("paamelding");
//		}
//		
		
		
//		
			
		
		
		
//		if(form.isAlleGyldig()) {
//			
//			response.sendRedirect("bekreftelse");
////			HttpSession session = request.getSession(false);
////			
////			if(session != null) {
////				session.invalidate();
////			}
////			
////			session = request.getSession(true);
////			session.setMaxInactiveInterval(100);
////			session.setAttribute("deltager", nydeltager);
////			
////			session.setAttribute("fornavn", fornavn);
////			session.setAttribute("etternavn", etternavn);
////			session.setAttribute("mobil", mobil);
////			session.setAttribute("hash", hash);
////			session.setAttribute("kjonn", kjonn);
////			
////			
////			request.getSession().removeAttribute("form");
//////			request.getSession().setAttribute("deltager", nydeltager);
////			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp")
////	 		.forward(request, response);
//		}else {
//			form.feilMeldinger();
//			request.getSession().setAttribute("form", form);
//			response.sendRedirect("paamelding");
//		}
		
		
	}

}
