package com.wwyxx.nuc_community.util;

public class MyTool {
	/*
	 * �ж��ַ����Ƿ�Ϊһ�������ַ
	 */
	public static boolean ifAnEmailAddress(String email) {
		boolean tag = false;
		if (!email
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			// System.out.println("�����ʽ����ȷ");
		} else {
			// System.out.println("�����ʽ��ȷ");
			tag = true;
		}
		return tag;
	}

}
