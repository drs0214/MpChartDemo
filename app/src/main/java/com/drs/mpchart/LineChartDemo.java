package com.drs.mpchart;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.entity.LineChartEntity;
import com.github.mikephil.charting.helper.ChartHelper;
import com.github.mikephil.charting.helper.ToastHelper;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @author Dell-
 *折线图例子
 */
public class LineChartDemo extends Activity {

	Context context;
	LineChart mLineChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linechartdemo);
		context = this;
		mLineChart = (LineChart) findViewById(R.id.line_chart);
		LinkedHashMap<String, Float> 白天气温走势 = new LinkedHashMap<>();
		白天气温走势.put("周一", 18f);
		白天气温走势.put("周二", 28f);
		白天气温走势.put("周三", 28f);
		白天气温走势.put("周四", 24f);
		白天气温走势.put("周五", 26f);
		白天气温走势.put("周六", 25f);
		白天气温走势.put("周日", 26f);
		
		LinkedHashMap<String, Float> 夜间气温走势 = new LinkedHashMap<>();
		夜间气温走势.put("周一", 13f);
		夜间气温走势.put("周二", 17f);
		夜间气温走势.put("周三", 18f);
		夜间气温走势.put("周四", 15f);
		夜间气温走势.put("周五", 14f);
		夜间气温走势.put("周六", 16f);
		夜间气温走势.put("周日", 15f);
		
		ArrayList<LineChartEntity> 折线列表 = new ArrayList<>();
		LineChartEntity 白天气温折线 = new LineChartEntity("白天气温", 白天气温走势);
		LineChartEntity 夜间气温折线 = new LineChartEntity("夜间气温", 夜间气温走势);
		夜间气温折线.setmLineColor(0Xff6a6d90);
		折线列表.add(白天气温折线);
		折线列表.add(夜间气温折线);
		new ChartHelper().setData(mLineChart, 折线列表, new OnChartValueSelectedListener() {
			
			@Override
			public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
				ToastHelper.show(context, "dataSetIndex = " + dataSetIndex + "\n"
						+ "value = " + e.getVal());
			}
			
			@Override
			public void onNothingSelected() {
				
			}
		});
		
//		mLineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//		mLineChart.getXAxis().setPosition(XAxisPosition.BOTTOM); // 让x轴在下面
		mLineChart.getXAxis().setDrawGridLines(false);
		mLineChart.setDescription("星期");// 数据描述
	}

	
}
