package com.wwyxx.nuc_community.ggtl;

import android.R.integer;

import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.util.NUC_CMD;

import cn.bmob.v3.BmobObject;

public class GGTLBean extends BmobObject {
	private NUCUser user = null;
	private String content = null;
	private GGTLBean Pnode = null;
	private String tagString = NUC_CMD.NUC_GGTL_S;
	public NUCUser getUser() {
		return user;
	}
	public void setUser(NUCUser user) {
		this.user = user;
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
