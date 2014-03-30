package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Kommentaar;
import object.Uudis;
import service.KommentaarService;
import service.UudisService;

@WebServlet("/uudis")
public class UudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String url = "/WEB-INF/jsp/uudis.jsp";

    public UudisServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UudisServlet doGet method");
		int uudisId = Integer.parseInt(request.getParameter("uudisId"));

		UudisService us = new UudisService();
		Uudis uudis = us.getUudisById(uudisId);
		request.setAttribute("uudis", uudis);
		
		KommentaarService ks = new KommentaarService();
		ArrayList<Kommentaar> kommentaarid = ks.getKommentaaridByUudisId(uudisId);
		request.setAttribute("kommentaarid", kommentaarid);
		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/uudis.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
