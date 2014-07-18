package com.hiyaya.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hiyaya.R;
import com.hiyaya.bean.Card;

public class CardAdapter extends BaseAdapter {

	// 数据源
	private List<Card> list;
	private Context context;

	// 构造函数
	public CardAdapter(Context context, List<Card> list) {
		this.context = context;
		this.list = list;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater mInflater = LayoutInflater.from(context);

		// 产生一个View
		View view = null;

		Card Card = (Card) this.getItem(position);
		view = mInflater.inflate(R.layout.me_path_item, null);

		// Button btnStatus = (Button)
		// view.findViewById(R.id.Card_btn_status);
		// Button btnAswer = (Button) view.findViewById(R.id.Card_btn_answer);

		return view;
	}

}
