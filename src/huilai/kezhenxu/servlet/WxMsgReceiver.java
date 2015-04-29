package huilai.kezhenxu.servlet;

import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import huilai.kezhenxu.material.WxArticle;
import huilai.kezhenxu.material.WxArticleWrapper;
import huilai.kezhenxu.material.WxNewsGet;
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
	protected WxAccessTokenKeeper tokenKeeper;

	@Override
	public void init () throws ServletException {
		super.init ();
		tokenKeeper = WxAccessTokenKeeper.getDefaultInstance ();
	}

	protected void doPost ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		this.response = response;

		try {
			WxMsgParser parser = new WxMsgParser ();
			WxMsgReceived msg = parser.parse ( request.getInputStream () );
			System.out.println ( msg );
			switch ( msg.getType () ) {
				case EVENT:
					handleEvent ( msg );
					break;
				case TEXT:
					handleText ( msg );
					break;
			}
		} catch ( Exception e ) {
			e.printStackTrace ();
		}
	}

	private void handleText ( WxMsgReceived msg ) {
		WxMsgSender sender  = new WxMsgSender ();
		WxMsgToSend send    = new WxMsgToSend ();
		String      content = msg.getContent ();
		String      regx    = "订购[0-9]{8}";
		send.setFrom ( msg.getTo () );
		send.setTo ( msg.getFrom () );
		send.setTime ( System.currentTimeMillis () + "" );
		send.setSendType ( WxMsgType.TEXT );
		if ( content.matches ( regx ) ) {
			send.setContent ( "您好，您的订购请求我们已经收到，我们会尽快为您配送货物，请注意查收！" );
		}
		else {
			send.setContent ( "指令错误！" );
		}
		sender.send ( response, send );
	}

	private void handleEvent ( WxMsgReceived msg ) {
		switch ( msg.getEvent () ) {
			case SUBSCRIBE:
				WxArticleWrapper theWrapper = new WxNewsGet ()
						.getByMediaId ( tokenKeeper.getAccessToken (),
						                "o-bA-oihGFg78tKEUlUz8Krdu2WNX-rhCdX3zMATEDk" );
				WxArticle theArticle = theWrapper.get ( 0 );
				WxMsgSender sender = new WxMsgSender ();
				WxMsgToSend msgToSend = new WxMsgToSend ();
				msgToSend.setFrom ( msg.getTo () );
				msgToSend.setTo ( msg.getFrom () );
				msgToSend.setTime ( System.currentTimeMillis () + "" );
				msgToSend.setSendType ( WxMsgType.NEWS );
				msgToSend.setTitle ( theArticle.getTitle () );
				msgToSend.setUrl ( theArticle.getUrl ());
				msgToSend.setDescription ( theArticle.getDigest () );
				sender.send ( response, msgToSend );
				break;
		}
	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		doGet ( request, response );
	}
}
