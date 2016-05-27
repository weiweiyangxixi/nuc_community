package com.wwyxx.nuc_community.main.activity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

import com.wwyxx.nuc_community.school.ui.fragment.SchoolFragment;
import com.wwyxx.nuc_community.shezhi.ui.fragment.SheZhiFragment;
import com.wwyxx.nuc_community.shoucang.ui.fragment.ShouCangFragment;
import com.wwyxx.nuc_community.user.NUCUser;
import com.wwyxx.nuc_community.user.ui.activity.UserInfoActivity;
import com.wwyxx.nuc_community.user.ui.activity.UserLoginActivity;
import com.wwyxx.nuc_community.util.ResideMenu;
import com.wwyxx.nuc_community.util.ResideMenuInfo;
import com.wwyxx.nuc_community.util.ResideMenuItem;
import com.wwyxx.nuc_community.xueyuan.ui.fragment.XueYuanFragment;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		View.OnClickListener {

	private ResideMenu resideMenu;// ��߲˵�
	private ResideMenuItem itemXiaoYuan;// �˵�item
	private ResideMenuItem itemXueYuan;
	private ResideMenuItem itemSheZhi;
	private ResideMenuItem itemShouCang;
	private ResideMenuInfo info;
	private TextView textViewXuanZeXueYuan, textViewYeWanPiFu;
	private boolean is_closed = false;
	private long mExitTime;
	private Button leftMenu;
	private int dandQianXueYuan = 7;
	private boolean yeWanPiFu = false;//
	private NUCUser localUser = null;

	public NUCUser getLocalUser() {
		return localUser;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Bmob.initialize(getApplicationContext(),
				"c35eaaabcbdfe3df0ebcabc3babd4159");
		initLocalUser();
		setUpMenu();
		changeFragment(new SchoolFragment());
		setListenerOfSmallItem();
		setListener();
	}

	private void initLocalUser() {
		// TODO Auto-generated method stub
		localUser = (NUCUser) BmobUser.getCurrentUser(this, NUCUser.class);
	}

	private void setListenerOfSmallItem() {
		textViewXuanZeXueYuan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showListDia();
			}
		});
		textViewYeWanPiFu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				yeWanPiFu = !yeWanPiFu;
				if (yeWanPiFu) {
					resideMenu.setBackground(R.drawable.menu_bkg_yw);
					textViewYeWanPiFu.setText("Ĭ��Ƥ��");
				} else {
					resideMenu.setBackground(R.drawable.menu_bkg_normal);
					textViewYeWanPiFu.setText("ҹ��Ƥ��");
				}
			}
		});

	}

	private void setListener() {
		// TODO Auto-generated method stub
		resideMenu.addMenuInfo(info);

		itemXiaoYuan.setOnClickListener(this);
		itemXueYuan.setOnClickListener(this);
		itemSheZhi.setOnClickListener(this);
		itemShouCang.setOnClickListener(this);
		info.setOnClickListener(this);

		leftMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
			}
		});

	}

	@SuppressWarnings("deprecation")
	private void setUpMenu() {
		leftMenu = (Button) findViewById(R.id.title_bar_left_menu);

		// attach to current activity;
		resideMenu = new ResideMenu(this);
		resideMenu.setBackground(R.drawable.menu_bkg_normal);
		resideMenu.attachToActivity(this);
		resideMenu.setMenuListener(menuListener);
		// valid scale factor is between 0.0f and 1.0f. leftmenu'width is
		// 150dip.
		resideMenu.setScaleValue(0.6f);
		// ��ֹʹ���Ҳ�˵�
		resideMenu.setDirectionDisable(ResideMenu.DIRECTION_RIGHT);

		// create menu items;
		itemXiaoYuan = new ResideMenuItem(this, R.drawable.menu_item_xiaoyuan,
				"У԰");
		itemXueYuan = new ResideMenuItem(this, R.drawable.menu_item_xueyuan_7,
				"ѧԺ");
		itemShouCang = new ResideMenuItem(this, R.drawable.menu_item_shoucang,
				"�ղ�");
		itemSheZhi = new ResideMenuItem(this, R.drawable.menu_item_shezhi, "����");

		resideMenu.addMenuItem(itemXiaoYuan, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemXueYuan, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemShouCang, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemSheZhi, ResideMenu.DIRECTION_LEFT);

		textViewXuanZeXueYuan = (TextView) findViewById(R.id.textView_xuanzexueyuan);
		textViewYeWanPiFu = (TextView) findViewById(R.id.textView_yewanpifu);

		if (localUser == null) {
			info = new ResideMenuInfo(this, R.drawable.ic_launcher, "�����¼",
					"���ͼƬ��¼");
		} else {
			info = new ResideMenuInfo(this, R.drawable.ic_launcher,
					localUser.getNickName(), "");
		}
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if (view == itemXiaoYuan) {
			changeFragment(new SchoolFragment());
		} else if (view == itemXueYuan) {
			changeFragment(new XueYuanFragment());
		} else if (view == itemSheZhi) {
			changeFragment(new SheZhiFragment());
		} else if (view == itemShouCang) {
			changeFragment(new ShouCangFragment());
		} else if (view == info) {
			if (localUser == null) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						UserLoginActivity.class);
				startActivity(intent);

			} else {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						UserInfoActivity.class);
				startActivity(intent);
			}

		}

	}

	private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
		@Override
		public void openMenu() {
			is_closed = false;
			leftMenu.setVisibility(View.GONE);
		}

		@Override
		public void closeMenu() {
			is_closed = true;
			leftMenu.setVisibility(View.VISIBLE);
		}
	};

	private void changeFragment(Fragment targetFragment) {
		resideMenu.clearIgnoredViewList();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.main_fragment, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}

	// �����ֻ��ϵ�BACK��
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// �жϲ˵��Ƿ�ر�
			if (is_closed) {
				// �ж����ε����ʱ������Ĭ������Ϊ2�룩
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();

					mExitTime = System.currentTimeMillis();
				} else {
					finish();
					System.exit(0);
					super.onBackPressed();
				}
			} else {
				resideMenu.closeMenu();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	// What good method is to access resideMenu��
	public ResideMenu getResideMenu() {
		return resideMenu;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return resideMenu.dispatchTouchEvent(ev);
	}

	private void showListDia() {
		final String[] mList = { "���繤��ѧԺ", "��е�붯������ѧԺ", "���Ͽ�ѧ�빤��ѧԺ", "�����뻷��ѧԺ",
				"��Ϣ��ͨ�Ź���ѧԺ", "���������ѧԺ", "���������ƹ���ѧԺ", "��ѧԺ", "���������ѧԺ",
				"��������ѧѧԺ", "����ѧԺ", "����ѧԺ", "���ѧԺ", "�о���Ժ", "��������ѧԺ",
				"�󱸾��ٽ���ѧԺ", "���ʽ���ѧԺ", "��Ϣ����ѧԺ" };
		AlertDialog.Builder listDia = new AlertDialog.Builder(MainActivity.this);
		listDia.setTitle("ѡ��ѧԺ");
		listDia.setItems(mList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				/* �±��Ǵ�0��ʼ�� */
				dandQianXueYuan = which + 1;
				Toast.makeText(getApplicationContext(), dandQianXueYuan + "", 3)
						.show();
			}

		});
		listDia.create().show();
	}
}
