package com.drs.mpchart;

import java.util.ArrayList;
import java.util.List;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.helper.ToastHelper;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

/**
 * @author Dell- 折线图例子
 */
public class StackBarChartDemo extends Activity implements OnChartValueSelectedListener {

	Context context;
	BarChart mBarChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_barchartdemo);
		context = this;

		mBarChart = (BarChart) findViewById(R.id.bar_chart);
		// mBarChart.setOnChartValueSelectedListener(new
		// ChartValueSelectedListenerImpl());
		mBarChart.setOnChartValueSelectedListener(this);
		List<String> valueDescList = new ArrayList<String>();
		valueDescList.add("05-15");
		valueDescList.add("05-16");
		valueDescList.add("05-17");
		valueDescList.add("05-18");
		valueDescList.add("05-19");
		valueDescList.add("05-20");
		valueDescList.add("05-21");
		List<float[]> valueList = new ArrayList<float[]>();
		valueList.add(new float[] { 1000f, 2000f, 3500f });
		valueList.add(new float[] { 800f, 1500f, 3000f });
		valueList.add(new float[] { 1200f, 700f, 600f });
		valueList.add(new float[] { 500f, 1400f, 1700f });
		valueList.add(new float[] { 700f, 2100f, 4000f });
		valueList.add(new float[] { 900f, 1300f, 3300f });
		valueList.add(new float[] { 1400f, 1600f, 2900f });
		List<Integer> colorList = new ArrayList<Integer>();
		colorList.add(Color.rgb(57, 135, 200));// 蓝色
		colorList.add(Color.rgb(205, 205, 205));// 灰色
		colorList.add(Color.rgb(100, 188, 123));//
		List<String> labelList = new ArrayList<String>();
		labelList.add("电视");
		labelList.add("宽带+电视");
		labelList.add("宽带");
		BarData mPieData = getBarData(valueDescList, valueList, colorList, labelList);

		showChart(mBarChart, mPieData);
	}

	private void showChart(BarChart barchart, BarData pieData) {
		barchart.setNoDataText("暂无数据");
		barchart.setTouchEnabled(true);
		barchart.setDescription(null);
		barchart.setData(pieData);
		barchart.setMaxVisibleValueCount(40);
		barchart.setPinchZoom(false);
		barchart.setDrawGridBackground(false);
		barchart.setDrawBarShadow(false);
		barchart.setDrawValueAboveBar(false);
		barchart.setHighlightEnabled(false);
		YAxis leftAxis = barchart.getAxisLeft();
		leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)
		leftAxis.setDrawAxisLine(false);
		barchart.getAxisRight().setEnabled(false);
		XAxis xLabels = barchart.getXAxis();
		xLabels.setPosition(XAxisPosition.BOTTOM);
		xLabels.setSpaceBetweenLabels(0);
		Legend mLegend = barchart.getLegend(); // 设置比例图
		mLegend.setEnabled(true);// 设置隐藏
		mLegend.setTextSize(14f);
		mLegend.setTextColor(Color.rgb(102, 102, 102));
		mLegend.setPosition(LegendPosition.BELOW_CHART_LEFT); // 最右边显示
		mLegend.setXEntrySpace(7f);
		mLegend.setYEntrySpace(5f);
		barchart.animateXY(2000, 1500); // 设置动画

	}

	private BarData getBarData(List<String> valueDescList, List<float[]> valueList, List<Integer> colorList,
			List<String> labelList) {
		try {
			ArrayList<String> xNames = new ArrayList<String>();
			ArrayList<BarEntry> yValues = new ArrayList<BarEntry>(); // yVals用来表示封装每个饼块的实际数据
			ArrayList<Integer> colors = new ArrayList<Integer>();
			String[] labels = new String[labelList.size()];
			if (labelList != null && labelList.size() > 0) {
				for (int i = 0; i < labelList.size(); i++) {
					labels[i] = labelList.get(i);
				}
			}
			if (valueDescList != null && valueDescList.size() > 0) {
				for (int i = 0; i < valueDescList.size(); i++) {
					xNames.add(valueDescList.get(i));
				}
			}
			if (colorList != null && colorList.size() > 0) {
				for (int color : colorList) {
					colors.add(color);
				}
			}
			if (valueList != null && valueList.size() > 0) {
				for (int i = 0; i < valueList.size(); i++) {
					BarEntry barEntry = new BarEntry(valueList.get(i), i);
					yValues.add(barEntry);
				}
			}
			ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
			BarDataSet dataSet = new BarDataSet(yValues, "");
			dataSet.setBarSpacePercent(10f);
			dataSet.setColors(colors);
			dataSet.setStackLabels(labels);
			dataSets.add(dataSet);
			BarData barData = new BarData(xNames, dataSets);
			barData.setValueTextColor(Color.BLACK);
			return barData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
		ToastHelper.show(context, "测试");
	}

	@Override
	public void onNothingSelected() {
		ToastHelper.show(context, "测试");
	}
}
