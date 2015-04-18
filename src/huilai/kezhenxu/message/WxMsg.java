package huilai.kezhenxu.message;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsg implements Serializable {

	// ----------- common
	protected WxMsgType type;
	protected String    id;
	protected String    to;
	protected String    from;
	protected String    time;
	// ----------- common

	// 文本消息
	protected String content;

	// 图片、音频、视频、小视频（6.0以上）
	protected String mediaId;
	// 图片消息
	protected String picUrl;
	// 音频消息
	protected String format;
	// （小）视频消息
	protected String thumbMediaId;
	// 链接消息
	protected String url;
	protected String description;

	// 地址消息
	protected String locationX;
	protected String locationY;
	protected String label;

	enum WxMsgType {
		TEXT ( "text" ), IMAGE ( "image" ), VOICE ( "voice" ),
		VIDEO ( "video" ), SHORT_VIDEO ( "shortvideo" ),
		LOCATION ( "location" ), LINK ( "link" );

		private String typeName;

		WxMsgType ( String typeName ) {
			this.typeName = typeName;
		}
	}

	public WxMsg () {
	}

	public String getId () {
		return id;
	}

	public void setId ( String id ) {
		this.id = id;
	}

	public String getTo () {
		return to;
	}

	public void setTo ( String to ) {
		this.to = to;
	}

	public String getFrom () {
		return from;
	}

	public void setFrom ( String from ) {
		this.from = from;
	}

	public String getTime () {
		return time;
	}

	public void setTime ( String time ) {
		this.time = time;
	}

	public WxMsgType getType () {
		return type;
	}

	public void setType ( WxMsgType type ) {
		this.type = type;
	}

	public String getContent () {
		return content;
	}

	public void setContent ( String content ) {
		this.content = content;
	}

	public String getMediaId () {
		return mediaId;
	}

	public void setMediaId ( String mediaId ) {
		this.mediaId = mediaId;
	}

	public String getPicUrl () {
		return picUrl;
	}

	public void setPicUrl ( String picUrl ) {
		this.picUrl = picUrl;
	}

	public String getFormat () {
		return format;
	}

	public void setFormat ( String format ) {
		this.format = format;
	}

	public String getThumbMediaId () {
		return thumbMediaId;
	}

	public void setThumbMediaId ( String thumbMediaId ) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getUrl () {
		return url;
	}

	public void setUrl ( String url ) {
		this.url = url;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription ( String description ) {
		this.description = description;
	}

	public String getLocationX () {
		return locationX;
	}

	public void setLocationX ( String locationX ) {
		this.locationX = locationX;
	}

	public String getLocationY () {
		return locationY;
	}

	public void setLocationY ( String locationY ) {
		this.locationY = locationY;
	}

	public String getLabel () {
		return label;
	}

	public void setLabel ( String label ) {
		this.label = label;
	}

	@Override
	public String toString () {
		return "WxMsg{" +
				"type=" + type +
				", id='" + id + '\'' +
				", to='" + to + '\'' +
				", from='" + from + '\'' +
				", time='" + time + '\'' +
				", content='" + content + '\'' +
				", mediaId='" + mediaId + '\'' +
				", picUrl='" + picUrl + '\'' +
				", format='" + format + '\'' +
				", thumbMediaId='" + thumbMediaId + '\'' +
				", url='" + url + '\'' +
				", description='" + description + '\'' +
				", locationX='" + locationX + '\'' +
				", locationY='" + locationY + '\'' +
				", label='" + label + '\'' +
				'}';
	}
}
