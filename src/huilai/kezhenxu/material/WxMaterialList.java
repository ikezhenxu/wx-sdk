package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONObject;
import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

/**
 * Created by kezhenxu on 4/29/15.
 */
public class WxMaterialList {

	protected String API_URL_FORMAT =
			"https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";

	protected WxFactory wxFactory;

	public WxMaterialList () {
		this ( WxFactory.getDefault () );
	}

	public WxMaterialList ( WxFactory aWxFactory ) {
		wxFactory = aWxFactory;
	}

	public JSONObject list ( String type,
	                         int offset,
	                         int count,
	                         WxAccessTokenKeeper aTokenKeeper ) {
		try {
			String url = String.format ( API_URL_FORMAT, aTokenKeeper.getAccessToken () );
			JSONObject jsonObject = new JSONObject ();
			jsonObject.put ( "type", type );
			jsonObject.put ( "offset", offset );
			jsonObject.put ( "count", count );
			String responseJSONString = new String (
					Request.Post ( url )
					       .bodyString ( jsonObject.toJSONString (), ContentType.APPLICATION_JSON )
					       .execute ()
					       .returnContent ()
					       .asBytes (), "UTF-8" );
			return JSONObject.parseObject ( responseJSONString );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}
}
