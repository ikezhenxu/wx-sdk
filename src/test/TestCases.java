package test;

import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.message.WxMsg;
import huilai.kezhenxu.message.WxMsgParser;

import java.io.ByteArrayInputStream;
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
		System.out.println ( WxFactory.getDefault ().getProperty ( WxFactory.APP_ID ));
		String s = "<xml>\n" +
				" <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
				" <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
				" <CreateTime>1348831860</CreateTime>\n" +
				" <MsgType><![CDATA[text]]></MsgType>\n" +
				" <Content><![CDATA[this is a test]]></Content>\n" +
				" <MsgId>1234567890123456</MsgId>\n" +
				" </xml>";
		WxMsgParser parser = new WxMsgParser ();
		WxMsg msg = parser.parse ( new ByteArrayInputStream ( s.getBytes () ) );
		System.out.println (msg);
	}

}
