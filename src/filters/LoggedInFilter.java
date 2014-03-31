package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/LoggedInFilter" }, servletNames = { "servlet.PostitaUudisServlet" })
public class LoggedInFilter implements Filter {

    public LoggedInFilter() {
        System.out.println("LoggedInFilter default constructor");
    }

	public void destroy() {
		System.out.println("LoggedInFilter destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoggedInFilter doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getSession().getAttribute("klient") != null) {
			System.out.println("You are indeed logged in.");
			chain.doFilter(request, response);
		} else {
			System.out.println("Hey, you're not logged in!");
			res.sendRedirect("");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoggedInFilter init(FilterConfig fconfig)");
		System.out.println("fconfig: " + fConfig.toString());
	}

}
