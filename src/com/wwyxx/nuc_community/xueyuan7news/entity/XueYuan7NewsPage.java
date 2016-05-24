package com.wwyxx.nuc_community.xueyuan7news.entity;

import java.util.ArrayList;
import java.util.List;

public class XueYuan7NewsPage {
	List<XueYuan7NewsBean> XYXW_7_beanList = new ArrayList<XueYuan7NewsBean>();
	List<XueYuan7NewsBean> XSHD_7_beanList = new ArrayList<XueYuan7NewsBean>();
	List<XueYuan7NewsBean> TZGG_7_beanList = new ArrayList<XueYuan7NewsBean>();
	List<XueYuan7NewsBean> TOP_7_beanlist = new ArrayList<XueYuan7NewsBean>();

	public List<XueYuan7NewsBean> getTOP_7_beanlist() {
		return TOP_7_beanlist;
	}

	public void setTOP_7_beanlist(List<XueYuan7NewsBean> tOP_7_beanlist) {
		TOP_7_beanlist = tOP_7_beanlist;
	}

	public List<XueYuan7NewsBean> getXYXW_7_beanList() {
		return XYXW_7_beanList;
	}

	public void setXYXW_7_beanList(List<XueYuan7NewsBean> xYXW_7_beanList) {
		XYXW_7_beanList = xYXW_7_beanList;
	}

	public List<XueYuan7NewsBean> getXSHD_7_beanList() {
		return XSHD_7_beanList;
	}

	public void setXSHD_7_beanList(List<XueYuan7NewsBean> xSHD_7_beanList) {
		XSHD_7_beanList = xSHD_7_beanList;
	}

	public List<XueYuan7NewsBean> getTZGG_7_beanList() {
		return TZGG_7_beanList;
	}

	public void setTZGG_7_beanList(List<XueYuan7NewsBean> tZGG_7_beanList) {
		TZGG_7_beanList = tZGG_7_beanList;
	}

}
