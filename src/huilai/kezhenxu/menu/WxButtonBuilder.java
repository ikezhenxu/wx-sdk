package huilai.kezhenxu.menu;

import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import huilai.kezhenxu.servlet.WxResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxButtonBuilder {

	private static final String API_URL_FORMAT
			= "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

	protected WxFactory wxFactory;

	public WxButtonBuilder () {
		this ( WxFactory.getDefault () );
	}

	public WxButtonBuilder ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

	public WxResponse buildButtons ( WxButtonWrapper buttonWrapper ) {
		try {
			String accessToken = WxAccessTokenKeeper
					.getDefaultInstance ()
					.getAccessToken ();
			System.out.println ( accessToken );
			String url = String.format ( API_URL_FORMAT, accessToken );
			String returnContent = Request.Post ( url )
			                              .body ( new StringEntity ( buttonWrapper.toString (), "UTF-8" ) )
			                              .execute ()
			                              .returnContent ()
			                              .asString ();
			return new WxResponse ( returnContent );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}
}
