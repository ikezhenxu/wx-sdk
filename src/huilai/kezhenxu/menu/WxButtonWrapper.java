package huilai.kezhenxu.menu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxButtonWrapper implements Serializable {

	public static final String BUTTON = "button";

	protected JSONObject wrapper;
	protected JSONArray buttons;

	public WxButtonWrapper () {
		wrapper = new JSONObject ();
		buttons = new JSONArray ();
		wrapper.put ( BUTTON, buttons );
	}

	public WxButtonWrapper add ( WxButton... menus ) {
		for ( WxButton menu : menus ) {
			buttons.add ( menu.toJson () );
		}
		return this;
	}

	@Override
	public String toString () {
		return wrapper.toJSONString ();
	}
}
