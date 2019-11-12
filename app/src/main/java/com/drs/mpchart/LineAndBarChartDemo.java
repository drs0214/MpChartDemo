package com.drs.mpchart;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.entity.BarChartEntity;
import com.github.mikephil.charting.entity.CombinedChartEntity;
import com.github.mikephil.charting.entity.LineChartEntity;
import com.github.mikephil.charting.helper.ChartHelper;
import com.github.mikephil.charting.helper.ToastHelper;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;

/**
 * @author Dell- 柱状图和折线图混合
 */
public class LineAndBarChartDemo extends Activity {
	Context context = this;
	CombinedChart combinedchart;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lineandbar);
		combinedchart = (CombinedChart) findViewById(R.id.combined);
		LinkedHashMap<String, Float> 白天气温走势 = new LinkedHashMap<>();
		白天气温走势.put("周一", 18f);
		白天气温走势.put("周二", 28f);
		白天气温走势.put("周三", 28f);
		白天气温走势.put("周四", 24f);
		白天气温走势.put("周五", 26f);
		白天气温走势.put("周六", 25f);
		白天气温走势.put("周日", 66f);
		白天气温走势.put("周八", 26f);
		白天气温走势.put("周九", 56f);
		白天气温走势.put("周十", 96f);
		白天气温走势.put("周十一", 45f);
		白天气温走势.put("周十二",85f);
		白天气温走势.put("周十三",75f);
		
		LineChartEntity 气温实体 = new LineChartEntity("气温", 白天气温走势);
		ArrayList<LineChartEntity> 折线列表 = new ArrayList<>();
		折线列表.add(气温实体);
		
		LinkedHashMap<String, Float> PM25数据集 = new LinkedHashMap<>();
		PM25数据集.put("周一", 247f);
		PM25数据集.put("周二", 298f);
		PM25数据集.put("周三", 253f);
		PM25数据集.put("周四", 244f);
		PM25数据集.put("周五", 366f);
		PM25数据集.put("周六", 166f);
		PM25数据集.put("周日", 116f);
		PM25数据集.put("周八", 116f);
		PM25数据集.put("周九", 136f);
		PM25数据集.put("周十", 186f);
		PM25数据集.put("周十一", 86f);
		PM25数据集.put("周十二", 56f);
		PM25数据集.put("周十三", 86f);
		BarChartEntity PM实体 = new BarChartEntity("PM2.5", PM25数据集);
		ArrayList<BarChartEntity> 柱状图列表 = new ArrayList<>();
		柱状图列表.add(PM实体);
		
		
		
		ArrayList<CombinedChartEntity> 折线柱状合体列表 = new ArrayList<>();
		CombinedChartEntity 白天气温折线 = new CombinedChartEntity("白天气温", 白天气温走势,
				PM25数据集);
		折线柱状合体列表.add(白天气温折线);
		 new ChartHelper().setData(combinedchart, 折线柱状合体列表 , 折线列表,柱状图列表 ,new OnChartValueSelectedListener() {
				
				@Override
				public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
					ToastHelper.show(context, "dataSetIndex = " + dataSetIndex + "\n"
							+ "value = " + e.getVal());
				}
				
				@Override
				public void onNothingSelected() {
					
				}
			});
	}
}
