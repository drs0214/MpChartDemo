package com.drs.mpchart;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

public class MyBarChart extends Activity implements OnChartValueSelectedListener {
	Context context;
	BarChart mBarChart;
	 public static final int[] VORDIPLOM_COLORS = {
	            Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140)
	    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_barchartdemo);
		mBarChart = (BarChart) findViewById(R.id.bar_chart);

		XAxis xAxis = mBarChart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);// 设置X轴的位置
		// xAxis.setTypeface(mTf);//设置字体
		xAxis.setDrawGridLines(false);
		xAxis.setDrawAxisLine(true);
		xAxis.setSpaceBetweenLabels(0);
		// 设置右侧坐标轴
		YAxis rightAxis = mBarChart.getAxisRight();
		rightAxis.setDrawAxisLine(false);// 右侧坐标轴线
		rightAxis.setDrawLabels(false);// 右侧坐标轴数组Lable
//		mBarChart.setDrawValueAboveBar(false);
		setData();
	}

	// 初始化
	private void setData() {
		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
		ArrayList<BarDataSet> bardatasetlist = new ArrayList<BarDataSet>();
		for (int i = 0; i < 8; i++) {
			float mult = (50 + 1);
			float val1 = (float) (Math.random() * mult) + mult / 3;
			float val2 = (float) (Math.random() * mult) + mult / 3;
			float val3 = (float) (Math.random() * mult) + mult / 3;
			yVals1.add(new BarEntry(new float[] { val1, val2, val3 }, i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, "测试");
		// set1 = new BarDataSet(yVals1, "三年级一班期末考试");
//		set1.setColors(getColors());
		set1.setStackLabels(new String[] { "及格", "优秀", "不及格" });
		bardatasetlist.add(set1);
		BarData mBarData = new BarData(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }, bardatasetlist);
		
		set1.setColors(new int[] {getResources().getColor(R.color.qian_white),getResources().getColor(R.color.white),getResources().getColor(R.color.red)});
//		set1.setColors(new int[] {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140)});
		mBarChart.setData(mBarData);
		mBarChart.animateY(1000);// 设置动画
		mBarChart.invalidate();
	}

	@Override
	public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

	}

	@Override
	public void onNothingSelected() {

	}

	private int[] getColors() {

		int stacksize = 3;

		// have as many colors as stack-values per entry
		int[] colors = new int[stacksize];

		for (int i = 0; i < stacksize; i++) {
			colors[i] = ColorTemplate.VORDIPLOM_COLORS[i];
		}

		return colors;
	}

}