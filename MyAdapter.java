package com.example.biz;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends PagerAdapter {
	// overread重载
	ArrayList<View> list;

	// Constructor构造方法
	public MyAdapter(Context context, ArrayList<View> list) {
		this.list = list;
	}

	// 获取填充的View个数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	// 判断用于填充的View是否为Object对象
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	// 销毁视图
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView(list.get(position));
	}

	// 创建视图
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		((ViewPager) container).addView(list.get(position));

		return list.get(position);
	}

}
