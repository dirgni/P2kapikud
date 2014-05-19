package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Ajakirjanik;
import service.UudisService;
import sse.TabelFeed;

@WebServlet("/postita-uudis")
@MultipartConfig	
public class PostitaUudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostitaUudisServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("PostitaUudisServlet doGet");
		String destination = "/WEB-INF/jsp/lisa-uudis.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PostitaUudisServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		String pealkiri = request.getParameter("pealkiri");
		String piltURL = request.getParameter("pilt");
		String tekst = request.getParameter("tekst");
		String tagid = request.getParameter("uudise-tagid");
		Ajakirjanik a = (Ajakirjanik) request.getSession().getAttribute("klient");
		int ajakirjanikId = a.getId();
		
		System.out.println("pealkiri: " + pealkiri);
		System.out.println("pildi url: " + piltURL);
		System.out.println("tekst: " + tekst);
		System.out.println("tagid: " + tagid);
		System.out.println("ajakirjanikId: " + ajakirjanikId);
		
		UudisService us = new UudisService();
		int uudisId = -1;
		uudisId = us.publishUudis(ajakirjanikId, pealkiri, tekst, piltURL, tagid);
		
		if (uudisId == -1) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
		
		TabelFeed.pushUudis(us.getUudisById(uudisId));
		
		// Kirjutame postitatud uudise id vastusesse
		response.getWriter().write(String.valueOf(uudisId));
	}
}
