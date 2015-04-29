package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONObject;
import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.util.logging.Logger;

/**
 * Created by kezhenxu on 4/29/15.
 */
public class WxNewsUploader {

	protected static String API_URL_FORMAT = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";

	protected WxFactory wxFactory;

	public WxNewsUploader () {
		this ( WxFactory.getDefault () );
	}

	public WxNewsUploader ( WxFactory aWxFactory ) {
		wxFactory = aWxFactory;
	}

	public String upload ( WxAccessTokenKeeper aTokenKeeper, WxArticleWrapper aNewsToSend ) {
		return upload ( aTokenKeeper.getAccessToken (), aNewsToSend );
	}

	public String upload ( String aAccessToken, WxArticleWrapper aNewsToSend ) {
		try {
			String url = String.format ( API_URL_FORMAT, aAccessToken);
			String responseJsonString = Request.Post ( url )
			                                   .bodyString ( aNewsToSend.toJsonString (), ContentType.APPLICATION_JSON )
			                                   .execute ()
			                                   .returnContent ()
			                                   .asString ();
			JSONObject resultJSON = JSONObject.parseObject ( responseJsonString );
			if ( resultJSON.get ( "errcode" ) != null ) {
				throw new RuntimeException ( "Uploading news fail, error message: " + resultJSON.getString ( "errmsg" ) );
			}
			Logger.getLogger ( "WxNewsUploader" )
			      .info ( "result json=" + resultJSON.toJSONString () );
			return resultJSON.getString ( "media_id" );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}
}
