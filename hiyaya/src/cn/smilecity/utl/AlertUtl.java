package cn.smilecity.utl;

import android.content.Context;
import android.widget.Toast;

public class AlertUtl {

	public static void alert(Context c, String p) {
		System.out.println(p);
		Toast.makeText(c, p, Toast.LENGTH_SHORT).show();
	}
}
