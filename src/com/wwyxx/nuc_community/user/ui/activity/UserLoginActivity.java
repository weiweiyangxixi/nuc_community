package com.wwyxx.nuc_community.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

import com.wwyxx.nuc_community.main.activity.MainActivity;
import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.util.BaseActivity;

public class UserLoginActivity extends BaseActivity implements OnClickListener {
	private EditText editTextUserName = null;
	private EditText editTextPassWord = null;
	private Button buttonLogin = null;
	private Button buttonForgetPwd = null;
	private Button buttonSignUp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		editTextUserName = (EditText) findViewById(R.id.user_name);
		editTextPassWord = (EditText) findViewById(R.id.user_password);
		buttonLogin = (Button) findViewById(R.id.btn_user_login);
		buttonSignUp = (Button) findViewById(R.id.btn_user_signup);
		buttonForgetPwd = (Button) findViewById(R.id.btn_forget_password);
		buttonLogin.setOnClickListener(this);
		buttonSignUp.setOnClickListener(this);
		buttonForgetPwd.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btn_user_login:
			userLogin();
			break;
		case R.id.btn_user_signup:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), UserSignUpActivity.class);
			startActivity(intent1);
			break;
		case R.id.btn_forget_password:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(),
					UserForgetPwdActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

	private void userLogin() {
		// TODO Auto-generated method stub
		if (check()) {
			NUCUser user = new NUCUser();
			user.setUsername(editTextUserName.getText().toString());
			user.setPassword(editTextPassWord.getText().toString());
			user.login(getApplicationContext(), new SaveListener() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "成功", 3).show();
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					finish();
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "失败" + arg0 + arg1, 3)
							.show();
				}
			});
			
		} else {
			Toast.makeText(getApplicationContext(), "输入有误！", 3).show();
		}
		

	}

	private boolean check() {
		// TODO Auto-generated method stub
		boolean flag = true;
		String username = editTextUserName.getText().toString().trim();
		String password = editTextPassWord.getText().toString().trim();
		if (username.equals("")||password.equals("")) {
			flag = false;
		}
		return flag;
	}

}
