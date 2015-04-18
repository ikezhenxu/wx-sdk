package huilai.kezhenxu.servlet;

import huilai.kezhenxu.message.*;

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

	protected HttpServletResponse response;

	protected void doPost ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		this.response = response;

		try {
			WxMsgParser parser = new WxMsgParser ();
			WxMsgReceived msg = parser.parse ( request.getInputStream () );
			System.out.println ( msg );
			switch ( msg.getType () ) {
				case EVENT:
					handle ( msg );
					break;
			}
		} catch ( Exception e ) {
			e.printStackTrace ();
		}
	}

	private void handle ( WxMsgReceived msg ) {
		switch ( msg.getEvent () ) {
			case SUBSCRIBE:
				WxMsgSender sender = new WxMsgSender ();
				WxMsgToSend msgToSend = new WxMsgToSend ();
				msgToSend.setFrom ( msg.getTo () );
				msgToSend.setTo ( msg.getFrom () );
				msgToSend.setTime ( System.currentTimeMillis () + "" );
				msgToSend.setSendType ( WxMsgType.TEXT );
				msgToSend.setContent ( "HelloWorld" );
				sender.send ( response, msgToSend );
				break;
		}
	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		doGet ( request, response );
	}
}
