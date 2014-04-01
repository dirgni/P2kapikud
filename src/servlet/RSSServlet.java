package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/rss")
public class RSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RSSServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RSSServlet doPost");
		
		String nimi = request.getParameter("nimi");
		String email = request.getParameter("e-mail");
		
		UserService us = new UserService();
		us.registerRSS(nimi, email);
		
		response.sendRedirect(request.getHeader("Referer"));
	}

}
