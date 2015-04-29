package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by kezhenxu on 4/29/15.
 */
public class WxNews {

	private String title;
	private String thumb_media_id;
	private String author;
	private String digest;
	private String show_cover_pic;
	private String content;
	private String content_source_url;

	public WxNews () {
	}

	public WxNews ( String aTitle,
	                String aThumb_media_id,
	                String aAuthor,
	                String aDigest,
	                String aShow_cover_pic,
	                String aContent,
	                String aContent_source_url ) {
		title = aTitle;
		thumb_media_id = aThumb_media_id;
		author = aAuthor;
		digest = aDigest;
		show_cover_pic = aShow_cover_pic;
		content = aContent;
		content_source_url = aContent_source_url;
	}

	public String getTitle () {
		return title;
	}

	public WxNews setTitle ( String aTitle ) {
		title = aTitle;
		return this;
	}

	public String getThumb_media_id () {
		return thumb_media_id;
	}

	public WxNews setThumb_media_id ( String aThumb_media_id ) {
		thumb_media_id = aThumb_media_id;
		return this;
	}

	public String getAuthor () {
		return author;
	}

	public WxNews setAuthor ( String aAuthor ) {
		author = aAuthor;
		return this;
	}

	public String getDigest () {
		return digest;
	}

	public WxNews setDigest ( String aDigest ) {
		digest = aDigest;
		return this;
	}

	public String getShow_cover_pic () {
		return show_cover_pic;
	}

	public WxNews setShow_cover_pic ( String aShow_cover_pic ) {
		show_cover_pic = aShow_cover_pic;
		return this;
	}

	public String getContent () {
		return content;
	}

	public WxNews setContent ( String aContent ) {
		content = aContent;
		return this;
	}

	public String getContent_source_url () {
		return content_source_url;
	}

	public WxNews setContent_source_url ( String aContent_source_url ) {
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
		return jsonObject;
	}
}
