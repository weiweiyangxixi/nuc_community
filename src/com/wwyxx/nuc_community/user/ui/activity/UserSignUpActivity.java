package com.wwyxx.nuc_community.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.c.i;
import cn.bmob.v3.listener.InitListener;
import cn.bmob.v3.listener.SaveListener;

import com.wwyxx.nuc_community.main.activity.R;
import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.util.BaseActivity;
import com.wwyxx.nuc_community.util.MyTool;

public class UserSignUpActivity extends BaseActivity implements OnClickListener {
	private Button buttonGetCheckNumber = null;
	private Button buttonSubmit = null;
	private EditText editTextCheckNumber = null;
	private EditText editTextUserName = null;
	private EditText editTextFirstPwd = null;
	private EditText editTextSecendPwd = null;
	private EditText editTextEmail = null;
	private EditText editTextNickName = null;
	private RadioGroup group = null;
	private String sexString = "男";
	private boolean agree = true;
	private CheckBox checkBox = null;
	private String usernameString = null;
	private String checkNumString = null;
	private String firstPwdString = null;
	private String secondPwdString = null;
	private String emailString = null;
	private String nickNameString = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		editTextUserName = (EditText) findViewById(R.id.tel_editText);
		editTextCheckNumber = (EditText) findViewById(R.id.input_check_number_editText);
		editTextFirstPwd = (EditText) findViewById(R.id.first_password_editText);
		editTextSecendPwd = (EditText) findViewById(R.id.check_password_editText);
		editTextEmail = (EditText) findViewById(R.id.email_editText);
		editTextNickName = (EditText) findViewById(R.id.user_name_editText);
		buttonSubmit = (Button) findViewById(R.id.signup_button);
		buttonGetCheckNumber = (Button) findViewById(R.id.get_check_number_button);
		buttonGetCheckNumber.setOnClickListener(this);
		buttonSubmit.setOnClickListener(this);
		group = (RadioGroup) this.findViewById(R.id.radioGroup);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				// 获取变更后的选中项的ID
				int radioButtonId = arg0.getCheckedRadioButtonId();
				if (radioButtonId == R.id.user_sex_woman) {
					sexString = "女";
				}
				if (radioButtonId == R.id.user_sex_man) {
					sexString = "男";
				}
				Toast.makeText(getApplicationContext(), sexString, 3).show();
			}
		});
		checkBox = (CheckBox) findViewById(R.id.agree_checkBox);

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.signup_button:
			BmobSMS.verifySmsCode(getApplicationContext(),editTextUserName.getText().toString(), editTextCheckNumber.getText().toString(), new VerifySMSCodeListener() {

			    @Override
			    public void done(BmobException ex) {
			        // TODO Auto-generated method stub
			        if(ex==null){//短信验证码已验证成功
			            Log.i("bmob", "验证通过");
			            signUp();
			        }else{
			            Log.i("bmob", "验证失败：code ="+ex.getErrorCode()+",msg = "+ex.getLocalizedMessage());
			        }
			    }
			});
			
			break;
		case R.id.get_check_number_button:
			getCheckNum();
			break;
		default:
			break;
		}
	}

	private void getCheckNum() {
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(), "获取验证码", 3).show();
		if (!editTextUserName.getText().toString().equals("")) {
			BmobSMS.requestSMSCode(getApplicationContext(), editTextUserName.getText().toString(), "短信验证",new RequestSMSCodeListener() {

			    @Override
			    public void done(Integer smsId,BmobException ex) {
			        // TODO Auto-generated method stub
			        if(ex==null){//验证码发送成功
			            Log.i("bmob", "短信id："+smsId);//用于查询本次短信发送详情
			            Toast.makeText(getApplicationContext(), "验证码已经发送到该手机", 3).show();
			        }
			    }

			});
		}else {
			Toast.makeText(getApplicationContext(), "手机号码不得为空", 3).show();
		}
		
	}

	private void signUp() {
		usernameString = editTextUserName.getText().toString();
		checkNumString = editTextCheckNumber.getText().toString();
		firstPwdString = editTextFirstPwd.getText().toString();
		secondPwdString = editTextSecendPwd.getText().toString();
		emailString = editTextEmail.getText().toString();
		nickNameString = editTextNickName.getText().toString();

		if (checkInfo()) {
			// TODO Auto-generated method stub

			NUCUser user = new NUCUser();
			user.setUsername(usernameString);
			user.setPassword(firstPwdString);
			user.setEmail(emailString);
			user.setNickName(nickNameString);
			user.setSex(sexString);
			user.signUp(getApplicationContext(), new SaveListener() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "成功", 3).show();
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(),
							UserLoginActivity.class);
					startActivity(intent);
					finish();
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "失败" + arg0 + arg1,
							3).show();
				}
			});
		}

	}


	private boolean checkInfo() {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (firstPwdString.length()<8||firstPwdString.length()>12) {
			flag = false;
			Toast.makeText(getApplicationContext(), "密码长度错误", 3).show();
		}
		if (!firstPwdString.equals(secondPwdString)) {
			flag = false;
			Toast.makeText(getApplicationContext(), "两次密码不一致"+firstPwdString+"  "+secondPwdString, 3).show();
		}
		if (!MyTool.ifAnEmailAddress(emailString)) {
			flag = false;
			Toast.makeText(getApplicationContext(), "邮箱格式错误", 3).show();
		}
		if (nickNameString.equals("")) {
			flag = false;
			Toast.makeText(getApplicationContext(), "昵称不得为空", 3).show();
		}
		
		return flag;
	}

}
