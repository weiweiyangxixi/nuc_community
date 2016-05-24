package com.wwyxx.nuc_community.xueyuan7news.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wwyxx.nuc_community.util.NUC_CMD;
import com.wwyxx.nuc_community.xueyuan7news.entity.XueYuan7NewsBean;
import com.wwyxx.nuc_community.xueyuan7news.entity.XueYuan7NewsPage;

public class XueYuan7NewsTool {

	public static List<XueYuan7NewsBean> xueYuan7News_GetInfoListByCMD(
			String cmd) {
		List<XueYuan7NewsBean> xYuan7NewsList = new ArrayList<XueYuan7NewsBean>();
		switch (cmd) {
		case "CMD_X_7_XYXW":
			xYuan7NewsList = xueYuan7NewsXYXW_GetHtmlByURL(NUC_CMD.NUC_URL_X_7);
			break;
		case "CMD_X_7_XSHD":
			xYuan7NewsList = xueYuan7NewsXSHD_GetHtmlByURL(NUC_CMD.NUC_URL_X_7);
			break;
		case "CMD_X_7_TZGG":
			xYuan7NewsList = xueYuan7NewsTZGG_GetHtmlByURL(NUC_CMD.NUC_URL_X_7);
			break;
		default:
			break;
		}
		return xYuan7NewsList;
	}

	public static XueYuan7NewsPage xueYuan7News_GetPage() {
		XueYuan7NewsPage xueYuan7NewsPage = new XueYuan7NewsPage();
		xueYuan7NewsPage
				.setXYXW_7_beanList(xueYuan7NewsXYXW_GetHtmlByURL(NUC_CMD.NUC_URL_X_7));
		xueYuan7NewsPage
				.setXSHD_7_beanList(xueYuan7NewsXSHD_GetHtmlByURL(NUC_CMD.NUC_URL_X_7));
		xueYuan7NewsPage
				.setTZGG_7_beanList(xueYuan7NewsTZGG_GetHtmlByURL(NUC_CMD.NUC_URL_X_7));
		return xueYuan7NewsPage;
	}

	/*
	 * 学院新闻
	 */
	public static List<XueYuan7NewsBean> xueYuan7NewsXYXW_GetHtmlByURL(
			String url) {
		List<XueYuan7NewsBean> XYXW_7_beanList = new ArrayList<XueYuan7NewsBean>();
		Document document;
		try {
			document = Jsoup
					.connect(url)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();

			// 学院新闻：标题和链接获取
			Elements elements1 = document.select("a[class]");
			for (Element element : elements1) {
				if (element.attr("abs:class").equals(
						"http://csce.nuc.edu.cn/c55152")) {
					String title = element.text();
					String href = element.attr("abs:href");
					XueYuan7NewsBean xueYuan7NewsBean = new XueYuan7NewsBean();
					xueYuan7NewsBean.setXY_7_title(title);
					xueYuan7NewsBean.setXY_7_href(href);
					XYXW_7_beanList.add(xueYuan7NewsBean);
					// System.out.println(title+"---"+href);
				}
			}
			// 学院新闻：时间获�?
			int count = 0;
			Elements elements2 = document.select("td");
			for (Element element : elements2) {
				if (element.attr("abs:class").equals(
						"http://csce.nuc.edu.cn/timestyle55152")) {
					String time = element.text();
					XYXW_7_beanList.get(count).setXY_7_time(time);
					count++;
					// System.out.println(time);
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return XYXW_7_beanList;
	}

	/*
	 * 学生活动
	 */
	public static List<XueYuan7NewsBean> xueYuan7NewsXSHD_GetHtmlByURL(
			String url) {
		List<XueYuan7NewsBean> XSHD_7_beanList = new ArrayList<XueYuan7NewsBean>();
		Document document;
		try {
			document = Jsoup
					.connect(url)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();

			// 学生活动：标题和链接获取
			Elements elements1 = document.select("a[class]");
			for (Element element : elements1) {
				if (element.attr("abs:class").equals(
						"http://csce.nuc.edu.cn/c55153")) {
					String title = element.text();
					String href = element.attr("abs:href");
					// System.out.println(title+"----"+href);
					XueYuan7NewsBean xueYuan7NewsBean = new XueYuan7NewsBean();
					xueYuan7NewsBean.setXY_7_title(title);
					xueYuan7NewsBean.setXY_7_href(href);
					XSHD_7_beanList.add(xueYuan7NewsBean);
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return XSHD_7_beanList;
	}

	/*
	 * 通知公告
	 */
	public static List<XueYuan7NewsBean> xueYuan7NewsTZGG_GetHtmlByURL(
			String url) {
		List<XueYuan7NewsBean> TZGG_7_beanList = new ArrayList<XueYuan7NewsBean>();
		Document document;
		try {
			document = Jsoup
					.connect(url)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();

			// 通知公告：标题和链接获取
			Elements elements1 = document.select("a[class]");
			for (Element element : elements1) {
				if (element.attr("abs:class").equals(
						"http://csce.nuc.edu.cn/c55154")) {
					String title = element.text();
					String href = element.attr("abs:href");
					XueYuan7NewsBean xueYuan7NewsBean = new XueYuan7NewsBean();
					xueYuan7NewsBean.setXY_7_title(title);
					xueYuan7NewsBean.setXY_7_href(href);
					TZGG_7_beanList.add(xueYuan7NewsBean);
					// System.out.println(title+"---"+href);
				}
			}
			// 通知公告：时间获�?
			Elements elements2 = document.select("td");
			int count = 0;
			for (Element element : elements2) {
				if (element.attr("abs:class").equals(
						"http://csce.nuc.edu.cn/timestyle55154")) {
					String time = element.text();
					TZGG_7_beanList.get(count).setXY_7_time(time);
					count++;
					// System.out.println(time);
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return TZGG_7_beanList;
	}

	public static String getXueYuan7NewsBeanContentByHref(String href) {
		String content = null;
		Document document;
		try {
			document = Jsoup
					.connect(href)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();
			// System.out.println(document.body().text());;
			content = document.body().text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

}
