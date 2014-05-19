package sse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Kommentaar;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(urlPatterns = "/KommentaarFeed", asyncSupported = true)
public class KommentaarFeed extends HttpServlet {
	private static List<AsyncContext> contexts = new LinkedList<AsyncContext>();
	private static final long serialVersionUID = 1L;
    
    public KommentaarFeed() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("KommentaarFeed doGet");
		final AsyncContext asyncContext = request.startAsync(request, response);
		asyncContext.setTimeout(10 * 60 * 1000);
		contexts.add(asyncContext);
		
	}
	
	public static void pushKommentaar(Kommentaar k) {
		System.out.println("Entered pushKommentaar");
		int i = 0;
		for (AsyncContext ctx : contexts) {
			i++;
			System.out.println("Pushing to client nr. " + i);
			try {
				System.out.println("komm try");
				HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
				int reqInt = Integer.parseInt(request.getParameter("uudisId"));
				System.out.println("reqInt=" + reqInt);
				int kInt = k.getUudisId();
				System.out.println(reqInt + "=" + kInt + "?");
				if (Integer.parseInt(request.getParameter("uudisId")) == k.getUudisId()) {
					HttpServletResponse response = (HttpServletResponse) ctx.getResponse();
					response.setContentType("text/event-stream");
					response.setCharacterEncoding("UTF-8");
					JSONArray array = new JSONArray();
					JSONObject dataObj = new JSONObject();
					dataObj.put("id", k.getId());
					dataObj.put("nimi", k.getNimi());
					dataObj.put("tekst", k.getTekst());
					dataObj.put("kell", k.getKell());
					dataObj.put("kuupäev", k.getKuupäev());
					dataObj.put("uudisId", k.getUudisId());
					array.put(dataObj);
					PrintWriter writer = response.getWriter();
					writer.print("data: " + array.toString() + "\n\n");
					System.out.println("Sending:\n" + "data: " + array.toString() + "\n\n");
					writer.flush();
					ctx.complete();
					writer.close();
				}
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
		}
	}

}
