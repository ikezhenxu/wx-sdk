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

	protected WxMsgType sendType;

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

	public WxMsgType getSendType () {
		return sendType;
	}

	public void setSendType ( WxMsgType sendType ) {
		this.sendType = sendType;
	}

	public String toXMLString ( final boolean withXMLRootNode ) {
		StringBuilder builder = new StringBuilder ();
		if ( withXMLRootNode ) {
			builder.append ( "<xml>" );
		}
		builder.append ( super.toXMLString ( false ) )
		       .append ( "<MsgType>" )
		       .append ( "<![CDATA[" )
		       .append ( sendType.getTypeName () )
		       .append ( "]]>" )
		       .append ( "</MsgType>" );
		switch ( sendType ) {
			case MUSIC:
			case IMAGE:
			case VIDEO:
				builder.append ( "<" )
				       .append ( sendType.getTypeName ().substring ( 0, 1 ).toUpperCase ()
						                 + sendType.getTypeName ().substring ( 1 ) )
				       .append ( ">" );
				break;
			case NEWS:
				builder.append ( "<ArticleCount>" )
				       .append ( 1 )
				       .append ( "</ArticleCount>" )
				       .append ( "<Articles>" )
				       .append ( "<item>" );
		}
		if ( content != null ) {
			builder.append ( "<Content>" )
			       .append ( "<![CDATA[" )
			       .append ( content )
			       .append ( "]]>" )
			       .append ( "</Content>" );
		}
		if ( mediaId != null ) {
			builder.append ( "<MediaId>" )
			       .append ( "<![CDATA[" )
			       .append ( mediaId )
			       .append ( "]]>" )
			       .append ( "</MediaId>" );
		}
		if ( title != null ) {
			builder.append ( "<Title>" )
			       .append ( "<![CDATA[" )
			       .append ( title )
			       .append ( "]]>" )
			       .append ( "</Title>" );
		}
		if ( description != null ) {
			builder.append ( "<Description>" )
			       .append ( "<![CDATA[" )
			       .append ( description )
			       .append ( "]]>" )
			       .append ( "</Description>" );
		}
		if ( musicUrl != null ) {
			builder.append ( "<MusicUrl>" )
			       .append ( "<![CDATA[" )
			       .append ( musicUrl )
			       .append ( "]]>" )
			       .append ( "</MusicUrl>" );
		}
		if ( hqMusicUrl != null ) {
			builder.append ( "<HQMusicUrl>" )
			       .append ( "<![CDATA[" )
			       .append ( hqMusicUrl )
			       .append ( "]]>" )
			       .append ( "</HQMusicUrl>" );
		}
		if ( thumbMediaId != null ) {
			builder.append ( "<ThumbMediaId>" )
			       .append ( "<![CDATA[" )
			       .append ( thumbMediaId )
			       .append ( "]]>" )
			       .append ( "</ThumbMediaId>" );
		}
		switch ( sendType ) {
			case MUSIC:
			case IMAGE:
			case VIDEO:
				builder.append ( "</" )
				       .append ( sendType.getTypeName ().substring ( 0, 1 ).toUpperCase ()
						                 + sendType.getTypeName ().substring ( 1 ) )
				       .append ( ">" );
				break;
			case NEWS:
				builder.append ( "</item>" )
				       .append ( "</Articles>" );
		}
		if ( withXMLRootNode ) {
			builder.append ( "</xml>" );
		}
		return builder.toString ();
	}
}
