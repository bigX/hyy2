package com.hiyaya.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hiyaya.R;
import com.hiyaya.bean.Question;

public class AnswerAdapter extends BaseAdapter {

	// 数据源
	private List<Question.AnswerItem> list;
	private Context context;

	// 构造函数
	public AnswerAdapter(Context context, List<Question.AnswerItem> list) {
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

		Question.AnswerItem as = (Question.AnswerItem) this.getItem(position);

		view = mInflater.inflate(R.layout.card_item, null);
		view.setTag(as);
		
		ImageView img = (ImageView) view.findViewById(R.id.card_item_img_chose) ;
		
		TextView txt = (TextView) view
				.findViewById(R.id.card_item_btn);
		txt.setText(as.k + ".  " + as.v);
		
		
//		RadioButton rbAnswer = (RadioButton) view
//				.findViewById(R.id.card_item_btn);
//		rbAnswer.setText(as.k + ".  " + as.v);

		return view;
	}

}
