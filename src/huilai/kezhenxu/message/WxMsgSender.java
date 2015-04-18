package huilai.kezhenxu.message;

import huilai.kezhenxu.WxFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsgSender {

	public static final String URL_API_FORMAT = "";

	protected WxFactory wxFactory;

	public WxMsgSender () {
		this ( WxFactory.getDefault () );
	}

	public WxMsgSender ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

	public void send ( HttpServletResponse response, WxMsgToSend msg ) {
		try {
			response.getWriter ().print ( msg.toXMLString ( true ) );
		} catch ( IOException e ) {
			e.printStackTrace ();
			throw new RuntimeException ( "Error occurs when sending message:", e );
		}
	}
}
