package com.hiyaya0.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import cn.smilecity.utl.AlertUtl;

import com.example.hiyaya.R;
import com.hiyaya.adapter.AnswerAdapter;
import com.hiyaya.bean.Question;
import com.hiyaya.bean.Question.AnswerItem;

@SuppressLint("NewApi")
public class Card2Activity extends Activity {
	private static final String TAG = "CardActivity";
	private SeekBar sb = null;
	private int seekBarProgress = 100;

	private TextView txtQuestion = null;
	private ListView lvAnswers = null;

	private RelativeLayout wrap = null;

	private Question question = null;

	AnswerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card);
		initData();
		this.initView();
		// handler.postDelayed(runnable, 1000);
	}

	Handler handler = new Handler();
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			if (seekBarProgress > 0) {
				seekBarProgress--;
				sb.setProgress(seekBarProgress);
				handler.postDelayed(this, 1000);
			} else {
				Log.d(TAG, "时间到");

			}
		}
	};

	private void initData() {
		String test = "{id:0001,q:'2加2等于几',a:'D',alist:[{k:'A',v:'1'},{k:'B',v:'2巴拉巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉巴拉吧'},{k:'C',v:'3'},{k:'D',v:'4'}]}";

		question = new Question(test);
	}

	private void initView() {
		wrap = (RelativeLayout) this.findViewById(R.id.card_wrap);

		sb = (SeekBar) this.findViewById(R.id.card_sb_time);
		sb.setHovered(true);
		sb.setProgress(seekBarProgress);

		lvAnswers = (ListView) this.findViewById(R.id.card_lv_answers);
		lvAnswers.setDividerHeight(0);
		lvAnswers.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				ImageView img = (ImageView) view
						.findViewById(R.id.card_item_img_chose);
				img.setImageResource(R.drawable.chose_bg_on);
				AnswerItem item = (AnswerItem) view.getTag();
				if (item.k.equals(question.getAnswer())) {
					AlertUtl.alert(Card2Activity.this, "答对了！" + item.k
							+ question.getAnswer());
				} else {
					AlertUtl.alert(Card2Activity.this, "答错了！" + item.k
							+ question.getAnswer());
					LayoutInflater mInflater = LayoutInflater
							.from(Card2Activity.this);
					View resultWindow = mInflater.inflate(R.layout.pop_result,
							null);
					Animation inAnimation = AnimationUtils.loadAnimation(
							Card2Activity.this, R.anim.push_left_in);

					wrap.addView(resultWindow);

					resultWindow.startAnimation(inAnimation);

					Button btnNext = (Button) resultWindow
							.findViewById(R.id.result_btn_next);
					btnNext.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							Animation btnAnimation = AnimationUtils
									.loadAnimation(Card2Activity.this,
											R.anim.btn_changge);
							btnAnimation
									.setAnimationListener(new Animation.AnimationListener() {

										@Override
										public void onAnimationStart(
												Animation animation) {

										}

										@Override
										public void onAnimationRepeat(
												Animation animation) {

										}

										@Override
										public void onAnimationEnd(
												Animation animation) {
											Intent intent = new Intent();
											intent.setClass(Card2Activity.this,
													Card2Activity.class);
											startActivity(intent);								
											overridePendingTransition(
													R.anim.new_dync_in_from_right,
													R.anim.no_aim);
											finish();
													
										}
									});

							arg0.startAnimation(btnAnimation);
						}
					});

				}

			}
		});
		adapter = new AnswerAdapter(this, question.list);
		lvAnswers.setAdapter(adapter);

	}

	private void comeIn(String status) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
