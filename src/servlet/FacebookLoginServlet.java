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

@WebServlet("/Facebooklogin")
public class FacebookLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public FacebookLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Now In FacebookLoginServlet");
		request.setCharacterEncoding("UTF-8");
		
		String uid = ""+request.getParameter("FBuid");
		
		UserService ls = new UserService();
		boolean login = ls.FBCheck(uid);
		
		if(login){
			System.out.println("User Exists, Getting Data");
			Ajakirjanik klient = ls.getAjakirjanikByUID(uid);
			request.getSession().setAttribute("klient", klient);
		}else{
			System.out.println("login failure!");
		}
		/*
		if(uid.equals("null")||act.equals("null")){
			
		}*/
		
		/*
		
		
		if (login) {
			System.out.println("login success!");
			Ajakirjanik klient = ls.getAjakirjanikByUsername(userName);
			request.getSession().setAttribute("klient", klient);
			
		} else {
			// Sisselogimine ebaõnnestus
			System.out.println("login failure!");
		}
		*/
		response.sendRedirect(request.getHeader("Referer"));
	}

}








