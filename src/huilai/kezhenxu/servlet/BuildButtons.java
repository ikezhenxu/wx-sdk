package huilai.kezhenxu.servlet;

import huilai.kezhenxu.menu.WxButton;
import huilai.kezhenxu.menu.WxButtonBuilder;
import huilai.kezhenxu.menu.WxButtonType;
import huilai.kezhenxu.menu.WxButtonWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/18/15.
 */
@WebServlet ( "/bt/build.api" )
public class BuildButtons extends HttpServlet {

	protected void doGet ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

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
				.setUrl ( "www.10086.com" );
		WxButton cu = new WxButton ()
				.setName ( "中国联通" )
				.setType ( WxButtonType.VIEW )
				.setUrl ( "www.10010.com" );
		WxButton ct = new WxButton ()
				.setName ( "中国电信" )
				.setType ( WxButtonType.VIEW )
				.setUrl ( "www.189.cn" );
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
		wrapper.add ( newest, clazz, more );
		WxButtonBuilder builder    = new WxButtonBuilder ();
		WxResponse      wxResponse = builder.buildButtons ( wrapper );
		System.out.println ( wxResponse );
	}
}
