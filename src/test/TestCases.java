package test;

import huilai.kezhenxu.WxFactory;

import java.io.IOException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {

	public static void main ( String[] args ) throws IOException {
//		System.out.println (
		//				Request.Get ( "servlet://www.baidu.com" )
		//						.execute ()
		//						.returnContent ()
		//						.asString ()
		//		);
		System.out.println ( WxFactory.getDefault ().getProperty ( WxFactory.APP_ID ));
	}

}
