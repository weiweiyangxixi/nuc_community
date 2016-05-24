package com.wwyxx.nuc_community.schoolnews.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsBean;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;

public class SchoolNewsTool {

	public static String S_XNGG;
	public static String S_ZBXW;

	public static SchoolNewsPage schoolNewsXNGG_GetHTMLByURLCMD(String urlCMD) {
		String url = null;

		Document doc;
		try {
			doc = Jsoup
					.connect("http://www.nuc.edu.cn")
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();
			getAllUrl(doc);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		switch (urlCMD) {
		case "CMD_S_XNGG":
			url = S_XNGG;
			//System.out.println("url=" + url);
			break;
		case "CMD_S_ZBXW":
			url = S_ZBXW;
			//System.out.println("url=" + url);
		default:
			//System.out.println("CMD_S_?");
			break;
		}
		SchoolNewsPage schoolNewsXNGGPage = new SchoolNewsPage();
		Document document;
		try {
			document = Jsoup
					.connect(url)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();
			getAllUrl(document);
			// �õ�У�ڹ���ı��������
			Elements elements1 = document.select("a[class]");
			for (Element element : elements1) {
				if ("http://www.nuc.edu.cn/c1161".equals(element
						.attr("abs:class"))) {
					String titleString = element.text();
					String hrefString = element.attr("abs:href");
					// System.out.println(titleString+hrefString);
					SchoolNewsBean schoolNewsXNGGBean = new SchoolNewsBean();
					schoolNewsXNGGBean.setXNGG_href(hrefString);
					schoolNewsXNGGBean.setXNGG_title(titleString);
					schoolNewsXNGGPage.getXNGG_beanList().add(
							schoolNewsXNGGBean);
				}
			}
			int count = 0;
			// �õ�У�ڹ����ʱ��??
			Elements elements2 = document.select("td[class]");
			for (Element element : elements2) {
				if ("http://www.nuc.edu.cn/timestyle1161".equals(element
						.attr("abs:class"))) {
					String timeString = element.text();
					// System.out.println(count + timeString);
					schoolNewsXNGGPage.getXNGG_beanList().get(count)
							.setXNGG_time(timeString);
					count++;
				}
			}
			// �õ�У�ڹ������ҳ����ҳ������??
			Elements elements3 = document.select("a[href]");
			for (Element element : elements3) {
				if ("http://www.nuc.edu.cn/Next".equals(element
						.attr("abs:class"))) {
					// System.out.println("��ҳ"+element.attr("abs:href"));
					schoolNewsXNGGPage.setXNGG_next(element.attr("abs:href"));
				}
				if ("http://www.nuc.edu.cn/Prev".equals(element
						.attr("abs:class"))) {
					// System.out.println("��ҳ"+element.attr("abs:href"));
					schoolNewsXNGGPage.setXNGG_befor(element.attr("abs:href"));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schoolNewsXNGGPage;
	}

	public static SchoolNewsPage schoolNewsXNGG_GetHTMLByURL(String url) {
		SchoolNewsPage schoolNewsXNGGPage = new SchoolNewsPage();
		Document document;
		try {
			document = Jsoup
					.connect(url)
					.timeout(5000)
					.ignoreHttpErrors(true)
					.header("User-Agent",
							"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
					.get();
			getAllUrl(document);
			// �õ�У�ڹ���ı��������
			Elements elements1 = document.select("a[class]");
			for (Element element : elements1) {
				if ("http://www.nuc.edu.cn/c1161".equals(element
						.attr("abs:class"))) {
					String titleString = element.text();
					String hrefString = element.attr("abs:href");
					// System.out.println(titleString+hrefString);
					SchoolNewsBean schoolNewsXNGGBean = new SchoolNewsBean();
					schoolNewsXNGGBean.setXNGG_href(hrefString);
					schoolNewsXNGGBean.setXNGG_title(titleString);
					schoolNewsXNGGPage.getXNGG_beanList().add(
							schoolNewsXNGGBean);
				}
			}
			int count = 0;
			// �õ�У�ڹ����ʱ��??
			Elements elements2 = document.select("td[class]");
			for (Element element : elements2) {
				if ("http://www.nuc.edu.cn/timestyle1161".equals(element
						.attr("abs:class"))) {
					String timeString = element.text();
					// System.out.println(count + timeString);
					schoolNewsXNGGPage.getXNGG_beanList().get(count)
							.setXNGG_time(timeString);
					count++;
				}
			}
			// �õ�У�ڹ������ҳ����ҳ������??
			Elements elements3 = document.select("a[href]");
			for (Element element : elements3) {
				if ("http://www.nuc.edu.cn/Next".equals(element
						.attr("abs:class"))) {
					// System.out.println("��ҳ"+element.attr("abs:href"));
					schoolNewsXNGGPage.setXNGG_next(element.attr("abs:href"));
				}
				if ("http://www.nuc.edu.cn/Prev".equals(element
						.attr("abs:class"))) {
					// System.out.println("��ҳ"+element.attr("abs:href"));
					schoolNewsXNGGPage.setXNGG_befor(element.attr("abs:href"));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schoolNewsXNGGPage;
	}

	public static void getAllUrl(Document document) {
		Elements elements = document.select("td>a[href]");
		int i = 0;
		for (Element element : elements) {
			if (("" + i).toString().equals("1")) {
				// System.out.println(element.attr("abs:href"));
				S_XNGG = element.attr("abs:href");
			}
			if (("" + i).toString().equals("2")) {
				// System.out.println(element.attr("abs:href"));
				S_ZBXW = element.attr("abs:href");
			}
			i++;
		}
	}

	public static String getSchoolNewsBeanContentByHref(String href) {
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
			//System.out.println(document.body().text());;
			content = document.body().text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

}
