package git.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInspector implements Filter {

	public HeaderInspector() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httprequest = (HttpServletRequest) request;
		String header = httprequest.getHeader("X-Gitlab-Event");
		String token = httprequest.getHeader("X-Gitlab-Token");
		System.out.println(token);
		System.out.println(header);
		if (header != null) {
			if (header.isEmpty()) {
				HttpServletResponse Httpresponse = (HttpServletResponse) response;
				Httpresponse.setStatus(401);
			} else {
				System.out.println("Success: Filter... Header exists");
				chain.doFilter(request, response);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
