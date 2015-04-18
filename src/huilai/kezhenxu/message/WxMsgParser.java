package huilai.kezhenxu.message;

import huilai.kezhenxu.WxFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsgParser {

	protected WxFactory wxFactory;
	protected WxMsg     msg;

	public WxMsgParser () {
		this ( WxFactory.getDefault () );
	}

	public WxMsgParser ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

	public WxMsg parse ( InputStream inputStream ) {
		msg = new WxMsg ();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance ();
			SAXParser saxParser = factory.newSAXParser ();
			saxParser.parse ( inputStream, new HLHandler () );
		} catch ( Exception e ) {
			e.printStackTrace ();
		}
		return msg;
	}

	class HLHandler extends DefaultHandler {
		String current = null;

		@Override
		public void startElement ( String uri, String localName, String qName, Attributes attributes ) throws SAXException {
			super.startElement ( uri, localName, qName, attributes );
			current = qName;
		}

		@Override
		public void endElement ( String uri, String localName, String qName ) throws SAXException {
			super.endElement ( uri, localName, qName );
			current = null;
		}

		@Override
		public void characters ( char[] ch, int start, int length ) throws SAXException {
			super.characters ( ch, start, length );
			String value = new String ( ch, start, length );
			System.out.println ( value );
			if ( current == null ) {
				return;
			}
			if ( current.equals ( "MsgId" ) ) {
				msg.setId ( value );
			}
			else if ( current.equals ( "ToUserName" ) ) {
				msg.setTo ( value );
			}
			else if ( current.equals ( "FromUserName" ) ) {
				msg.setFrom ( value );
			}
			else if ( current.equals ( "CreateTime" ) ) {
				msg.setTime ( value );
			}
			else if ( current.equals ( "MsgType" ) ) {
				msg.setType ( WxMsgType.valueOf ( value.toUpperCase () ) );
			}
			else if ( current.equals ( "Content" ) ) {
				msg.setContent ( value );
			}
			else if ( current.equals ( "MediaId" ) ) {
				msg.setMediaId ( value );
			}
			else if ( current.equals ( "PicUrl" ) ) {
				msg.setPicUrl ( value );
			}
			else if ( current.equals ( "Format" ) ) {
				msg.setFormat ( value );
			}
			else if ( current.equals ( "ThumbMediaId" ) ) {
				msg.setThumbMediaId ( value );
			}
			else if ( current.equals ( "Url" ) ) {
				msg.setUrl ( value );
			}
			else if ( current.equals ( "Description" ) ) {
				msg.setDescription ( value );
			}
			else if ( current.equals ( "Location_X" ) ) {
				msg.setLocationX ( value );
			}
			else if ( current.equals ( "Location_Y" ) ) {
				msg.setLocationY ( value );
			}
			else if ( current.equals ( "Label" ) ) {
				msg.setLabel ( value );
			}
			else if ( current.equals ( "Event" ) ) {
				msg.setEvent ( WxMsgEventType.valueOf ( value.toUpperCase () ) );
			}
		}

		@Override
		public void startDocument () throws SAXException {
			super.startDocument ();
		}

		@Override
		public void endDocument () throws SAXException {
			super.endDocument ();
		}
	}
}
