package com.wwyxx.nuc_community.school.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;
import com.wwyxx.nuc_community.schoolnews.util.SchoolGetNewsAsyncTask;
import com.wwyxx.nuc_community.schoolnews.util.SchoolNewsTool;
import com.wwyxx.nuc_community.util.NUC_CMD;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class School_XNGGFragment extends Fragment implements OnClickListener {

	private View parentView;
	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_school_news,
				container, false);
		return parentView;
	}

	private void init() {
		
		// TODO Auto-generated method stub
		listView = (ListView) this.getActivity().findViewById(R.id.listView_school_xngg);
		SchoolGetNewsAsyncTask mAsyncTask = new SchoolGetNewsAsyncTask(listView,this.getActivity(),this.getActivity().getSupportFragmentManager());
		mAsyncTask.execute(NUC_CMD.NUC_CMD_S_XNGG);
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
