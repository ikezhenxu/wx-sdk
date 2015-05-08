package test;

import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import huilai.kezhenxu.material.WxMaterialList;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {

	static String accessToken = "miX6yKQ1g93r0Aq_fqblmJgSNWVkVp-UG1Zwsh7soh5i8k1dOi4h49eVyuxtjl2fvU_1PwTLCjuMsaAGxgGpm66QwnktFWaQ0gpaLQFhEAE";

	public static void main ( String[] args ) throws IOException, NoSuchAlgorithmException {
		System.out.println ( new WxMaterialList ()
				                     .list ( "news",
				                             0, 20, WxAccessTokenKeeper.getDefaultInstance () )
				                     .toJSONString () );
	}
}
