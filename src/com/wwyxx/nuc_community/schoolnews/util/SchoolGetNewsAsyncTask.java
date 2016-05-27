package com.wwyxx.nuc_community.schoolnews.util;

import java.util.ArrayList;
import java.util.List;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsBean;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;
import com.wwyxx.nuc_community.util.AllNewsContentFragment;
import com.wwyxx.nuc_community.util.NUC_CMD;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SchoolGetNewsAsyncTask extends
		AsyncTask<String, Void, List<String>> {

	private SchoolNewsPage schoolNewsPage;
	private ListView listView;
	private ArrayAdapter<String> mArrayAdapter;
	private Context context;
	private FragmentManager fragmentManager;
	private List<String> titleList = new ArrayList<String>();
	private List<String> hrefList = new ArrayList<String>();

	public SchoolGetNewsAsyncTask(ListView listView, Context context,
			FragmentManager fragmentManager) {
		this.listView = listView;
		this.context = context;
		this.fragmentManager = fragmentManager;
	}

	@Override
	protected List<String> doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		try {
			SchoolNewsTool schoolNewsTool = new SchoolNewsTool();
			schoolNewsPage = schoolNewsTool
					.schoolNewsXNGG_GetHTMLByURLCMD(arg0[0]);
			for (int i = 0; i < schoolNewsPage.getXNGG_beanList().size(); i++) {
				titleList.add(schoolNewsPage.getXNGG_beanList().get(i)
						.getXNGG_title());
				hrefList.add(schoolNewsPage.getXNGG_beanList().get(i)
						.getXNGG_href());
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
		listView.setOnItemClickListener(new ItemClickEvent(result, context));

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
					fragmentManager.beginTransaction().replace(R.id.school_main_fragment, new AllNewsContentFragment(hrefString), "fragment")
					.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
					.commit();
				}	
				
			}
}
