package huilai.kezhenxu;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class WxFactory {

	public static final String ACCESS_TOKEN_LIFE = "hl.access.token.refresh.interval";
	public static final String APP_ID            = "hl.app.id";
	public static final String SECRET            = "hl.secret";

	private Properties properties;

	private static WxFactory SINGLETON = null;

	private WxFactory () {
		properties = new Properties ();
		try {
			properties.load (
					getClass ().getResourceAsStream ( "/wx.properties" )
			);
		} catch ( IOException e ) {
			e.printStackTrace ();
		}
	}

	synchronized
	public static WxFactory getDefault () {
		if ( SINGLETON == null ) {
			SINGLETON = new WxFactory ();
		}
		return SINGLETON;
	}

	public String getProperty ( String property ) {
		return properties.getProperty ( property );
	}
}
