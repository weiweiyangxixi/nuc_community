package com.wwyxx.nuc_community.schoolnews.util;

import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsBean;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;
import com.wwyxx.nuc_community.util.NUC_CMD;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SchoolGetNewsAsyncTask extends AsyncTask<String, Void, Void> {

	private SchoolNewsPage schoolNewsPage;
	private ListView listView;
	private ArrayAdapter<SchoolNewsBean> mArrayAdapter;
	private Context context ;
	
	public SchoolGetNewsAsyncTask(ListView listView,Context context){
		this.listView = listView;
		this.context = context;
	}

	@Override
	protected Void doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		try {
			SchoolNewsTool schoolNewsTool = new SchoolNewsTool();
			schoolNewsPage = schoolNewsTool.schoolNewsXNGG_GetHTMLByURLCMD(arg0[0]);
			mArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, schoolNewsPage.getXNGG_beanList());
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("wwyxx_test", "ÍøÂç´íÎó");
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		listView.setAdapter(mArrayAdapter);
	}
}
