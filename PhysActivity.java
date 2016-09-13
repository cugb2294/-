package com.example.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.viewpagertest.R;

public class PhysActivity extends Activity {

	GridView gridview;
	int img[]={R.drawable.act_item1,R.drawable.act_item1,R.drawable.act_item1,R.drawable.act_item1};
	String[] title={"测一测你的感情之路","[2016-07-30 21:16:27 - Wuhuan_02]","[2016-07-30 21:16:27 - Wuhuan_02]","[2016-07-30 21:16:27 - Wuhuan_02]"};
	List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gridview=(GridView)findViewById(R.id.gridview);
        for(int i=0;i<title.length;i++)
        {
        	Map<String,Object> map=new HashMap<String, Object>();
        	map.put("image",img[i]);
        	map.put("title",title[i]);
        	listItems.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this, listItems, R.layout.gvitems, new String[]{"image","title"}, new int[]{R.id.img,R.id.title});
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

						Intent in=new Intent(PhysActivity.this,ActTestActivity.class);
						in.putExtra("position", arg2+1);
//						Log.i("arg2", arg2+"");
						startActivity(in);
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
