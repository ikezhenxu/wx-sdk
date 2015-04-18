package huilai.kezhenxu.servlet;

import huilai.kezhenxu.basic.SignatureChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static huilai.kezhenxu.util.HttpUtil.needString;

/**
 * Created by kezhenxu on 4/17/15.
 */
@WebServlet ( "/base/signature.api" )
public class Signature extends HttpServlet {

	protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws
	                                                                                   ServletException,
	                                                                                   IOException {
		Map<String, String[]> params = request.getParameterMap ();
		System.out.println (request.getContentType ());
		if ( params.containsKey ( "echostr" ) ) {
			doSignature ( request, response );
			return;
		}
	}

	private void doSignature ( HttpServletRequest request, HttpServletResponse response ) {

		String signature  = needString ( request, "signature" );
		String timestamp  = needString ( request, "timestamp" );
		String nonce      = needString ( request, "nonce" );
		String echostring = needString ( request, "echostr" );
		try {
			if ( new SignatureChecker ().check ( signature, timestamp, nonce ) ) {
				response.getWriter ().write ( echostring );
			}
		} catch ( Exception e ) {
			e.printStackTrace ();
		}
	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws
	                                                                                  ServletException,
	                                                                                  IOException {
		doPost ( request, response );
	}
}
