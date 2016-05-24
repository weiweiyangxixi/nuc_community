package com.wwyxx.nuc_community.xueyuan.ui.fragment;

import com.wwyxx.nuc_community.main.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class XueYuanFragment extends Fragment implements OnClickListener{
	private View parentView;

	private TextView tab_xueyuan_xyxw = null;
	private TextView tab_xueyuan_xshd = null;
	private TextView tab_xueyuan_tzgg = null;
	private TextView tab_xueyuan_ggtl = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_xueyuan, container,
				false);
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
		tab_xueyuan_xyxw = (TextView) this.getActivity().findViewById(R.id.textView_tab_xueyuan_xyxw);
		tab_xueyuan_xshd = (TextView) this.getActivity().findViewById(R.id.textView_tab_xueyuan_xshd);
		tab_xueyuan_tzgg = (TextView) this.getActivity().findViewById(R.id.textView_tab_xueyuan_tzgg);
		tab_xueyuan_ggtl = (TextView) this.getActivity().findViewById(R.id.textView_tab_xueyuan_ggtl);
		tab_xueyuan_xyxw.setOnClickListener(this);
		tab_xueyuan_xshd.setOnClickListener(this);
		tab_xueyuan_tzgg.setOnClickListener(this);
		tab_xueyuan_ggtl.setOnClickListener(this);
	}
	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        init();
    }  

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.textView_tab_xueyuan_xyxw:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_xueyuan_xyxw", 3).show();
			break;
		case R.id.textView_tab_xueyuan_xshd:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_xueyuan_xshd", 3).show();
			break;
		case R.id.textView_tab_xueyuan_tzgg:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_xueyuan_tzgg", 3).show();
			break;
		case R.id.textView_tab_xueyuan_ggtl:
			Toast.makeText(this.getActivity().getApplicationContext(), "textView_tab_xueyuan_ggtl", 3).show();
			break;
		default:
			break;
		}

	}

}
