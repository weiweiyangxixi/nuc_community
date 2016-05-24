package com.wwyxx.nuc_community.xueyuan7news.entity;

import com.wwyxx.nuc_community.xueyuan7news.util.XueYuan7NewsTool;

public class XueYuan7NewsBean {
	private String XY_7_title = null;
	private String XY_7_href = null;
	private String XY_7_time = null;
	private String XY_7_content = null;

	public String getXY_7_title() {
		return XY_7_title;
	}

	public void setXY_7_title(String xY_7_title) {
		XY_7_title = xY_7_title;
	}

	public String getXY_7_href() {
		return XY_7_href;
	}

	public void setXY_7_href(String xY_7_href) {
		XY_7_href = xY_7_href;
	}

	public String getXY_7_time() {
		return XY_7_time;
	}

	public void setXY_7_time(String xY_7_time) {
		XY_7_time = xY_7_time;
	}

	public String getXY_7_content() {
		XY_7_content = XueYuan7NewsTool.getXueYuan7NewsBeanContentByHref(this.XY_7_href);
		return XY_7_content;
	}

	public void setXY_7_content(String xY_7_content) {
		XY_7_content = xY_7_content;
	}

}
