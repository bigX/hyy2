package com.hiyaya.activity;

import com.example.hiyaya.R;
import com.hiyaya.utl.AccelerateLinearDecelerateProgressBar;

import cn.smilecity.utl.AlertUtl;
import cn.smilecity.utl.PreferenceConstants;
import cn.smilecity.utl.PreferenceUtils;
import android.content.Context;
import android.content.Intent;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

public class SplashActivity extends FragmentActivity {
	private Handler mHandler;
	private AccelerateLinearDecelerateProgressBar mAccelerateLinearDecelerateProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mAccelerateLinearDecelerateProgressBar = (AccelerateLinearDecelerateProgressBar) findViewById(R.id.accelerateLinearDecelerateProgressBar);

		if (!isNetworkConnected(this)) {
			AlertUtl.alert(this, "网络不可用，请检查网络连接。");
			return;
		}

		mHandler = new Handler();
		String password = PreferenceUtils.getPrefString(this,
				PreferenceConstants.PASSWORD, "");
		if (!TextUtils.isEmpty(password)) {
			mHandler.postDelayed(gotoMainAct, 3000);
		} else {
			mHandler.postDelayed(gotoLoginAct, 3000);
		}
	}

	// 检测网络
	public boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	Runnable gotoLoginAct = new Runnable() {

		@Override
		public void run() {
			Intent intent = new Intent();
			intent.setClass(SplashActivity.this, CardActivity.class);
			startActivity(intent);
			// 设置切换动画，从右边进入，左边退出,带动态效果
			overridePendingTransition(R.anim.new_dync_in_from_right,
					R.anim.new_dync_out_to_left);
			// startActivity(new Intent(SplashActivity.this,
			// CardActivity.class));
			finish();
		}
	};

	Runnable gotoMainAct = new Runnable() {

		@Override
		public void run() {
			startActivity(new Intent(SplashActivity.this, IndexActivity.class));
			finish();
		}
	};
}
