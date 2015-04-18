package huilai.kezhenxu.basic;

import huilai.kezhenxu.WxFactory;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class SignatureChecker {

	protected WxFactory wxFactory;

	public SignatureChecker () {
		this ( WxFactory.getDefault () );
	}

	public SignatureChecker ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

	public boolean check ( String signature,
	                       String timestamp,
	                       String nonce ) {

		String token = wxFactory.getProperty ( WxFactory.TOKEN );

		String[] strings = { token, timestamp, nonce };
		Arrays.sort ( strings );
		String string = strings[ 0 ] + strings[ 1 ] + strings[ 2 ];

		try {
			MessageDigest digest = MessageDigest.getInstance ( "SHA-1" );
			byte[] digestedBytes = digest.digest ( string.getBytes () );
			String digestedString = bytesToHexString ( digestedBytes );
			return digestedString.equals ( signature.toUpperCase () );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}

	private String bytesToHexString ( byte[] bytes ) {
		char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		StringBuilder builder = new StringBuilder ();
		for ( byte aByte : bytes ) {
			builder.append ( table[ ( aByte >>> 4 ) & 0x0F ] );
			builder.append ( table[ ( aByte ) & 0x0F ] );
		}
		return builder.toString ();
	}
}
