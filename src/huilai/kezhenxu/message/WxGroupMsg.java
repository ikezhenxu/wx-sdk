package huilai.kezhenxu.message;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxGroupMsg implements Serializable {

	enum WxGroupMsgType {
		TEXT ( "text" ), IMAGE ( "image" ),
		VOICE ( "voice" ), NEWS ( "mpnews" ),
		VIDEO ( "video" );

		private String typeName;

		WxGroupMsgType ( String typeName ) {
			this.typeName = typeName;
		}

		@Override
		public String toString () {
			return typeName;
		}
	}

	protected WxGroupMsgType msgType;
	protected String         contentOrMediaId;
	protected String         title;
	protected String         description;

	public WxGroupMsg ( WxGroupMsgType msgType ) {
		this.msgType = msgType;
	}

	public WxGroupMsgType getMsgType () {
		return msgType;
	}

	public void setMsgType ( WxGroupMsgType msgType ) {
		this.msgType = msgType;
	}

	public String getContentOrMediaId () {
		return contentOrMediaId;
	}

	public void setContentOrMediaId ( String contentOrMediaId ) {
		this.contentOrMediaId = contentOrMediaId;
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
}
