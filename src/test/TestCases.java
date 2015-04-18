package test;

import huilai.kezhenxu.menu.WxButton;
import huilai.kezhenxu.menu.WxButtonBuilder;
import huilai.kezhenxu.menu.WxButtonType;
import huilai.kezhenxu.menu.WxButtonWrapper;
import huilai.kezhenxu.servlet.WxResponse;

import java.io.IOException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {

	public static void main ( String[] args ) throws IOException {

		WxButtonWrapper wrapper = new WxButtonWrapper ();
		WxButton newest = new WxButton ()
				.setName ( "最新靓号" )
				.setType ( WxButtonType.CLICK )
				.setKey ( "newest" );
		WxButton clazz = new WxButton ()
				.setName ( "卡套分类" );
		WxButton cmcc = new WxButton ()
				.setName ( "中国移动" )
				.setType ( WxButtonType.VIEW )
				.setUrl ( "http://www.10086.com" );
		WxButton cu = new WxButton ()
				.setName ( "中国联通" )
				.setType ( WxButtonType.VIEW )
				.setUrl ( "http://www.10010.com" );
		WxButton ct = new WxButton ()
				.setName ( "中国电信" )
				.setType ( WxButtonType.VIEW )
				.setUrl ( "http://www.189.cn" );
		clazz.addSubMenu ( cmcc )
		     .addSubMenu ( cu )
		     .addSubMenu ( ct );
		WxButton more = new WxButton ()
				.setName ( "更多..." );
		WxButton about = new WxButton ()
				.setName ( "关于..." )
				.setType ( WxButtonType.CLICK )
				.setKey ( "about" );
		WxButton feedback = new WxButton ()
				.setName ( "建议反馈" )
				.setKey ( "feedback" )
				.setType ( WxButtonType.CLICK );
		more.addSubMenu ( about )
		    .addSubMenu ( feedback );
		wrapper.add ( newest, clazz, more );
		WxButtonBuilder builder    = new WxButtonBuilder ();
		WxResponse      wxResponse = builder.buildButtons ( wrapper );
		System.out.println ( wrapper.toString () );
	}

}
