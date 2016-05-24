package com.wwyxx.nuc_community.main.activity;

import com.wwyxx.nuc_community.school.ui.fragment.SchoolFragment;
import com.wwyxx.nuc_community.shezhi.ui.fragment.SheZhiFragment;
import com.wwyxx.nuc_community.shoucang.ui.fragment.ShouCangFragment;
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

	private ResideMenu resideMenu;// 侧边菜单
	private ResideMenuItem itemXiaoYuan;// 菜单item
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		setUpMenu();
		changeFragment(new SchoolFragment());
		setListenerOfSmallItem();
		setListener();
	}

	private void setListenerOfSmallItem() {
		textViewXuanZeXueYuan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showListDia() ;
			}
		});
		textViewYeWanPiFu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				yeWanPiFu = !yeWanPiFu;
				if (yeWanPiFu) {
					resideMenu.setBackground(R.drawable.menu_bkg_yw);
					textViewYeWanPiFu.setText("默认皮肤");
				} else {
					resideMenu.setBackground(R.drawable.menu_bkg_normal);
					textViewYeWanPiFu.setText("夜晚皮肤");
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
		// 禁止使用右侧菜单
		resideMenu.setDirectionDisable(ResideMenu.DIRECTION_RIGHT);

		// create menu items;
		itemXiaoYuan = new ResideMenuItem(this, R.drawable.menu_item_xiaoyuan,
				"校园");
		itemXueYuan = new ResideMenuItem(this, R.drawable.menu_item_xueyuan_7,
				"学院");
		itemShouCang = new ResideMenuItem(this, R.drawable.menu_item_shoucang,
				"收藏");
		itemSheZhi = new ResideMenuItem(this, R.drawable.menu_item_shezhi, "设置");

		resideMenu.addMenuItem(itemXiaoYuan, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemXueYuan, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemShouCang, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemSheZhi, ResideMenu.DIRECTION_LEFT);
		
		textViewXuanZeXueYuan = (TextView) findViewById(R.id.textView_xuanzexueyuan);
		textViewYeWanPiFu = (TextView) findViewById(R.id.textView_yewanpifu);

		info = new ResideMenuInfo(this, R.drawable.ic_launcher, "中北社区", "");

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
			// Intent intent = new Intent();
			// intent.putExtra("flog", "个人信息");
			// intent.setClass(getApplicationContext(), SettingActivity.class);
			// startActivity(intent);
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

	// 监听手机上的BACK键
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// 判断菜单是否关闭
			if (is_closed) {
				// 判断两次点击的时间间隔（默认设置为2秒）
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();

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

	// What good method is to access resideMenu？
	public ResideMenu getResideMenu() {
		return resideMenu;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return resideMenu.dispatchTouchEvent(ev);
	}
	private void showListDia()  
    {  
        final String[] mList={"机电工程学院","机械与动力工程学院","材料科学与工程学院","化工与环境学院","信息与通信工程学院","仪器与电子学院","计算机与控制工程学院","理学院","经济与管理学院","人文社会科学学院","体育学院","艺术学院","软件学院","研究生院","继续教育学院","后备军官教育学院","国际教育学院","信息商务学院"};  
        AlertDialog.Builder listDia=new AlertDialog.Builder(MainActivity.this);  
        listDia.setTitle("选择学院");  
        listDia.setItems(mList, new DialogInterface.OnClickListener() {  
              
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
                // TODO Auto-generated method stub  
                /*下标是从0开始的*/  
                dandQianXueYuan = which+1; 
                Toast.makeText(getApplicationContext(), dandQianXueYuan+"", 3).show();
            }
 
        });  
        listDia.create().show();  
    } 
}
