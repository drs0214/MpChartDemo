package com.drs.mpchart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * @author Dell-
 *功能演示索引
 */
public class IndexActivity extends Activity implements OnClickListener {

	Context context;
	TextView tv1, tv2, tv3,tv4,tv5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		context = this;

		tv1 = (TextView) findViewById(R.id.textView1);
		tv1.setOnClickListener(this);

		tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setOnClickListener(this);

		tv3 = (TextView) findViewById(R.id.textView3);
		tv3.setOnClickListener(this);
		tv4 = (TextView) findViewById(R.id.textView4);
		tv4.setOnClickListener(this);
		tv5 = (TextView) findViewById(R.id.textView5);
		tv5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.textView1:
			startActivity(new Intent(context, LineChartDemo.class));
			break;
		case R.id.textView2:
			startActivity(new Intent(context, BarChartDemo.class));
			break;
		case R.id.textView3:
			startActivity(new Intent(context, PieChartDemo.class));
			break;
		case R.id.textView4:
			startActivity(new Intent(context, LineAndBarChartDemo.class));
			break;
		case R.id.textView5:
//			startActivity(new Intent(context, MyBarChart.class));
			startActivity(new Intent(context, StackBarChartDemo.class));
			break;
		}

	}
}
