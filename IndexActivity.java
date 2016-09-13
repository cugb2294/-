package com.example.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.viewpagertest.R;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class IndexActivity extends Activity {
	GridView indexgv;
	int[] image={R.drawable.modul01,R.drawable.modul01,R.drawable.modul01,R.drawable.modul01,R.drawable.modul01,R.drawable.modul01,};
	String[] title1={"»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷"};
	String[] title2={"»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷"};
	String[] title3={"»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷","»¶Ó­Ê¹ÓÃMarkdown±à¼­Æ÷"};
	List<Map<String,Object>> indexlist=new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        indexgv=(GridView)findViewById(R.id.indexgv);
        for(int i=0;i<image.length;i++)
        {
        	Map<String,Object> map=new HashMap<String, Object>();
        	map.put("img",image[i]);
        	map.put("title1",title1[i]);
        	map.put("title2",title2[i]);
        	map.put("title3",title3[i]);
        	indexlist.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this, indexlist, R.layout.indexitems, new String[]{"img","title1","title2","title3"}, new int[]{R.id.image,R.id.title1,R.id.title2,R.id.title3});
      indexgv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

}
