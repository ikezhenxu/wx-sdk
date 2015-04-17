package test;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {
	public static void main ( String[] args ) throws IOException {
		System.out.println (
				Request.Get ( "servlet://www.baidu.com" )
						.execute ()
						.returnContent ()
						.asString ()
		);
	}
}
