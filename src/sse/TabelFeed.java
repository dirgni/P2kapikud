package sse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Uudis;

@WebServlet(urlPatterns = "/TabelFeed", asyncSupported = true)
public class TabelFeed extends HttpServlet {
	private static List<AsyncContext> contexts = new LinkedList<AsyncContext>();
	private static final long serialVersionUID = 1L;
    
    public TabelFeed() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TabelFeed doGet");
		final AsyncContext asyncContext = request.startAsync(request, response);
		asyncContext.setTimeout(10 * 60 * 1000);
		contexts.add(asyncContext);
	}
	
	// Käib kõik subscriberid läbi
	public static void pushUudis(Uudis u) {
		for (AsyncContext ctx : contexts) {
			System.out.println("data push");
			try {
				HttpServletResponse response = (HttpServletResponse) ctx.getResponse();
				response.setContentType("text/event-stream");
				response.setCharacterEncoding("UTF-8");
				JSONArray array = new JSONArray();
				JSONObject dataObj = new JSONObject();
				dataObj.put("id", u.getId());
				dataObj.put("pealkiri", u.getPealkiri());
				dataObj.put("kuupäev", u.getKuupäev());
				dataObj.put("kell", u.getKell());
				dataObj.put("kommentaare", u.getKommentaare());
				array.put(dataObj);
				PrintWriter writer = response.getWriter();
				writer.print("data: " + array.toString() + "\n\n");
				System.out.println("Sending:\n" + "data: " + array.toString() + "\n\n");
                writer.flush();
                ctx.complete();
                writer.close();
            } catch (Exception ex) {}
		}
	}

}
