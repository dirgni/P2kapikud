package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Ajakirjanik;
import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("k-nimi");
		String password = request.getParameter("pwd");
		
		UserService ls = new UserService();
		boolean login = ls.authenticate(userName, password);
		
		if (login) {
			System.out.println("Login success!");
			Ajakirjanik klient = ls.getAjakirjanikByUsername(userName);
			request.getSession().setAttribute("klient", klient);
		} else {
			System.out.println("Login failure!");
		}
		
		response.sendRedirect(request.getHeader("Referer"));
	}

}
