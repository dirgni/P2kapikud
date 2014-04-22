package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import object.Ajakirjanik;
import service.UudisService;
import sse.TabelFeed;

@WebServlet("/postita-uudis")
@MultipartConfig	
public class PostitaUudisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostitaUudisServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("PostitaUudisServlet doGet");
		String destination = "/WEB-INF/jsp/lisa-uudis.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request,  response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PostitaUudisServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		String pealkiri = request.getParameter("pealkiri");
		String tekst = request.getParameter("tekst");
		Ajakirjanik a = (Ajakirjanik) request.getSession().getAttribute("klient");
		int ajakirjanikId = a.getId();
		Part imgPart = request.getPart("pilt");
		String path = request.getContextPath();
		
		System.out.println("PWD: " + this.getServletContext().getRealPath("PWD"));
		System.out.println("getContextPath(): " + this.getServletContext().getContextPath());
		System.out.println("request path: " + path);
		System.out.println("pealkiri: " + pealkiri);
		System.out.println("tekst: " + tekst);
		System.out.println("ajakirjanikId: " + ajakirjanikId);
		
		UudisService us = new UudisService();
		int uudisId = us.publishUudis(ajakirjanikId, pealkiri, tekst, imgPart, path);
		
		
		TabelFeed.pushUudis(us.getUudisById(uudisId));
		
		//Suuna kasutaja uudise lehele
		response.sendRedirect("uudis?uudisId=" + uudisId);
	}
}
