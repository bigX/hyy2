package com.hiyaya.activity;

import com.example.hiyaya.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class IndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		initView();
	}

	private void initView() {
		Button btnRandom = (Button) this.findViewById(R.id.random);
		btnRandom.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation btnAnimation = AnimationUtils.loadAnimation(
						IndexActivity.this, R.anim.btn_changge);
				btnAnimation
						.setAnimationListener(new Animation.AnimationListener() {

							@Override
							public void onAnimationStart(Animation animation) {

							}

							@Override
							public void onAnimationRepeat(Animation animation) {

							}

							@Override
							public void onAnimationEnd(Animation animation) {
								Intent intent = new Intent();
								intent.setClass(IndexActivity.this,
										Card2Activity.class);
								startActivity(intent);
								overridePendingTransition(
										R.anim.new_dync_in_from_right,
										R.anim.no_aim);

							}
						});

				arg0.startAnimation(btnAnimation);
			}
		});
		
		
		View btnMe = this.findViewById(R.id.index_rl_user);
		btnMe.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation btnAnimation = AnimationUtils.loadAnimation(
						IndexActivity.this, R.anim.btn_changge);
				btnAnimation
						.setAnimationListener(new Animation.AnimationListener() {

							@Override
							public void onAnimationStart(Animation animation) {

							}

							@Override
							public void onAnimationRepeat(Animation animation) {

							}

							@Override
							public void onAnimationEnd(Animation animation) {
								Intent intent = new Intent();
								intent.setClass(IndexActivity.this,
										MeActivity.class);
								startActivity(intent);
								overridePendingTransition(
										R.anim.grow_from_topleft_to_bottomright,
										R.anim.no_aim);

							}
						});

				arg0.startAnimation(btnAnimation);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
