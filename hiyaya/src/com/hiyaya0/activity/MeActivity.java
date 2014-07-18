package com.hiyaya0.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hiyaya.R;
import com.hiyaya.adapter.CardAdapter;
import com.hiyaya.bean.Card;

public class MeActivity extends Activity {
	private static final String TAG = "MeActivity";

	private ListView mListView;
	private CardAdapter mAdapter;

	List<Card> list = new ArrayList<Card>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me);

		// 测试数据
		String data = "[{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12},"
				+ "{i:001,t:'初一语文（上）',te:'孔小丘',ti:'1212121212121',img:'url',j:30,c:16},"
				+ "{i:002,t:'初一语文（下）',te:'孔小丘',ti:'1212121212121',img:'url',j:40,c:12}]";

		try {
			JSONArray array = new JSONArray(data);
			System.out.println(array.length() + "ssssssssssssssssss");

			for (int i = 0; i < array.length(); i++) {
				Card c = new Card();
				c.fromJSONObject((JSONObject) array.get(i));
				System.out.println(c.getTitle() + "aaaaaaaaaaaaaaaa");

				list.add(c);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mAdapter = new CardAdapter(this, list);
		mListView = (ListView) findViewById(R.id.me_lv_path);
		mListView.setDividerHeight(0);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

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
