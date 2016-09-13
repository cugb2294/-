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
	//��¼ͷ��radiogroup�Ľ���
	int currentNo=0;
	// ��չ������Ϣ
	int[] img={R.drawable.tea1,R.drawable.tea2,R.drawable.tea3,R.drawable.tea4};
	String[] name={"��չʦ����������1","��չʦ����������2","��չʦ����������3","��չʦ����������4"};
	String[] age={"��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��"};
	String[] grade={"��չʦ���֣�9.5��","��չʦ���֣�8.5��","��չʦ���֣�8.5��","��չʦ���֣�9.5��"};
	String[] experience={"�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ"};
	String[] motto={"Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ"};
	
	// ɳ�̻�����Ϣ
	int[] img2={R.drawable.bo1,R.drawable.bo2,R.drawable.bo3,R.drawable.bo4};
	String[] name2={"shapan���������㲨1","shapan���������㲨2","shapan���������㲨3","shapan���������㲨4"};
	String[] age2={"��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��"};
	String[] grade2={"��չʦ���֣�9.5��","��չʦ���֣�8.5��","��չʦ���֣�8.5��","��չʦ���֣�9.5��"};
	String[] experience2={"�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ"};
	String[] motto2={"Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ"};
	// ������ѯ������Ϣ
	int[] img3={R.drawable.mo1,R.drawable.mo2,R.drawable.mo3,R.drawable.mo4};
	String[] name3={"������ѯʦ������ħ��1","������ѯʦ������ħ��2","������ѯʦ������ħ��3","������ѯʦ������ħ��4"};
	String[] age3={"��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��","��չʦ���䣺1.5��"};
	String[] grade3={"��չʦ���֣�9.5��","��չʦ���֣�8.5��","��չʦ���֣�8.5��","��չʦ���֣�9.5��"};
	String[] experience3={"�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ","�����Լ�������ʦ"};
	String[] motto3={"Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ","Ǳ�ĳ�ħ"};
	// ��¼��ʦ��Ϣ
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
		// �������ݵ����϶�����
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
		// ����Я����ͬ���ݵ�������
		final SimpleAdapter adapter=new SimpleAdapter(this, content, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		final SimpleAdapter adapter2=new SimpleAdapter(this, content2, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		final SimpleAdapter adapter3=new SimpleAdapter(this, content3, R.layout.subsitems, new String[]{"img","name","age","grade"}, new int[]{R.id.subsimg,R.id.subsname,R.id.subsage,R.id.subsgrade});
		// ����ͷ�� ����radiogroup�Ľ���ı��¼�
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
		// Ĭ�Ͽ�ʼʱ��ʾ��չ��ʦ��Ϣ
		teachers.setAdapter(adapter);
		// ����listView��item����¼�
		teachers.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent in = new Intent(SubscribActivity.this,SubscribItemActivity.class);
				ArrayList<String> list=new ArrayList<String>();
				// ���ݵ������Ŵ��ݲ�ͬ������
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
