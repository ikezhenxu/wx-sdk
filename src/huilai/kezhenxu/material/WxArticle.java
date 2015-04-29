package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by kezhenxu on 4/19/15.
 */
public class WxArticle {

	//	https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN

	protected String title;
	protected String thumb_media_id;
	protected String author;
	protected String digest;
	protected String show_cover_pic;
	protected String content;
	protected String content_source_url;
	protected String url;               // 点击图文消息跳转

	public String getTitle () {
		return title;
	}

	public WxArticle setTitle ( String title ) {
		this.title = title;
		return this;
	}

	public String getThumb_media_id () {
		return thumb_media_id;
	}

	public WxArticle setThumb_media_id ( String thumb_media_id ) {
		this.thumb_media_id = thumb_media_id;
		return this;
	}

	public String getAuthor () {
		return author;
	}

	public WxArticle setAuthor ( String author ) {
		this.author = author;
		return this;
	}

	public String getDigest () {
		return digest;
	}

	public WxArticle setDigest ( String digest ) {
		this.digest = digest;
		return this;
	}

	public String getShow_cover_pic () {
		return show_cover_pic;
	}

	public WxArticle setShow_cover_pic ( String show_cover_pic ) {
		this.show_cover_pic = show_cover_pic;
		return this;
	}

	public String getContent () {
		return content;
	}

	public WxArticle setContent ( String content ) {
		this.content = content;
		return this;
	}

	public String getContent_source_url () {
		return content_source_url;
	}

	public String getUrl () {
		return url;
	}

	public WxArticle setUrl ( String aUrl ) {
		url = aUrl;
		return this;
	}

	public WxArticle setContent_source_url ( String aContent_source_url ) {
		content_source_url = aContent_source_url;
		return this;
	}
	public JSONObject toJSON () {
		JSONObject jsonObject = new JSONObject ();
		jsonObject.put ( "title", title );
		jsonObject.put ( "thumb_media_id", thumb_media_id );
		jsonObject.put ( "author", author );
		jsonObject.put ( "digest", digest );
		jsonObject.put ( "show_cover_pic", show_cover_pic );
		jsonObject.put ( "content", content );
		jsonObject.put ( "content_source_url", content_source_url );
		jsonObject.put ( "url", url );
		return jsonObject;
	}
}
