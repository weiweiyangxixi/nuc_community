package com.wwyxx.nuc_community.xueyuan7news.util;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.a.a.This;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;
import com.wwyxx.nuc_community.schoolnews.util.SchoolNewsTool;
import com.wwyxx.nuc_community.util.AllNewsContentFragment;
import com.wwyxx.nuc_community.xueyuan7news.entity.XueYuan7NewsBean;
import com.wwyxx.nuc_community.xueyuan7news.entity.XueYuan7NewsPage;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class XueYuan7GetNewsAsyncTask extends
		AsyncTask<String, Void, List<String>> {

	private ListView listView;
	private ArrayAdapter<String> mArrayAdapter;
	private  Context context;
	private  FragmentManager fragmentManager;
	private List<XueYuan7NewsBean> xueYuan7NewsList = null;
	private List<String> titleList = new ArrayList<String>();
	private List<String> hrefList = new ArrayList<String>();

	public XueYuan7GetNewsAsyncTask(ListView listView,FragmentManager fragmentManager,Context context) {
		this.listView = listView;
		this.context = context;
		this.fragmentManager = fragmentManager;
	}

	@Override
	protected List<String> doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		try {
			// Log.d("wwyxx_test", "1111111111111111111111111111");
			XueYuan7NewsTool xueYuan7NewsTool = new XueYuan7NewsTool();
			// Log.d("wwyxx_test", "2222222222222222222222222222");
			xueYuan7NewsList = XueYuan7NewsTool
					.xueYuan7News_GetInfoListByCMD(arg0[0]);
			// Log.d("wwyxx_test",
			// xueYuan7NewsList.size()+"     33333333333333333333333333333333333333333333");
			for (int i = 0; i < xueYuan7NewsList.size(); i++) {
				titleList.add(xueYuan7NewsList.get(i).getXY_7_title());
				hrefList.add(xueYuan7NewsList.get(i).getXY_7_href());
				// Log.d("wwyxx_test", xueYuan7NewsList.get(i).getXY_7_title());
			}
			mArrayAdapter = new ArrayAdapter<>(context,
					android.R.layout.simple_list_item_1, titleList);
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("wwyxx_test", "网络错误");
		}
		return hrefList;
	}

	@Override
	protected void onPostExecute(List<String> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		listView.setAdapter(mArrayAdapter);
		listView.setOnItemClickListener(new ItemClickEvent(result,context));
	}
	//继承OnItemClickListener，当子项目被点击的时候触发
		private final class ItemClickEvent implements OnItemClickListener{
			private List<String> href;
			private  Context mcontext;
			public ItemClickEvent(List<String> href,Context context)
			{
				this.href = href;
				this.mcontext = context;
			}
			@Override
			//这里需要注意的是第三个参数arg2，这是代表单击第几个选项
			public void onItemClick(AdapterView arg0, View arg1, int arg2,
					long arg3) {
				String hrefString = href.get(arg2);
				Log.d("------>", hrefString);
				fragmentManager.beginTransaction().replace(R.id.xueyuan_main_fragment, new AllNewsContentFragment(hrefString), "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
			}	
			
		}

}
