package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Ajakirjanik;
import object.Kommentaar;
import object.Uudis;
import service.KommentaarService;
import service.UserService;
import service.UudisService;

@WebServlet("/uudis")
public class UudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String url = "/WEB-INF/jsp/uudis.jsp";

    public UudisServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UudisServlet doGet");
		int uudisId = Integer.parseInt(request.getParameter("uudisId"));

		UudisService us = new UudisService();
		Uudis uudis = us.getUudisById(uudisId);
		request.setAttribute("uudis", uudis);
		
		KommentaarService ks = new KommentaarService();
		ArrayList<Kommentaar> kommentaarid = ks.getKommentaaridByUudisId(uudisId);
		request.setAttribute("kommentaarid", kommentaarid);
		
		UserService uss = new UserService();
		Ajakirjanik ajakirjanik = uss.getAjakirjanikById(uudis.getAjakirjanikId());
		request.setAttribute("autor", ajakirjanik);
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
