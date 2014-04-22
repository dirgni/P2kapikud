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



@WebServlet("")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomeServlet() {
        super();
        System.out.println("WelcomeServlet initialized");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WelcomeServlet accessed");
		
		request.setCharacterEncoding("UTF-8");
		/*
		//Võta random uudis
		UudisService us = new UudisService();
//		Uudis uudis = us.getRandomUudis(); <- pole veel implementeeritud
		Uudis uudis = us.getUudisById(1);

		// Teeme uudise beani kättesaadavaks
		request.setAttribute("uudis", uudis);
		*/
		UudisService us = new UudisService();
		
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
		uudised = us.getKõikUudised();
		
		request.setAttribute("uudised", uudised);
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}

}
