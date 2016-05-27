package com.wwyxx.nuc_community.util;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.xueyuan7news.util.XueYuan7GetNewsAsyncTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class AllNewsContentFragment extends Fragment {
	private View parentView;
	private TextView textView;
	private String hrefString;
	
	
	public AllNewsContentFragment(String href)
	{
		super();
		this.hrefString = href;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_all_newspage, container,
				false);
		return parentView;
	}
	private void init() {
		// TODO Auto-generated method stub
		textView = (TextView) this.getActivity().findViewById(R.id.textView_all_news_page_textview);
		AllGetNewsContentAsnyctask mAsnyctask = new AllGetNewsContentAsnyctask(textView);
		mAsnyctask.execute(hrefString);
		
	}
	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        init();
        
    }  

}
