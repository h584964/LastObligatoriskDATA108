package no.hvl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.hjelpeklasser.InnloginUtil;

/**
 * Servlet implementation class LogutServlet
 */
@WebServlet("/logut")
public class LogUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inn noe kode her med utlogging av deltager
		
		
		// forward 
		 request.getRequestDispatcher("WEB-INF/jsp/ferdig.jsp")
	 		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InnloginUtil.loggUt(request);

	}
}
