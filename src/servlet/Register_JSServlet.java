package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/register_JS")
public class Register_JSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register_JSServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register_JSServlet doPost");
		
		String eesnimi = request.getParameter("e-nimi");
		String perenimi = request.getParameter("p-nimi");
		String kasutajanimi = request.getParameter("k-nimi");
		String parool = request.getParameter("pwd");
		
		UserService us = new UserService();
		us.registerUser(eesnimi, perenimi, kasutajanimi, parool);
		
		response.sendRedirect("");
	}

}
