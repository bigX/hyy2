package com.hiyaya.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Question {

	private String test = "{id:0001,q:'1加1等于几',a:'2',alist:[{k:'A',v:'1'},{k:'B',v:'2'},{k:'C',v:'3'},{k:'D',v:'4'}]}";

	private long id;
	private String question;
	private String answer;
	public List<AnswerItem> list = new ArrayList<AnswerItem>();

	public class AnswerItem {
		public String k;
		public String v;

		public AnswerItem(String k, String v) {
			this.k = k;
			this.v = v;
		}
	}

	public Question() {

	}

	public Question(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			this.setId(obj.getLong("id"));
			this.setQuestion(obj.getString("q"));
			this.setAnswer(obj.getString("a"));
			String list = obj.getString("alist");
			JSONArray answerArray = new JSONArray(list);
			for (int i = 0; i < answerArray.length(); i++) {
				this.list.add(new AnswerItem(answerArray.getJSONObject(i)
						.getString("k"), answerArray.getJSONObject(i)
						.getString("v")));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Question(long id, String question, String answer,
			List<AnswerItem> list) {
		this.setId(id);
		this.setQuestion(question);
		this.setAnswer(answer);
		this.list = list;
	}

	public void fromJSON(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			this.setId(obj.getLong("id"));
			this.setQuestion(obj.getString("q"));
			this.setAnswer(obj.getString("a"));
			String list = obj.getString("alist");
			JSONArray answerArray = new JSONArray(list);
			for (int i = 0; i < answerArray.length(); i++) {
				this.list.add(new AnswerItem(answerArray.getJSONObject(i)
						.getString("k"), answerArray.getJSONObject(i)
						.getString("v")));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toJSON() {

	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<AnswerItem> getList() {
		return list;
	}

	public void setList(List<AnswerItem> list) {
		this.list = list;
	}

}
