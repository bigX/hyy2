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

public class RankActivity extends FragmentActivity {
	private Handler mHandler;
	private AccelerateLinearDecelerateProgressBar mAccelerateLinearDecelerateProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rank2);
		Typeface tf0 = Typeface.createFromAsset(RankActivity.this.getAssets(),
				"fonts/bb4044.ttf");

		Typeface tf = Typeface.createFromAsset(RankActivity.this.getAssets(),
				"fonts/qtfy.ttf");

		TextView title = (TextView) this.findViewById(R.id.rank_title);
		title.setTypeface(tf);

		Button btnCancel = (Button) this.findViewById(R.id.rank_btn_cancel);
		btnCancel.setTypeface(tf0);
		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
