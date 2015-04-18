package huilai.kezhenxu.servlet;

import huilai.kezhenxu.message.WxMsg;
import huilai.kezhenxu.message.WxMsgParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/18/15.
 */
@WebServlet ( "/msg/receive.api" )
public class WxMsgReceiver extends HttpServlet {

	protected void doPost ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		try {
			WxMsgParser parser = new WxMsgParser ();
			WxMsg msg = parser.parse ( request.getInputStream () );
			System.out.println ( "--------------" );
			System.out.println ( msg );
			System.out.println ( "--------------" );
		} catch ( Exception e ) {

		} finally {

		}
	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		doGet ( request, response );
	}
}
