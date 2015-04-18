package test;

import huilai.kezhenxu.message.WxMsgSendType;
import huilai.kezhenxu.message.WxMsgToSend;

import java.io.IOException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {

	public static void main ( String[] args ) throws IOException {
		//		System.out.println (
		//				Request.Get ( "servlet://www.baidu.com" )
		//						.execute ()
		//						.returnContent ()
		//						.asString ()
		//		);
		WxMsgToSend send = new WxMsgToSend ();
		send.setSendType ( WxMsgSendType.TEXT );
		send.setContent ( "HelloWorld" );
		send.setId ( "1234456" );
		send.setTitle ( "title" );
		send.setTime ( System.currentTimeMillis () + "" );
		System.out.println (send.toXMLString ( true ));
	}

}
