package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/registreerimine")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterServlet doPost");
		
		String eesnimi = request.getParameter("eesnimi");
		String perenimi = request.getParameter("perenimi");
		String kasutajanimi = request.getParameter("kasutaja");
		String parool = request.getParameter("parool");
		
		UserService us = new UserService();
		us.registerUser(eesnimi, perenimi, kasutajanimi, parool);
		
		response.sendRedirect("");
	}

}
