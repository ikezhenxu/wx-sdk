package huilai.kezhenxu.message;

/**
 * Created by kezhenxu on 4/18/15.
 */
public enum WxMsgSendType {

	TEXT ( "text" ), IMAGE ( "image" ),
	VOICE ( "voice" ), VIDEO ( "video" ),
	MUSIC ( "music" ), NEWS ( "news" );

	private String typeName;

	WxMsgSendType ( String typeName ) {
		this.typeName = typeName;
	}
}
