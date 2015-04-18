package huilai.kezhenxu.message;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsg extends WxBaseMsg implements Serializable {

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

	// 地址消息，发送地址，分享地址的消息
	protected String locationX;
	protected String locationY;
	protected String label;

	// 事件
	protected WxMsgEventType event;
	protected String         eventKey;
	protected String         ticket;
	// 地址事件，同意公众号获取地址位置后
	// 每次进入公众号都会上报地址时间
	protected String         latitude;
	protected String         longitude;
	protected String         precision;

	public WxMsg () {
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

	public WxMsgEventType getEvent () {
		return event;
	}

	public void setEvent ( WxMsgEventType event ) {
		this.event = event;
	}

	public String getEventKey () {
		return eventKey;
	}

	public void setEventKey ( String eventKey ) {
		this.eventKey = eventKey;
	}

	public String getTicket () {
		return ticket;
	}

	public void setTicket ( String ticket ) {
		this.ticket = ticket;
	}

	public String getLatitude () {
		return latitude;
	}

	public void setLatitude ( String latitude ) {
		this.latitude = latitude;
	}

	public String getLongitude () {
		return longitude;
	}

	public void setLongitude ( String longitude ) {
		this.longitude = longitude;
	}

	public String getPrecision () {
		return precision;
	}

	public void setPrecision ( String precision ) {
		this.precision = precision;
	}

	@Override
	public String toString () {
		return "WxMsg{" +
				"content='" + content + '\'' +
				", mediaId='" + mediaId + '\'' +
				", picUrl='" + picUrl + '\'' +
				", format='" + format + '\'' +
				", thumbMediaId='" + thumbMediaId + '\'' +
				", url='" + url + '\'' +
				", description='" + description + '\'' +
				", locationX='" + locationX + '\'' +
				", locationY='" + locationY + '\'' +
				", label='" + label + '\'' +
				", event=" + event +
				", eventKey='" + eventKey + '\'' +
				", ticket='" + ticket + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", precision='" + precision + '\'' +
				"} " + super.toString ();
	}
}
