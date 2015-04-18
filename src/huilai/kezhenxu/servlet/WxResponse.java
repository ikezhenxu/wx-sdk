package huilai.kezhenxu.servlet;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by kezhenxu on 4/17/15.
 */
public class WxResponse {

	public static final String ERR_CODE = "errcode";
	public static final String ERR_MSG  = "errmsg";

	private JSONObject object;

	public WxResponse ( String jsonString ) {
		try {
			object = JSONObject.parseObject ( jsonString );
		} catch ( Exception e ) {
			e.printStackTrace ();
			throw new RuntimeException ( e );
		}
	}

	public int getErrCode () {
		return object.getInteger ( ERR_CODE );
	}

	public String getErrMsg () {
		return object.getString ( ERR_MSG );
	}

	public String getString ( String key ) {
		return object.getString ( key );
	}

	@Override
	public String toString () {
		return "{\"errcode\":" + getErrCode () + "\"errmsg\":\"" + getErrMsg () + "\"}";
	}
}
