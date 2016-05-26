package com.wwyxx.nuc_community.util;

public class MyTool {
	/*
	 * 判断字符串是否为一个邮箱地址
	 */
	public static boolean ifAnEmailAddress(String email) {
		boolean tag = false;
		if (!email
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			// System.out.println("邮箱格式不正确");
		} else {
			// System.out.println("邮箱格式正确");
			tag = true;
		}
		return tag;
	}

}
