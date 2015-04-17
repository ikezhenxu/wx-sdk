package huilai.kezhenxu.util;

import huilai.kezhenxu.servlet.ParamerterNotFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kezhenxu on 4/17/15.
 */
public final class HttpUtil {

	public static final String needString (
			HttpServletRequest request,
			String paramName ) {

		String p = request.getParameter ( paramName );
		if ( p == null ) {
			throw new ParamerterNotFoundException (
					"Required parameter but not found:" + paramName
			);
		}
		return p;
	}
}
