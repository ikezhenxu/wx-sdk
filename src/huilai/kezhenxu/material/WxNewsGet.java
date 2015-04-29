package huilai.kezhenxu.material;

import huilai.kezhenxu.WxFactory;

/**
 * Created by kezhenxu on 4/19/15.
 */
public class WxNewsGet {

	//	https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN

	protected WxFactory wxFactory;

	public WxNewsGet () {
		this ( WxFactory.getDefault () );
	}

	public WxNewsGet ( WxFactory wxFactory ) {
		this.wxFactory = wxFactory;
	}

}
