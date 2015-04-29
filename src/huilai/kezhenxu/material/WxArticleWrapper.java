package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

	public WxArticle get ( int index ) {
		return JSONObject.toJavaObject ( articles.getJSONObject ( index ), WxArticle.class );
	}

	public List<WxArticle> getAll () {
		List<WxArticle> theArticles = new ArrayList<WxArticle> ();
		for ( int i$ = 0; i$ < articles.size (); i$++ ) {
			theArticles.add ( get ( i$ ) );
		}
		return theArticles;
	}

	public String toJsonString () {
		return wrapper.toJSONString ();
	}
}
