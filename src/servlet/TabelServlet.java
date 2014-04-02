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

@WebServlet("/tabel")
public class TabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String url = "/WEB-INF/jsp/tabel.jsp";

    public TabelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TabelServlet doGet");
		
		UudisService us = new UudisService();
		
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
		uudised = us.getKõikUudised();
		
		request.setAttribute("uudised", uudised);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
