package com.wwyxx.nuc_community.xueyuan.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class XueYuan_XYXWFragment extends Fragment implements OnClickListener{
	private View parentView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_xueyuan_news, container,
				false);
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
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
