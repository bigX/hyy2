package com.hiyaya0.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hiyaya.R;
import com.hiyaya.utl.AccelerateLinearDecelerateProgressBar;

public class SplashActivity extends FragmentActivity {
	private Handler mHandler;
	private AccelerateLinearDecelerateProgressBar mAccelerateLinearDecelerateProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash2);
		Typeface tf0 = Typeface.createFromAsset(
				SplashActivity.this.getAssets(), "fonts/bb4044.ttf");

		Typeface tf1 = Typeface.createFromAsset(
				SplashActivity.this.getAssets(), "fonts/trm.ttf");

		TextView title = (TextView) this.findViewById(R.id.tzxzs);
		title.setTypeface(tf1);
		TextView content = (TextView) this.findViewById(R.id.blbl);
		content.setTypeface(tf1);
		Button btnStart = (Button) this.findViewById(R.id.splash_btn_start);

		btnStart.setTypeface(tf0);
		btnStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SplashActivity.this.startActivity(new Intent(
						SplashActivity.this, IndexActivity.class));
				finish() ;
			}
		});
	}
}
