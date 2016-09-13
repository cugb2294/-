package com.example.biz;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends PagerAdapter {
	// overread����
	ArrayList<View> list;

	// Constructor���췽��
	public MyAdapter(Context context, ArrayList<View> list) {
		this.list = list;
	}

	// ��ȡ����View����
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	// �ж���������View�Ƿ�ΪObject����
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	// ������ͼ
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView(list.get(position));
	}

	// ������ͼ
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		((ViewPager) container).addView(list.get(position));

		return list.get(position);
	}

}
