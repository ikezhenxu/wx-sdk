package huilai.kezhenxu.material;

import com.alibaba.fastjson.JSONObject;
import huilai.kezhenxu.WxFactory;
import huilai.kezhenxu.basic.WxAccessTokenKeeper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.http.HttpStatus;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by kezhenxu on 4/28/15.
 */
public class WxImageUploader {

	protected static String API_URL_FORMAT = "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=image";

	protected WxFactory wxFactory;

	public WxImageUploader () {
	}

	public WxImageUploader ( WxFactory aWxFactory ) {
		wxFactory = aWxFactory;
	}

	public String uploadImage ( WxAccessTokenKeeper aTokenKeeper, File aFile ) {
		return uploadImage ( aTokenKeeper.getAccessToken (), aFile );
	}

	/**
	 * Upload an image as material
	 *
	 * @param aAccessToken
	 * @param aFile        the image file to send
	 * @return
	 */
	public String uploadImage ( String aAccessToken, File aFile ) {
		try {
			if ( aFile == null || ! aFile.exists () ) {
				throw new IllegalArgumentException ( "File to send is null or doesn't exist: " + aFile );
			}
			String url = String.format ( API_URL_FORMAT, aAccessToken );

			HttpClient theClient = new HttpClient ();
			PostMethod thePostMethod = new PostMethod ( url );
			thePostMethod.setRequestHeader ( "Connection", "Keep-Alive" );
			thePostMethod.setRequestHeader ( "Cache-Control", "no-cache" );
			FilePart theFilePart = new FilePart (
					"media",
					aFile,
					"image/jpg",
					"UTF-8" );
			Part[] theParts = { theFilePart };
			MultipartRequestEntity theRequestEntity = new MultipartRequestEntity (
					theParts, thePostMethod.getParams () );
			thePostMethod.setRequestEntity ( theRequestEntity );
			int status = theClient.executeMethod ( thePostMethod );

			JSONObject resultJSON = JSONObject.parseObject ( thePostMethod.getResponseBodyAsString () );
			if ( status != HttpStatus.SC_OK ) {
				throw new RuntimeException ( "Uploading image fail, status code: " + status );
			}
			if ( resultJSON.get ( "errcode" ) != null ) {
				throw new RuntimeException ( "Uploading image fail, error message: " + resultJSON.getString ( "errmsg" ) );
			}
			Logger.getLogger ( "WxImageUploader" )
			      .info ( "status code=" + status
					              + "\nresult json=" + resultJSON.toJSONString () );
			return resultJSON.getString ( "media_id" );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}
}
