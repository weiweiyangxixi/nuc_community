package com.wwyxx.nuc_community.xueyuan.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class XueYuan_GGTLFragment extends Fragment implements OnClickListener{
	private View parentView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_all_ggtl, container,
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
