package huilai.kezhenxu.menu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxButton implements Serializable {

	public static final String BUTTON     = "button";
	public static final String SUB_BUTTON = "sub_button";
	public static final String TYPE       = "type";
	public static final String NAME       = "name";
	public static final String KEY        = "key";
	public static final String URL        = "url";

	protected JSONObject menu;
	protected JSONArray  subMenus;
	protected boolean    hasParent;
	protected boolean    isFirstTimeAddSubMenu;

	public WxButton () {
		menu = new JSONObject ();
		subMenus = new JSONArray ();
		hasParent = false;
		isFirstTimeAddSubMenu = true;
	}

	public WxButton addSubMenu ( WxButton subMenu ) {
		if ( subMenu.subMenus.size () > 0 && ! this.hasParent ) {
			throw new IllegalArgumentException ( "WxButton level could not be over 2." );
		}
		if ( isFirstTimeAddSubMenu ) {
			menu.put ( SUB_BUTTON, subMenus );
		}

		subMenus.add ( subMenu );
		subMenu.hasParent = true;
		return this;
	}

	public String getType () {
		return menu.getString ( TYPE );
	}

	public WxButton setType ( WxButtonType menuType ) {
		if ( menuType != null ) {
			menu.put ( TYPE, menuType.getTypeName () );
		}
		return this;
	}

	public String getName () {
		return menu.getString ( NAME );
	}

	public WxButton setName ( String name ) {
		if ( name != null ) {
			menu.put ( NAME, name );
		}
		return this;
	}

	public String getUrl () {
		return menu.getString ( URL );
	}

	public WxButton setUrl ( String url ) {
		if ( url != null ) {
			menu.put ( URL, url );
		}
		return this;
	}

	public String getKey () {
		return menu.getString ( KEY );
	}

	public WxButton setKey ( String key ) {
		if ( key != null ) {
			menu.put ( KEY, key );
		}
		return this;
	}

	@Override
	public String toString () {
		return menu.toJSONString ();
	}

	public JSONObject toJson () {
		return menu;
	}
}
