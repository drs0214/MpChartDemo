package com.drs.mpchart;

import java.util.LinkedHashMap;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.entity.PieChartEntity;
import com.github.mikephil.charting.helper.ChartHelper;
import com.github.mikephil.charting.helper.ToastHelper;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @author Dell-
 *饼形图例子
 */
public class PieChartDemo extends Activity {

	Context context;
	PieChart mPieChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_piechartdemo);
		context = this;

		mPieChart = (PieChart) findViewById(R.id.pie_chart);
		
		LinkedHashMap<String, Float> mData = new LinkedHashMap<>();
		mData.put("管理人员", 15f);
		mData.put("市场人员", 18f);
		mData.put("技术人员", 52f);
		mData.put("技工人员", 15f);
		PieChartEntity entity = new PieChartEntity("浪潮人员构成比", mData);
		
		new ChartHelper().setData(mPieChart, entity, new OnChartValueSelectedListener() {
			
			@Override
			public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
				ToastHelper.show(context, "value = " + e.getVal());
			}
			
			@Override
			public void onNothingSelected() {
				
			}
		});
	}

	
}
