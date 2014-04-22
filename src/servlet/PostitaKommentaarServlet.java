package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.KommentaarService;
import sse.KommentaarFeed;

@WebServlet("/postita-kommentaar")
public class PostitaKommentaarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostitaKommentaarServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PostitaKommentaarServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		String nimi = request.getParameter("Nimi");
		String tekst = request.getParameter("content");
		int uudisId = Integer.parseInt(request.getParameter("uudisId"));

		KommentaarService ks = new KommentaarService();
		int id = ks.postitaKommentaar(nimi, tekst, uudisId);
		
		System.out.println("Starting komm push...");
		KommentaarFeed.pushKommentaar(ks.getKommentaarById(id));
		
		response.sendRedirect("uudis?uudisId=" + uudisId);
	}

}
