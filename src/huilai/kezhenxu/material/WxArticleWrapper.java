package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by kezhenxu on 4/19/15.
 */
public class WxArticleWrapper {

	protected JSONObject wrapper;
	protected JSONArray  articles;

	public WxArticleWrapper () {
		wrapper = new JSONObject ();
		articles = new JSONArray ();
		wrapper.put ( "articles", articles );
	}

	public WxArticleWrapper addArticle ( WxArticle article ) {
		articles.add ( article );
		return this;
	}

	public String toJsonString () {
		return wrapper.toJSONString ();
	}
}
