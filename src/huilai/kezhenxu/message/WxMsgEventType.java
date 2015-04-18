package huilai.kezhenxu.message;

/**
 * Created by kezhenxu on 4/18/15.
 */
public enum WxMsgEventType {

	SUBSCRIBE ( "subscribe" ), UNSUBSCRIBE ( "unsubscribe" ),
	SCAN ( "SCAN" ), LOCATION ( "LOCATION" ), CLICK ( "CLICK" ),
	VIEW ( "VIEW" );

	private String typeName;

	WxMsgEventType ( String typeName ) {
		this.typeName = typeName;
	}
}
