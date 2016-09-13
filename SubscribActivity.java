package com.example.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleAdapter;

import com.example.viewpagertest.R;

public class SubscribActivity extends Activity {
	RadioGroup rg;
	RadioButton rb1,rb2,rb3;
	ListView teachers;
	//记录头部radiogroup的焦点
	int currentNo=0;
	// 拓展基本信息
	int[] img={R.drawable.tea1,R.drawable.tea2,R.drawable.tea3,R.drawable.tea4};
	String[] name={"拓展师姓名：赵霁1","拓展师姓名：赵霁2","拓展师姓名：赵霁3","拓展师姓名：赵霁4"};
	String[] age={"拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年"};
	String[] grade={"拓展师评分：9.5分","拓展师评分：8.5分","拓展师评分：8.5分","拓展师评分：9.5分"};
	String[] experience={"国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师"};
	String[] motto={"潜心成魔","潜心成魔","潜心成魔","潜心成魔"};
	
	// 沙盘基本信息
	int[] img2={R.drawable.bo1,R.drawable.bo2,R.drawable.bo3,R.drawable.bo4};
	String[] name2={"shapan姓名：吴秀波1","shapan姓名：吴秀波2","shapan姓名：吴秀波3","shapan姓名：吴秀波4"};
	String[] age2={"拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年"};
	String[] grade2={"拓展师评分：9.5分","拓展师评分：8.5分","拓展师评分：8.5分","拓展师评分：9.5分"};
	String[] experience2={"国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师"};
	String[] motto2={"潜心成魔","潜心成魔","潜心成魔","潜心成魔"};
	// 心理咨询基本信息
	int[] img3={R.drawable.mo1,R.drawable.mo2,R.drawable.mo3,R.drawable.mo4};
	String[] name3={"心理咨询师姓名：魔尊1","心理咨询师姓名：魔尊2","心理咨询师姓名：魔尊3","心理咨询师姓名：魔尊4"};
	String[] age3={"拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年","拓展师教龄：1.5年"};
	String[] grade3={"拓展师评分：9.5分","拓展师评分：8.5分","拓展师评分：8.5分","拓展师评分：9.5分"};
	String[] experience3={"国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师","国家以及心理辅导师"};
	String[] motto3={"潜心成魔","潜心成魔","潜心成魔","潜心成魔"};
	// 记录教师信息
	List<Map<String,Object>> content=new ArrayList<Map<String,Object>>();
	List<Map<String,Object>> content2=new ArrayList<Map<String,Object>>();
	List<Map<String,Object>> content3=new ArrayList<Map<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		teachers=(ListView)findViewById(R.id.subslv);
		rg=(RadioGroup)findViewById(R.id.physrg);
		rb1=(RadioButton)findViewById(R.id.sub_rb1);
		rb2=(RadioButton)findViewById(R.id.sub_rb2);
		rb3=(RadioButton)findViewById(R.id.sub_rb3);
		rb1.setBackgroundColor(Color.CYAN);
		// 加载数据到集合对象中
		for(int i=0;i<img.length;i++){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("img",img[i]);
			map.put("name", name[i]);
			map.put("age", age[i]);
			map.put("grade", grade[i]);
			content.add(map);
			Map<String,Object> map2=new HashMap<String, Object>();
			map2.put("img",img2[i]);
			map2.put("name", name2[i]);
			map2.put("age", age2[i]);
			map2.put("grade", grade2[i]);
			content2.add(map2);
			Map<String,Object> map3=new HashMap<String, Object>();
			map3.put("img",img3[i]);
			map3.put("name", name3[i]);
			map3.put("age", age3[i]);
			map3.put("grade", grade3[i]);
			content3.add(map3);
		}
		// 创建携带不同数据的适配器
		final SimpleAdapter adapter=new SimpleAdapter(this, content, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		final SimpleAdapter adapter2=new SimpleAdapter(this, content2, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		final SimpleAdapter adapter3=new SimpleAdapter(this, content3, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		// 设置头部 分类radiogroup的焦点改变事件
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
//				for(int i=0;i<3;i++){
//					if(arg0.getChildAt(i).getId()==arg1){
//						currentNo=i;
//						switch(i){
//						case 0:
//							teachers.setAdapter(adapter);
//							
//							break;
//						case 1:
//							teachers.setAdapter(adapter2);
//							break;
//						case 2:
//							teachers.setAdapter(adapter3);
//							break;
//						}
//					}
//				}
				if(rb1.getId()==arg1){
					currentNo=0;
					teachers.setAdapter(adapter);
					rb1.setBackgroundColor(Color.CYAN);
					rb2.setBackgroundColor(Color.WHITE);
					rb3.setBackgroundColor(Color.WHITE);
					
				}else if(rb2.getId()==arg1){
					currentNo=1;
					teachers.setAdapter(adapter2);
					rb2.setBackgroundColor(Color.CYAN);
					rb1.setBackgroundColor(Color.WHITE);
					rb3.setBackgroundColor(Color.WHITE);
				}else{
					currentNo=2;
					teachers.setAdapter(adapter3);
					rb3.setBackgroundColor(Color.CYAN);
					rb2.setBackgroundColor(Color.WHITE);
					rb1.setBackgroundColor(Color.WHITE);
				}
			}
		});
		// 默认开始时显示拓展老师信息
		teachers.setAdapter(adapter);
		// 设置listView的item点击事件
		teachers.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent in = new Intent(SubscribActivity.this,SubscribItemActivity.class);
				ArrayList<String> list=new ArrayList<String>();
				// 根据点击的序号传递不同的数据
				switch (currentNo){
				case 0:
					list.add(img[arg2]+"");
					list.add(name[arg2]);
					list.add(age[arg2]);
					list.add(grade[arg2]);
					list.add(experience[arg2]);
					list.add(motto[arg2]);
					break;
				case 1:
					list.add(img2[arg2]+"");
					list.add(name2[arg2]);
					list.add(age2[arg2]);
					list.add(grade2[arg2]);
					list.add(experience2[arg2]);
					list.add(motto2[arg2]);
					break;
				case 2:
					list.add(img3[arg2]+"");
					list.add(name3[arg2]);
					list.add(age3[arg2]);
					list.add(grade3[arg2]);
					list.add(experience3[arg2]);
					list.add(motto3[arg2]);
					break;
				}
				
				in.putStringArrayListExtra("info", list);
				startActivity(in);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
