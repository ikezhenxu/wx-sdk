package test;

import huilai.kezhenxu.material.WxNews;
import huilai.kezhenxu.material.WxNewsUploader;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class TestCases {

	static String accessToken = "IkKrbQNmYmckEpA0B8GjZ4HVU3GWrFFL4BMcuqF0CNbIdLPC_vvCy6SASmiPdJ0CpTCp8Bn4WxWUaFT3Yz_k2M5DdqY-ZXZXrTBsWatNshM";

	public static void main ( String[] args ) throws IOException, NoSuchAlgorithmException {
		WxNews aNewsToSend = new WxNews ()
				.setTitle ( "测试上传素材" )
				.setThumb_media_id ( "o-bA-oihGFg78tKEUlUz8LH0yALsrK6RyumQpJFuSGo" )
				.setAuthor ( "kezhenxu" )
				.setDigest ( "这是一个测试图文消息，单图文才有" )
				.setShow_cover_pic ( "1" )
				.setContent ( "图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS" )
				.setContent_source_url ( "http://www.baidu.com" );

		System.out.println ( new WxNewsUploader ().upload ( accessToken, aNewsToSend ) );
	}
}
