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

		String[] strings = { signature, timestamp, nonce };
		Arrays.sort ( strings );
		String string = strings[ 0 ] + strings[ 1 ] + strings[ 2 ];

		try {
			MessageDigest digest = MessageDigest.getInstance ( "SHA-1" );
			byte[] digestedBytes = digest.digest ( string.getBytes ( "UTF-8" ) );
			String digestedString = bytesToHexString ( digestedBytes );
			System.out.println ( digestedString );
			return signature.equals ( digestedString );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}

	private String bytesToHexString ( byte[] bytes ) {
		StringBuilder builder = new StringBuilder ();
		for ( byte aByte : bytes ) {
			builder.append ( ( char ) ( aByte >>> 4 ) & 0x0F );
			builder.append ( ( char ) ( aByte ) & 0x0F );
		}
		return builder.toString ();
	}
}
