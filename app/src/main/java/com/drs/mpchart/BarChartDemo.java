package com.drs.mpchart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.entity.BarChartEntity;
import com.github.mikephil.charting.helper.ChartHelper;
import com.github.mikephil.charting.helper.ToastHelper;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @author Dell-
 *柱形图例子
 */
@SuppressLint("NewApi")
public class BarChartDemo extends Activity {

	Context context;
	BarChart mBarChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_barchartdemo);
		context = this;

        mBarChart = (BarChart) findViewById(R.id.bar_chart);
        
        LinkedHashMap<String, Float> PM25数据集 = new LinkedHashMap<>();
        PM25数据集.put("长清党校", 247f);
        PM25数据集.put("济南化工厂", 298f);
        PM25数据集.put("省种子仓库", 253f);
        PM25数据集.put("农科所", 244f);
        PM25数据集.put("开发区", 166f);
        BarChartEntity PM25实体 = new BarChartEntity("PM2.5", PM25数据集);
        
        LinkedHashMap<String, Float> PM10数据集 = new LinkedHashMap<>();
        PM10数据集.put("长清党校", 335f);
        PM10数据集.put("济南化工厂", 453f);
        PM10数据集.put("省种子仓库", 310f);
        PM10数据集.put("农科所", 426f);
        PM10数据集.put("开发区", 226f);
        BarChartEntity PM10实体 = new BarChartEntity("PM10", PM10数据集);
        PM10实体.setmBarColor(0Xffc69ad4);
        
        LinkedHashMap<String, Float> PM20数据集 = new LinkedHashMap<>();
        PM20数据集.put("长清党校", 335f);
        PM20数据集.put("济南化工厂", 453f);
        PM20数据集.put("省种子仓库", 310f);
        PM20数据集.put("农科所", 426f);
        PM20数据集.put("开发区", 226f);
        BarChartEntity PM20实体 = new BarChartEntity("PM20", PM20数据集);
        PM20实体.setmBarColor(0Xff0000E3);
        
        List<BarChartEntity> entityList = new ArrayList<>();
        entityList.add(PM25实体);
        entityList.add(PM10实体);
        entityList.add(PM20实体);
        new ChartHelper().setData(mBarChart, entityList, new OnChartValueSelectedListener() {
			
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
