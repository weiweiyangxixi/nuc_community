package com.wwyxx.nuc_community.xueyuan.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.schoolnews.util.SchoolGetNewsAsyncTask;
import com.wwyxx.nuc_community.util.NUC_CMD;
import com.wwyxx.nuc_community.xueyuan7news.util.XueYuan7GetNewsAsyncTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class XueYuan_XYXWFragment extends Fragment implements OnClickListener{
	private View parentView;
	private ListView mListView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_xueyuan_news, container,
				false);
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
		mListView = (ListView) this.getActivity().findViewById(R.id.listView_xueyuan_xueyuannews);
		XueYuan7GetNewsAsyncTask mAsyncTask = new XueYuan7GetNewsAsyncTask(mListView,this.getActivity().getSupportFragmentManager(),this.getActivity());
		mAsyncTask.execute(NUC_CMD.NUC_CMD_X_7_XYXW);
	}
	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        init();
        
    }  

	@Override
	public void onClick(View view) {
		
	}
}
