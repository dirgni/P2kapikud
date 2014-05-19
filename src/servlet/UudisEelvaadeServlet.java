package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UudisService;

@WebServlet("/uudis-preview")
public class UudisEelvaadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UudisEelvaadeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UudisEelvaadeServlet doPost");
		
		response.setCharacterEncoding("UTF-8");
		int uudisId = Integer.parseInt(request.getParameter("uudisId"));
		UudisService us = new UudisService();
		String tekst = us.getUudisTekstById(uudisId);
		
		System.out.println("tekst: " + tekst);
		
		PrintWriter pw = response.getWriter();
		pw.write(tekst);
	}

}
