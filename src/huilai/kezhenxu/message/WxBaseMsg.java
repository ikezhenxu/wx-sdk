package huilai.kezhenxu.message;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxBaseMsg implements Serializable {

	// ----------- common
	protected WxMsgType type;
	protected String    id;
	protected String    to;
	protected String    from;
	protected String    time;
	// ----------- common

	public WxMsgType getType () {
		return type;
	}

	public void setType ( WxMsgType type ) {
		this.type = type;
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

	public String toXMLString ( boolean withRootNode ) {
		StringBuilder builder = new StringBuilder ();
		if ( withRootNode ) {
			builder.append ( "<xml>" );
		}
		builder.append ( "<MsgId>" )
		       .append ( id == null ? "" : id )
		       .append ( "</MsgId>" )
		       .append ( "<ToUserName>" )
		       .append ( "<![CDATA[" )
		       .append ( to )
		       .append ( "]]>" )
		       .append ( "</ToUserName>" )
		       .append ( "<FromUserName>" )
		       .append ( "<![CDATA[" )
		       .append ( from )
		       .append ( "]]>" )
		       .append ( "</FromUserName>" )
		       .append ( "<CreateTime>" )
		       .append ( time == null ? "" : time )
		       .append ( "</CreateTime>" );
		if ( withRootNode ) {
			builder.append ( "</xml>" );
		}
		return builder.toString ();
	}

	@Override
	public String toString () {
		return "WxBaseMsg{" +
				"type=" + type +
				", id='" + id + '\'' +
				", to='" + to + '\'' +
				", from='" + from + '\'' +
				", time='" + time + '\'' +
				'}';
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) {
			return true;
		}
		if ( ! ( o instanceof WxBaseMsg ) ) {
			return false;
		}

		WxBaseMsg msg = ( WxBaseMsg ) o;

		return id.equals ( msg.id );

	}

	@Override
	public int hashCode () {
		return id.hashCode ();
	}
}
