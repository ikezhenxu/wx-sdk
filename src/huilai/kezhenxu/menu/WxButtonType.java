package huilai.kezhenxu.menu;

/**
 * Created by kezhenxu on 4/18/15.
 */
public enum WxButtonType {

	CLICK("click"),VIEW("view"),SCANCODE_PUSH("scancode_push"),
	SCANCODE_WAITMSG("scancode_waitmsg"),PIC_SYSPHOTO("pic_sysphoto"),
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),PIC_WEIXIN("pic_weixin"),
	LOCATION_SELECT("location_select");

	private String typeName;

	WxButtonType ( String typeName ) {
		this.typeName = typeName;
	}

	public String getTypeName () {
		return typeName;
	}

	@Override
	public String toString () {
		return typeName;
	}
}

