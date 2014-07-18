package com.hiyaya0.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.hiyaya.R;

public class IndexActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index2);
		initView();
	}

	private void initView() {
		Typeface tf = Typeface.createFromAsset(IndexActivity.this.getAssets(),
				"fonts/qtfy.ttf");

		TextView btnStart = (TextView) this.findViewById(R.id.index_start);
		btnStart.setTypeface(tf);
		TextView btnWiki = (TextView) this.findViewById(R.id.index_txt_baike);
		btnWiki.setTypeface(tf);
		TextView btnInfo = (TextView) this.findViewById(R.id.index_txt_info);
		btnInfo.setTypeface(tf);
		TextView btnRank = (TextView) this.findViewById(R.id.index_txt_rank);
		btnRank.setTypeface(tf);
		btnRank.setOnClickListener(this);

		TextView btnCancel = (TextView) this
				.findViewById(R.id.index_txt_cancel);
		btnCancel.setTypeface(tf);
		btnCancel.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.index_txt_rank:
			IndexActivity.this.startActivity(new Intent(IndexActivity.this,
					RankActivity.class));
			break;
		case R.id.index_txt_cancel:
			finish();
			break;
		}
	}

}
