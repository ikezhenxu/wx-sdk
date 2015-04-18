package huilai.kezhenxu.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/18/15.
 */
@WebFilter ( "/*" )
public class CharsetFilter implements Filter {
	public void destroy () {
	}

	public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain )
			throws ServletException, IOException {
		req.setCharacterEncoding ( "UTF-8" );
		resp.setCharacterEncoding ( "UTF-8" );
		chain.doFilter ( req, resp );
	}

	public void init ( FilterConfig config ) throws ServletException {

	}

}
