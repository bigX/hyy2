package com.hiyaya0.activity;

import com.example.hiyaya.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		Typeface fontFace = Typeface.createFromAsset(getAssets(),
				"fonts/aaa.ttf");
		// 字体文件必须是true type font的格式(ttf)；
		// 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为
		// 这个字体android没有支持,而非你的程序发生了错误

		TextView text = (TextView) findViewById(R.id.textView2);
		text.setText("你好");
		text.setTypeface(fontFace);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
