package huilai.kezhenxu.servlet;

import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import org.apache.http.client.fluent.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 5/8/15.
 */
@WebServlet ( "/auth/get-info.api" )
public class WxAuth extends HttpServlet {

	private String CODE_API_URL_FORMAT  = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
	                                      "appid=%s&redirect_uri=http://hlai.xyz&" +
	                                      "response_type=code&scope=snsapi_userinfo&state=STATE";
	private String TOKEN_API_URL_FORMAT = "https://api.weixin.qq" +
	                                      ".com/sns/oauth2/access_token?" +
	                                      "appid=%s&secret=%s&code=%s&" +
	                                      "grant_type=authorization_code";

	private WxFactory           wxFactory;
	private WxAccessTokenKeeper wxAccessTokenKeeper;

	@Override
	public void init () throws ServletException {
		super.init ();
		wxFactory = WxFactory.getDefault ();
		wxAccessTokenKeeper = WxAccessTokenKeeper.getDefaultInstance ();
	}

	@Override
	protected void doPost ( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		try {
			String code = req.getParameter ( "code" );
			if ( code == null ) {
				resp.sendRedirect ( String.format ( CODE_API_URL_FORMAT, wxAccessTokenKeeper.getAccessToken () ) );
			}
			String returnJsonString = new String ( Request.Get ( String.format ( TOKEN_API_URL_FORMAT,
			                                                                     wxFactory.getProperty (
					                                                                     WxFactory.APP_ID ),

			                                                                     wxFactory.getProperty (
					                                                                     WxFactory.SECRET ),
			                                                                     code ) )
			                                              .execute ()
			                                              .returnContent ()
			                                              .asBytes (), "UTF-8" );
			System.out.println ( returnJsonString );
		} catch ( Exception e ) {
			e.printStackTrace ();
		}
	}

	@Override
	protected void doGet ( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		doPost ( req, resp );
	}
}
