package com.wwyxx.nuc_community.user;

import cn.bmob.v3.BmobUser;

public class NUCUser extends BmobUser {
	private String sex = "ÄÐ";
	private String nickName = null;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
