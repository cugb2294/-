package com.example.biz;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.viewpagertest.R;

public class ActTestActivity extends Activity {
	//��ѡ��ť������
	int weizhi=0;
	TextView warn;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_test);

		// �ж��û�ѡ��Ļ�±�
		 int position = getIntent().getIntExtra("position", 1);
		switch(position){
		case 1:
			warn=(TextView)findViewById(R.id.test_warn);
			rg=(RadioGroup)findViewById(R.id.test_rg);
			rb1=(RadioButton)findViewById(R.id.test_rb1);
			rb2=(RadioButton)findViewById(R.id.test_rb2);
			rb3=(RadioButton)findViewById(R.id.test_rb3);
			rb4=(RadioButton)findViewById(R.id.test_rb4);
			submit=(Button)findViewById(R.id.test_submit);
			rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					warn.setVisibility(View.INVISIBLE);
					if(rb1.getId()==arg1){
						weizhi=1;
						rb1.setChecked(true);
						rb2.setChecked(false);
						rb3.setChecked(false);
						rb4.setChecked(false);
					}else if(rb2.getId()==arg1){
						weizhi=2;
						rb1.setChecked(false);
						rb2.setChecked(true);
						rb3.setChecked(false);
						rb4.setChecked(false);
					}else if(rb3.getId()==arg1){
						weizhi=3;
						rb1.setChecked(false);
						rb2.setChecked(false);
						rb3.setChecked(true);
						rb4.setChecked(false);
					}else{
						weizhi=4;
						rb1.setChecked(false);
						rb2.setChecked(false);
						rb3.setChecked(false);
						rb4.setChecked(true);
					}
				}
			});
			submit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String judge = null;
					boolean enter=true;
					switch(weizhi){
					case 1:
						judge=" \n�Լ��ڴ���������ݸ����൱���ӣ��϶��Լ�������Զӵ�У�����ϣ���Է������Ψһ��\n\n-----רһ\n";
						enter=true;
						break;
					case 2:
						judge="\n�߸ߵ����ϣ�������ݸ����У���Ƚ��п�������ϣ���Է�Ǩ���㣬����Ϊ���ġ���Ҳ�Ƚ����š�\n\n------�۹��\n ";
						enter=true;
						break;
					case 3:
						judge=" \n�����ĺ������������£���ĸ�����Ʈ�������ģ�ԭ�������Դ���Լ�Ҳ�������ԶԷ�����֮���㻹û�а��ա�\n\n------����\n";
						enter=true;
						break;
					case 4:
						judge="\n·�ߵĻ�̳����㲢��ʮ��������ݸ��飬�����Ⲣ��������������Խ�����ʱʧȥ��Ҳ������������ \n\n------��Ե\n";
						enter=true;
						break;
					default:
						warn.setVisibility(View.VISIBLE);
						enter=false;
						break;
					}
					if(enter){
						new AlertDialog.Builder(ActTestActivity.this)
						.setMessage(judge)
						.setTitle("���Խ��")
						.setPositiveButton("ȷ��", null)
						.show();
					}
					
				}
			});
			
		case 2:
			
		case 3:
			
		case 4:
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_test, menu);
		return true;
	}

}
