package com.wwyxx.nuc_community.util;

import cn.bmob.sms.BmobSMS;
import cn.bmob.v3.Bmob;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.school.ui.fragment.SchoolFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Bmob.initialize(getApplicationContext(), "c35eaaabcbdfe3df0ebcabc3babd4159");
		BmobSMS.initialize(getApplicationContext(),"c35eaaabcbdfe3df0ebcabc3babd4159");
	}


}
