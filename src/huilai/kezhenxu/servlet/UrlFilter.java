package huilai.kezhenxu.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by kezhenxu on 4/18/15.
 */
@WebFilter ( "/" )
public class UrlFilter implements Filter {

	public void destroy () {
	}

	public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain )
			throws ServletException, IOException {
		System.out.println (req.getContentType ());
		Map<String, String[]> params = req.getParameterMap ();
		if ( params.containsKey ( "echostr" ) ) {
			req.getRequestDispatcher ( "/base/signature.api" )
			   .forward ( req, resp );
			return;
		}
		chain.doFilter ( req, resp );
	}

	public void init ( FilterConfig config ) throws ServletException {

	}

}
