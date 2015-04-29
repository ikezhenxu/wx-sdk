package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.util.logging.Logger;

/**
 * Created by kezhenxu on 4/19/15.
 */
public class WxNewsGet {

	//	https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
	protected static String API_URL_FORMAT = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";

	protected WxFactory           wxFactory;
	protected WxAccessTokenKeeper tokenKeeper;

	public WxNewsGet () {
		this ( WxFactory.getDefault () );
	}

	public WxNewsGet ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

	public WxArticleWrapper getByMediaId ( WxAccessTokenKeeper aTokenKeeper, String mediaId ) {
		return getByMediaId ( aTokenKeeper.getAccessToken (), mediaId );
	}

	public WxArticleWrapper getByMediaId ( String accessToken, String mediaId ) {
		try {
			String url = String.format ( API_URL_FORMAT, accessToken );
			String bodyString = String.format ( "{\"media_id\":\"%s\"}", mediaId );
			String responseJson = new String (
					Request.Post ( url )
					       .bodyString ( bodyString, ContentType.APPLICATION_JSON )
					       .execute ()
					       .returnContent ()
					       .asBytes (), "UTF-8" );
			Logger.getLogger ( "WxNewsGet" )
			      .info ( "responseJson=" + responseJson );
			JSONObject theList = JSONObject.parseObject ( responseJson );
			JSONArray theArticles = theList.getJSONArray ( "news_item" );
			WxArticleWrapper theWrapper = new WxArticleWrapper ();
			for ( int i$ = 0; i$ < theArticles.size (); i$++ ) {
				theWrapper.addArticle ( JSONObject.toJavaObject ( theArticles.getJSONObject ( i$ ), WxArticle.class ) );
			}
			return theWrapper;
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}
}
