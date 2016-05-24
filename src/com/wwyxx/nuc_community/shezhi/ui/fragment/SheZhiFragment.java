package com.wwyxx.nuc_community.shezhi.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SheZhiFragment extends Fragment {
	private View parentView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_shezhi, container, false);

		return parentView;
	}

}
