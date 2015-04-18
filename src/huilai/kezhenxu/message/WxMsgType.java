package huilai.kezhenxu.message;

/**
 * Created by kezhenxu on 4/18/15.
 */

public enum WxMsgType {
	TEXT ( "text" ), IMAGE ( "image" ), VOICE ( "voice" ),
	VIDEO ( "video" ), SHORT_VIDEO ( "shortvideo" ),
	LOCATION ( "location" ), LINK ( "link" ), EVENT ( "event" );

	private String typeName;

	WxMsgType ( String typeName ) {
		this.typeName = typeName;
	}

	public String getTypeName () {
		return typeName;
	}
}
