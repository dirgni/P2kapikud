package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import object.Ajakirjanik;
import service.UudisService;

@WebServlet("/postita-uudis")
@MultipartConfig	
public class PostitaUudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostitaUudisServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PostitaUudisServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		String pealkiri = request.getParameter("pealkiri");
		String tekst = request.getParameter("tekst");
//		Ajakirjanik a = (Ajakirjanik) request.getSession().getAttribute("ajakirjanik");
//		int ajakirjanikId = a.getId();
		int ajakirjanikId = 1;
		Part imgPart = request.getPart("pilt");
		
		UudisService us = new UudisService();
		us.publishUudis(ajakirjanikId, pealkiri, tekst, imgPart);
		
		//Suuna kasutaja uudise lehele
		response.sendRedirect("uudis?uudisId=1");
	}
}
