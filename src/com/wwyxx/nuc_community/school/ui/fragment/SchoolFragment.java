package com.wwyxx.nuc_community.school.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.schoolnews.entity.SchoolNewsPage;
import com.wwyxx.nuc_community.schoolnews.util.SchoolNewsTool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SchoolFragment extends Fragment implements OnClickListener {
	private View parentView;
	private TextView tab_school_xngg = null;
	private TextView tab_school_zbxw = null;
	private TextView tab_school_ggtl = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_school, container,
				false);
		changeFragment(new School_XNGGFragment());
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
		tab_school_xngg = (TextView) this.getActivity().findViewById(R.id.textView_tab_school_xngg);
		tab_school_zbxw = (TextView) this.getActivity().findViewById(R.id.textView_tab_school_zbxw);
		tab_school_ggtl = (TextView) this.getActivity().findViewById(R.id.textView_tab_school_ggtl);
		tab_school_xngg.setOnClickListener(this);
		tab_school_zbxw.setOnClickListener(this);
		tab_school_ggtl.setOnClickListener(this);
	}
	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        init();
    }  

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.textView_tab_school_xngg:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_school_xngg", 3).show();
			changeFragment(new School_XNGGFragment());
			break;
		case R.id.textView_tab_school_zbxw:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_school_zbxw", 3).show();
			changeFragment(new School_ZBXWFragment());
			break;
		case R.id.textView_tab_school_ggtl:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_school_ggtl", 3).show();
			changeFragment(new School_GGTLFragment());
			break;
		default:
			break;
		}

	}
	private void changeFragment(Fragment targetFragment) {
		this.getActivity().getSupportFragmentManager().beginTransaction()
				.replace(R.id.school_main_fragment, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}
}
