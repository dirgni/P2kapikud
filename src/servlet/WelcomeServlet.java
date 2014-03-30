package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Uudis;
import service.UudisService;

@WebServlet("/avaleht")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomeServlet() {
        super();
        System.out.println("WelcomeServlet initialized");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WelcomeServlet accessed");
		
		//Võta random uudis
		UudisService us = new UudisService();
//		Uudis uudis = us.getRandomUudis(); <- pole veel implementeeritud
		Uudis uudis = us.getUudisById(1);

		// Teeme uudise beani kättesaadavaks
		request.setAttribute("uudis", uudis);
		
		//Suuname kliendi index.jsp lehele
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}

}
