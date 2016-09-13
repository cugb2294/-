package com.example.biz;

import com.example.viewpagertest.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_four);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.four, menu);
		return true;
	}

}
