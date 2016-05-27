package com.wwyxx.nuc_community.util;

import com.wwyxx.nuc_community.schoolnews.util.SchoolNewsTool;

import android.os.AsyncTask;
import android.widget.TextView;

public class AllGetNewsContentAsnyctask extends AsyncTask<String, Void, Void> {
	
	private TextView textView ;
	private String content;
	
	public AllGetNewsContentAsnyctask(TextView textView) {
		// TODO Auto-generated constructor stub
		this.textView = textView;
	}

	@Override
	protected Void doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		content = SchoolNewsTool.getSchoolNewsBeanContentByHref(arg0[0]);
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		textView.setText(content);
	}

}
