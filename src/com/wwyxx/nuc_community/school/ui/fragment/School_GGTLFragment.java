package com.wwyxx.nuc_community.school.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.wwyxx.nuc_community.ggtl.GGTLBean;
import com.wwyxx.nuc_community.main.activity.MainActivity;
import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.user.ui.activity.UserLoginActivity;
import com.wwyxx.nuc_community.util.NUC_CMD;

public class School_GGTLFragment extends Fragment implements OnClickListener {
	private View parentView;
	private ListView listView;
	private ArrayAdapter<String> mArrayAdapter;
	private List<String> titlelList = new ArrayList<String>();
	private List<GGTLBean> ggtlBeanList;
	private Button buttonGGTLSubmit = null;
	private NUCUser localUser = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_all_ggtl,
				container, false);
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
		listView = (ListView) getActivity().findViewById(R.id.listView_all_ggtl);
		buttonGGTLSubmit = (Button) this.getActivity().findViewById(
				R.id.button_ggtl_submit);
		buttonGGTLSubmit.setOnClickListener(this);
		BmobQuery<GGTLBean> query = new BmobQuery<GGTLBean>();
		query.addWhereEqualTo("tagString", NUC_CMD.NUC_GGTL_S);
		query.setLimit(50);
		query.findObjects(getActivity(), new FindListener<GGTLBean>() {

			@Override
			public void onSuccess(List<GGTLBean> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(),
						"努力加载中...", 3).show();
				Log.d("wwtxx",
						"-----------------------------------------------------------------");
				ggtlBeanList = arg0;
				for (int i = 0; i < arg0.size(); i++) {
					titlelList.add(arg0.get(i).getTitle());
					Log.d("wwtxx", arg0.get(i).getTitle());
				}
				Log.d("wwtxx",
						"-----------------------------------------------------------------");
				mArrayAdapter = new ArrayAdapter<>(getActivity()
						.getApplicationContext(), android.R.layout.simple_list_item_1,
						titlelList);
				listView.setAdapter(mArrayAdapter);
			}

			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(),
						"连接失败" + arg1, 3).show();
			}
		});
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_ggtl_submit:
			popGGTLSubmitDia();
			break;

		default:
			break;
		}
	}

	/* 自定义对话框 */
	private void popGGTLSubmitDia() {
		AlertDialog.Builder ggtlSubmitDia = new AlertDialog.Builder(
				getActivity());
		final View viewDia = LayoutInflater.from(getActivity()).inflate(
				R.layout.ggtl_dialog, null);
		ggtlSubmitDia.setTitle("发表公共讨论");
		ggtlSubmitDia.setView(viewDia);
		ggtlSubmitDia.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						EditText diaInput = (EditText) viewDia
								.findViewById(R.id.editText_ggtl_input);
						EditText diaTitle = (EditText) viewDia
								.findViewById(R.id.editText_ggtl_title);
						if (checkLocalUser()) {
							submitGGTL(diaInput.getText().toString(), diaTitle
									.getText().toString());
						}
					}

				});
		ggtlSubmitDia.create().show();
	}

	protected void submitGGTL(String string, String string2) {
		// TODO Auto-generated method stub

		// Toast.makeText(getActivity().getApplicationContext(), string2,
		// 3).show();
		GGTLBean ggtl = new GGTLBean();
		ggtl.setContent(string);
		ggtl.setTitle(string2);
		ggtl.setPnode(null);
		ggtl.setUserName(localUser.getUsername());
		ggtl.save(getActivity(), new SaveListener() {

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(),
						"success", 3).show();
				titlelList.clear();
				ggtlBeanList.clear();
				init();
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(),
						"faild" + arg0 + arg1, 3).show();
			}
		});
	}

	private boolean checkLocalUser() {
		// TODO Auto-generated method stub
		boolean flag = true;
		localUser = (NUCUser) BmobUser.getCurrentUser(getActivity()
				.getApplicationContext(), NUCUser.class);
		if (localUser == null) {
			flag = false;
			Toast.makeText(getActivity().getApplicationContext(), "请先登录", 3)
					.show();
			Intent intent = new Intent();
			intent.setClass(getActivity().getApplicationContext(),
					UserLoginActivity.class);
			startActivity(intent);
		}
		return flag;
	}
}
