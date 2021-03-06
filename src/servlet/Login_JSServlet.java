package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Ajakirjanik;
import service.UserService;

@WebServlet("/login_JS")
public class Login_JSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login_JSServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login_JSServlet doGet");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/meldi-js.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login_JSServlet doPost");
		
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
		
		response.sendRedirect("");
	}

}
