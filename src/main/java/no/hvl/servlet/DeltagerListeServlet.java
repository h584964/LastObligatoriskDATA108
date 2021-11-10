package no.hvl.servlet;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.database.Deltager;
import no.hvl.database.DeltagerDAO;
import no.hvl.hjelpeklasser.InnloginUtil;

/**
 * Servlet implementation class DeltagerListeServlet
 */
@WebServlet("/liste")
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	private DeltagerDAO deltagerDAO;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(InnloginUtil.isInnlogget(request)) {
//			//Siden mobil er en unik attributt i databasen
//			//Bruker session fordi det blir økten til deltageren på siden
//			String mobil = (String) request.getSession().getAttribute("mobil");
//			
//			//Bruker streams for å sortere deltager på etternavn
			List<Deltager> deltagerliste = deltagerDAO.hentAlleDeltagere();
			deltagerliste = deltagerliste.stream()
			.sorted(Comparator.comparing(Deltager::getEtternavn).thenComparing(Deltager::getEtternavn))
			.collect(Collectors.toList());
//			
//			//Lagrer verdier i økten
			request.getSession().setAttribute("liste", deltagerliste);
//			request.getSession().setAttribute("mobil", deltagerliste);
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp")
		 		.forward(request, response);
		
//		
		}else {
//			String feilmelding = "Ugyldig brukernavn/passord";
//			request.getSession().setAttribute("melding", feilmelding);
			
			//Hvis ikke innlogget blir man sendt til loginsiden
//			request.getRequestDispatcher("login").forward(request, response);
			response.sendRedirect("login");
		
		
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
