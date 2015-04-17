package huilai.kezhenxu.servlet;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class ParamerterNotFoundException extends RuntimeException {

	public ParamerterNotFoundException ( Throwable throwable ) {
		super ( throwable );
	}

	public ParamerterNotFoundException ( String s, Throwable throwable ) {
		super ( s, throwable );
	}

	public ParamerterNotFoundException ( String s ) {
		super ( s );
	}

	public ParamerterNotFoundException () {
		super ();
	}
}
