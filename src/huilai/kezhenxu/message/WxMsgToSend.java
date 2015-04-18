package huilai.kezhenxu.message;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsgToSend extends WxBaseMsg implements Serializable {

	// 文本消息
	protected String content;

	// 图片，音频，视频
	protected String mediaId;

	// 视频，音乐
	protected String title;
	protected String description;

	// 音乐
	protected String musicUrl;
	protected String hqMusicUrl; // 高音质，wifi 优先播放
	protected String thumbMediaId;

	protected WxMsgSendType sendType;

	public WxMsgToSend () {

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

	public String getTitle () {
		return title;
	}

	public void setTitle ( String title ) {
		this.title = title;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription ( String description ) {
		this.description = description;
	}

	public String getMusicUrl () {
		return musicUrl;
	}

	public void setMusicUrl ( String musicUrl ) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl () {
		return hqMusicUrl;
	}

	public void setHqMusicUrl ( String hqMusicUrl ) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId () {
		return thumbMediaId;
	}

	public void setThumbMediaId ( String thumbMediaId ) {
		this.thumbMediaId = thumbMediaId;
	}

	public WxMsgSendType getSendType () {
		return sendType;
	}

	public void setSendType ( WxMsgSendType sendType ) {
		this.sendType = sendType;
	}

	public String toXMLString ( boolean withXMLRootNode ) {
		StringBuilder builder = new StringBuilder ();
		if ( withXMLRootNode ) {
			builder.append ( "<xml>" );
		}
		builder.append ( super.toXMLString ( false ) )
		       .append ( "<Content>" )
		       .append ( "<![CDATA[" )
		       .append ( content == null ? "" : content )
		       .append ( "]]>" )
		       .append ( "</Content>" )
		       .append ( "<MediaId>" )
		       .append ( "<![CDATA[" )
		       .append ( mediaId == null ? "" : mediaId )
		       .append ( "]]>" )
		       .append ( "</MediaId>" )
		       .append ( "<Title>" )
		       .append ( "<![CDATA[" )
		       .append ( title == null ? "" : title )
		       .append ( "]]>" )
		       .append ( "</Title>" )
		       .append ( "<Description>" )
		       .append ( "<![CDATA[" )
		       .append ( description == null ? "" : description )
		       .append ( "]]>" )
		       .append ( "</Description>" )
		       .append ( "<MusicUrl>" )
		       .append ( "<![CDATA[" )
		       .append ( musicUrl == null ? "" : musicUrl )
		       .append ( "]]>" )
		       .append ( "</MusicUrl>" )
		       .append ( "<HQMusicUrl>" )
		       .append ( "<![CDATA[" )
		       .append ( hqMusicUrl == null ? "" : hqMusicUrl )
		       .append ( "]]>" )
		       .append ( "</HQMusicUrl>" )
		       .append ( "<ThumbMediaId>" )
		       .append ( "<![CDATA[" )
		       .append ( thumbMediaId == null ? "" : thumbMediaId )
		       .append ( "]]>" )
		       .append ( "</ThumbMediaId>" )
		       .append ( "<MsgType>" )
		       .append ( "<![CDATA[" )
		       .append ( sendType == null ? "" : sendType )
		       .append ( "]]>" )
		       .append ( "</MsgType>" );
		if ( withXMLRootNode ) {
			builder.append ( "</xml>" );
		}
		return builder.toString ();
	}
}
