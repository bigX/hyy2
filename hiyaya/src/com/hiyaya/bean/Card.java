package com.hiyaya.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Card {
	private long id;

	private String title;
	private String teacher;
	private String time;
	private String img;
	private int join;
	private int complete;

	public Card() {

	};

	// String json = "{i:001,t:'初一语文（上）'，te:'孔小丘'，img:'url',j:30,c:16}"
	public void fromJSONString(String json) {
		try {
			JSONObject o = new JSONObject(json);
			this.setId(o.getLong("i"));
			this.setTitle(o.getString("t"));
			this.setTeacher(o.getString("te"));
			this.setTime(o.getString("ti"));
			this.setImg(o.getString("img"));
			this.setJoin(o.getInt("j"));
			this.setComplete(o.getInt("c"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fromJSONObject(JSONObject o) {
		try {
			this.setId(o.getLong("i"));
			this.setTitle(o.getString("t"));
			this.setTeacher(o.getString("te"));
			this.setTime(o.getString("ti"));
			this.setImg(o.getString("img"));
			this.setJoin(o.getInt("j"));
			this.setComplete(o.getInt("c"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getJoin() {
		return join;
	}

	public void setJoin(int join) {
		this.join = join;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
