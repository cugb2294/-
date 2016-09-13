package com.example.biz;

import java.util.ArrayList;

import com.example.viewpagertest.R;
import com.example.viewpagertest.R.id;
import com.example.viewpagertest.R.layout;
import com.example.viewpagertest.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class SubscribItemActivity extends Activity {
	TextView name,age,grade,experience,motto;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subscrib_item);
		name=(TextView)findViewById(R.id.subtvname);
		age=(TextView)findViewById(R.id.subtvage);
		grade=(TextView)findViewById(R.id.subtvgrade);
		experience=(TextView)findViewById(R.id.subtvexperience);
		motto=(TextView)findViewById(R.id.subtvmotto);
		img=(ImageView)findViewById(R.id.teaimg);
		ArrayList<String>  list=getIntent().getStringArrayListExtra("info");
		img.setBackgroundResource(Integer.parseInt(list.get(0)));
		name.setText(list.get(1));
		age.setText(list.get(2));
		grade.setText(list.get(3));
		experience.setText("心里拓展经验:"+list.get(4));
		motto.setText("个人宣言:"+list.get(5));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.subscrib_item, menu);
		return true;
	}
}
