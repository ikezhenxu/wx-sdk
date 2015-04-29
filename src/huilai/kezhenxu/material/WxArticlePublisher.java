package huilai.kezhenxu.material;

import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import huilai.kezhenxu.servlet.WxResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;

/**
 * Created by kezhenxu on 4/19/15.
 */
public class WxArticlePublisher {

	protected String API_URL_FORMAT =
			"https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";

	protected String accessToken;

	public WxArticlePublisher ( String accessToken ) {
		this.accessToken = accessToken;
	}

	public WxArticlePublisher ( WxAccessTokenKeeper keeper ) {
		this.accessToken = keeper.getAccessToken ();
	}

	public WxResponse publish ( WxArticleWrapper wrapper ) {
		try {
			String url = String.format ( API_URL_FORMAT, accessToken );
			String returnContent =
					Request.Post ( url )
					       .body ( new StringEntity ( wrapper.toJsonString () ) )
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
