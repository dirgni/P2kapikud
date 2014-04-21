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
import service.KommentaarService;
import service.UudisService;

@WebServlet("/kustuta-uudis")
@MultipartConfig	
public class KustutaUudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KustutaUudisServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("KustutaUudisServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		int uId = Integer.parseInt(request.getParameter("uId"));

		UudisService us = new UudisService();
		
		us.kustutaUudis(uId);

		response.sendRedirect("tabel");
	}
}
