package com.example.biz;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.viewpagertest.R;

public class MainActivity extends Activity implements OnPageChangeListener{
	// 单选按钮集
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	ViewPager viewpager;
	// 所有的布局或控件当做View对象的子类处理
	ArrayList<View> list;
	// 布局选择器
	LayoutInflater inflater;
	//适配器 将页面填充进入ViewPager中显示
	MyAdapter adapter;
	
	@SuppressWarnings("deprecation")
	//界面管理器
	LocalActivityManager manager;
	@SuppressLint("ResourceAsColor")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg=(RadioGroup)findViewById(R.id.rg);
		rb1=(RadioButton)findViewById(R.id.main_rb1);
		rb2=(RadioButton)findViewById(R.id.main_rb2);
		rb3=(RadioButton)findViewById(R.id.main_rb3);
		rb4=(RadioButton)findViewById(R.id.main_rb4);
		rb1.setTextColor(Color.BLACK);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		manager=new LocalActivityManager(this, true);
		// 重新存储Activity状态
		manager.dispatchCreate(savedInstanceState);
		// 填充页面集合
		setPage();
		adapter = new MyAdapter(getApplicationContext(), list);
		// 在ViewPager上使用适配器
		viewpager.setAdapter(adapter);
		viewpager.setCurrentItem(0);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				setCurrentColor(viewpager.getCurrentItem());
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
//				for(int i=0;i<arg0.getChildCount();i++){
//					if(arg0.getChildAt(i).getId()==arg1){
//						viewpager.setCurrentItem(i);
//						break;
//					}
//				}
				
				if(rb1.getId()==arg1){
					viewpager.setCurrentItem(0);
					
				}else if(rb2.getId()==arg1){
					viewpager.setCurrentItem(1);
					
				}else if(rb3.getId()==arg1){
					viewpager.setCurrentItem(2);
					
				}else{
					viewpager.setCurrentItem(3);
					
				}
				setCurrentColor(viewpager.getCurrentItem());
			}

		});
	
		
	}
	public void setCurrentColor(int index){
		if(index==0){
			rb1.setTextColor(Color.CYAN);
			rb2.setTextColor(Color.BLACK);
			rb3.setTextColor(Color.BLACK);
			rb4.setTextColor(Color.BLACK);
		}else if(index==1){
			rb2.setTextColor(Color.CYAN);
			rb1.setTextColor(Color.BLACK);
			rb3.setTextColor(Color.BLACK);
			rb4.setTextColor(Color.BLACK);
		}else if(index==2){
			rb3.setTextColor(Color.CYAN);
			rb2.setTextColor(Color.BLACK);
			rb1.setTextColor(Color.BLACK);
			rb4.setTextColor(Color.BLACK);
		}else{
			rb4.setTextColor(Color.CYAN);
			rb2.setTextColor(Color.BLACK);
			rb3.setTextColor(Color.BLACK);
			rb1.setTextColor(Color.BLACK);
		}
	}
	// 填充viewpager页面
	@SuppressWarnings("deprecation")
	private void setPage() {
		// TODO Auto-generated method stub
		list = new ArrayList<View>();
		// context上下文环境,
		// getApplicationContext获取应用（上下文）环境
		inflater = LayoutInflater.from(getApplicationContext());
		Intent in1=new Intent(MainActivity.this,IndexActivity.class);
		View view1 =manager.startActivity("first", in1).getDecorView();
		Intent in2=new Intent(MainActivity.this,PhysActivity.class);
		View view2 = manager.startActivity("second", in2).getDecorView();
		Intent in3=new Intent(MainActivity.this,SubscribActivity.class);
		View view3 = manager.startActivity("third", in3).getDecorView();
		Intent in4=new Intent(MainActivity.this,MineActivity.class);
		View view4 = manager.startActivity("third", in4).getDecorView();

		list.add(view1);
		list.add(view2);
		list.add(view3);
		list.add(view4);
	}

	@SuppressWarnings("deprecation")
	public View getView(String id, Intent intent) {
		// 将Activity转换为View对象
		return manager.startActivity(id, intent).getDecorView();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
	}
}
