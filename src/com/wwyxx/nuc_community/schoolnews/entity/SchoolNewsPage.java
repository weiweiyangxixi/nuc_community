package com.wwyxx.nuc_community.schoolnews.entity;

import java.util.ArrayList;
import java.util.List;

import com.wwyxx.nuc_community.schoolnews.util.SchoolNewsTool;

public class SchoolNewsPage {
	private SchoolNewsPage beforPage = null;
	private SchoolNewsPage nextPage = null;
	private String XNGG_befor = null;
	private String XNGG_next = null;
	private List<SchoolNewsBean> XNGG_beanList = new ArrayList<SchoolNewsBean>();
	public String getXNGG_befor() {
		return XNGG_befor;
	}
	public void setXNGG_befor(String xNGG_befor) {
		XNGG_befor = xNGG_befor;
	}
	public String getXNGG_next() {
		return XNGG_next;
	}
	public void setXNGG_next(String xNGG_next) {
		XNGG_next = xNGG_next;
	}
	public List<SchoolNewsBean> getXNGG_beanList() {
		return XNGG_beanList;
	}
	public void setXNGG_beanList(List<SchoolNewsBean> xNGG_beanList) {
		XNGG_beanList = xNGG_beanList;
	}
	public SchoolNewsPage getBeforPage() {
		if (this.XNGG_befor!=null) {
			beforPage = SchoolNewsTool.schoolNewsXNGG_GetHTMLByURL(XNGG_befor);
		}
		return beforPage;
	}
	public void setBeforPage(SchoolNewsPage beforPage) {
		this.beforPage = beforPage;
	}
	public SchoolNewsPage getNextPage() {
		if (this.XNGG_next!=null) {
			nextPage = SchoolNewsTool.schoolNewsXNGG_GetHTMLByURL(XNGG_next);
		}
		return nextPage;
	}
	public void setNextPage(SchoolNewsPage nextPage) {
		this.nextPage = nextPage;
	}
	
}
