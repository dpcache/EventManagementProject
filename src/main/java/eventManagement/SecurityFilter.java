package eventManagement;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/* The security profile is turned on and off in the application.properties file. */
@Profile("security")
@Component
@Order(1)
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entered the Security Filter...");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		System.out.println(uri);
		if (uri.startsWith("/api/privatecustomer") || uri.startsWith("/api/customerlist")) {
			chain.doFilter(request, response);
			return;
		}
		if (uri.startsWith("/api")) {
			// check JWT token
			System.out.println("Doing a security check...");
			String authheader = req.getHeader("authorization");
			System.out.println(authheader);
			/* Tighten this up if you can. */
			if (authheader != null && authheader.length() > 10) {
				/*
				 * The user passed the authorization check to keep the chain of execution going.
				 */
				chain.doFilter(request, response);
				return;
			}

		} else {
			System.out.println("Not an authorized resource...");
			chain.doFilter(request, response);
			return;

		}
		// continue
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");

	}

}