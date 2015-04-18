package huilai.kezhenxu.message;

import huilai.kezhenxu.WxFactory;

/**
 * Created by kezhenxu on 4/18/15.
 */
public class WxMsgSender {

	public static final String URL_API_FORMAT = "";

	protected WxFactory wxFactory;

	public WxMsgSender () {
		this ( WxFactory.getDefault () );
	}

	public WxMsgSender ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

}
