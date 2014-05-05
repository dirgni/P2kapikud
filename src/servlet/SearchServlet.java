package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Uudis;
import service.UudisService;

@WebServlet("/otsing")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String url = "/WEB-INF/jsp/tabel.jsp";

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("SearchServlet doGet");
		request.setCharacterEncoding("UTF-8");
		String otsing = request.getParameter("otsing");
		
		System.out.println("otsing: " + otsing);
		UudisService us = new UudisService();
		ArrayList<Uudis> otsinguTulemused = us.search(otsing);
		
		request.setAttribute("uudised", otsinguTulemused);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
