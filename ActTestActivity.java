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
	//单选按钮的索引
	int weizhi=0;
	TextView warn;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_test);

		// 判断用户选择的活动下标
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
						judge=" \n自己口袋里－－你对这份感情相当重视，认定自己可以永远拥有，并且希望对方是你的唯一。\n\n-----专一\n";
						enter=true;
						break;
					case 2:
						judge="\n高高的树上－－在这份感情中，你比较有控制欲，希望对方迁就你，以你为中心。你也比较自信。\n\n------眼光高\n ";
						enter=true;
						break;
					case 3:
						judge=" \n流动的河里－－这种情况下，你的感情是飘忽不定的，原因可能来源于自己也或者来自对方，总之，你还没有把握。\n\n------花心\n";
						enter=true;
						break;
					case 4:
						judge="\n路边的花坛里－－你并不十分在意这份感情，至少这并不是你的最爱，你可以接受随时失去，也可以逐渐遗忘。 \n\n------随缘\n";
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
						.setTitle("测试结果")
						.setPositiveButton("确定", null)
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
