package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Ajakirjanik;
import service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
		
		String userName = request.getParameter("k-nimi");
		String password = request.getParameter("pwd");
		
		LoginService ls = new LoginService();
		boolean login = ls.authenticate(userName, password);
		
		if (login) {
			Ajakirjanik klient = ls.getAjakirjanikByUsername(userName);
			request.getSession().setAttribute("klient", klient);
			// Peaks teoreetiliselt samale lehele uuesti suunama, kust tuldi
			response.sendRedirect(request.getRequestURI());
		} else {
			// Sisselogimine ebaõnnestus
			System.out.println("login failure!");
		}
	}

}
