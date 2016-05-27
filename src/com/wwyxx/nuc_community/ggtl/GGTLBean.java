package com.wwyxx.nuc_community.ggtl;

import android.R.integer;

import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.util.NUC_CMD;

import cn.bmob.v3.BmobObject;

public class GGTLBean extends BmobObject {
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String userName = null;
	private String title = null;
	private String content = null;
	private GGTLBean Pnode = null;
	private String tagString = NUC_CMD.NUC_GGTL_S;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTagString() {
		return tagString;
	}
	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public GGTLBean getPnode() {
		return Pnode;
	}
	public void setPnode(GGTLBean pnode) {
		Pnode = pnode;
	}

}
