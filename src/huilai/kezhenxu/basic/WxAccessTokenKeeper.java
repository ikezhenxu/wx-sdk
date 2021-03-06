package huilai.kezhenxu.basic;

import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.servlet.WxResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class WxAccessTokenKeeper implements Serializable {

	public static final String ACCESS_TOKEN = "access_token";
	public static final String EXPIRES_IN   = "expires_in";

	public static final String API_URL_FORMAT =
			"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	protected static WxFactory wxFactory;

	private static String accessToken;
	private static long   birthTime;

	private static WxAccessTokenKeeper SINGLETON;

	private WxAccessTokenKeeper () {
	}

	public synchronized static WxAccessTokenKeeper getDefaultInstance () {
		return getInstance ( WxFactory.getDefault () );
	}

	public synchronized static WxAccessTokenKeeper getInstance ( WxFactory wxFactory ) {
		WxAccessTokenKeeper.wxFactory = wxFactory;
		if ( SINGLETON == null ) {
			SINGLETON = new WxAccessTokenKeeper ();
		}
		return SINGLETON;
	}

	public String getAccessToken () {
		Long accessTokenLife   = Long.parseLong ( wxFactory.getProperty ( WxFactory.ACCESS_TOKEN_LIFE ) );
		Long currentTimeMillis = System.currentTimeMillis ();
		if ( currentTimeMillis - birthTime >= accessTokenLife ) {
			return getAccessToken ( true );
		}
		return accessToken;
	}

	public String getAccessToken ( boolean force ) {
		if ( force ) {
			fetchAccessToken ();
		}
		return getAccessToken ();
	}

	private void fetchAccessToken () {
		try {
			String uri = String.format (
					API_URL_FORMAT,
					wxFactory.getProperty ( WxFactory.APP_ID ),
					wxFactory.getProperty ( WxFactory.SECRET ) );

			String result = new String (
					Request.Get ( uri )
					       .execute ()
					       .returnContent ()
					       .asBytes (), "UTF-8"
			);
			WxResponse response = new WxResponse ( result );
			accessToken = response.getString ( ACCESS_TOKEN );
			birthTime = System.currentTimeMillis ();
		} catch ( IOException e ) {
			e.printStackTrace ();
			throw new RuntimeException ( "Fetching access token failed: ", e );
		}
	}
}
