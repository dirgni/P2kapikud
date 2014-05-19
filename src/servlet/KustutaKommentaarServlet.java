package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.KommentaarService;

@WebServlet("/kustuta-kommentaar")
public class KustutaKommentaarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KustutaKommentaarServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("KustutaKommentaarServlet doPost");

		System.out.println("uudisId=" + request.getParameter("uudisId"));
		System.out.println("kommentaarId="+request.getParameter("kId"));
		
		request.setCharacterEncoding("UTF-8");
		int uudisId = Integer.parseInt(request.getParameter("uudisId"));
		int kId = Integer.parseInt(request.getParameter("kId"));

		
		KommentaarService ks = new KommentaarService();
		
		ks.kustutaKommentaar(kId);
		
		
		response.sendRedirect("uudis?uudisId=" + uudisId);
	}

}
