package com.github.mikephil.charting.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.entity.BarChartEntity;
import com.github.mikephil.charting.entity.CombinedChartEntity;
import com.github.mikephil.charting.entity.LineChartEntity;
import com.github.mikephil.charting.entity.PieCharSettings;
import com.github.mikephil.charting.entity.PieChartEntity;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import android.graphics.Color;

/**
 * @author Dell- 报表帮助类
 */
public class ChartHelper {

	/**
	 * 设置报表数据
	 * 
	 * @param lineChart
	 *            折线图
	 * @param entityList
	 *            折线实体类列表，如果要在同一个折线报表上显示多条折线，则所有的折线应该具有相同的格式
	 * @param lis
	 *            报表选择监听器
	 */
	public void setData(LineChart lineChart, List<LineChartEntity> entityList,
			OnChartValueSelectedListener lis) {
		setLineChartAppearance(lineChart);
		lineChart.setOnChartValueSelectedListener(lis);

		ArrayList<String> commonkeys = new ArrayList<String>();
		ArrayList<LineDataSet> mLineDataSetList = new ArrayList<LineDataSet>();
		for (LineChartEntity entity : entityList) {
			LinkedHashMap<String, Float> mData = entity.getmData();
			ArrayList<Float> values = new ArrayList<Float>();
			ArrayList<String> keys = new ArrayList<String>();

			Iterator<?> iter = mData.entrySet().iterator();
			while (iter.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry entry = (Map.Entry) iter.next();
				keys.add((String) entry.getKey());
				values.add((Float) entry.getValue());
			}
			commonkeys = keys;

			ArrayList<Entry> entryList = new ArrayList<Entry>();
			for (int i = 0; i < mData.size(); i++) {
				// Entry(yValue,xIndex);一个Entry表示一个点，第一个参数为y值，第二个为X轴List的角标
				entryList.add(new Entry(values.get(i), i));
			}

			LineDataSet dataSet = new LineDataSet(entryList,
					entity.getLineName());
			dataSet.setLineWidth(entity.getmLineWidth());
			dataSet.setColor(entity.getmLineColor());
			dataSet.setCircleSize(entity.getmLineCircleSize());
			dataSet.setCircleColor(entity.getmLineColor());
			dataSet.setHighLightColor(entity.getmHighLightColor());// 设置点击某个点时，横竖两条线的颜色
			dataSet.setDrawValues(true);// 是否在点上绘制Value

			mLineDataSetList.add(dataSet);

		}// end for

		// LineData表示一个LineChart的所有数据(即一个LineChart中所有折线的数据)
		LineData mChartData = new LineData(commonkeys, mLineDataSetList);

		// set data
		lineChart.setData((LineData) mChartData);
		lineChart.animateX(1000);// 设置动画
	}

	/**
	 * 设置报表数据
	 * 
	 * @param lineChart
	 *            折线图
	 * @param entity
	 *            折线实体类
	 * @param lis
	 *            报表选择监听器
	 */
	public void setData(LineChart lineChart, LineChartEntity entity,
			OnChartValueSelectedListener lis) {
		setLineChartAppearance(lineChart);
		lineChart.setOnChartValueSelectedListener(lis);

		LinkedHashMap<String, Float> mData = entity.getmData();
		ArrayList<Float> values = new ArrayList<Float>();
		ArrayList<String> keys = new ArrayList<String>();

		Iterator<?> iter = mData.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			keys.add((String) entry.getKey());
			values.add((Float) entry.getValue());
		}

		ArrayList<Entry> entryList = new ArrayList<Entry>();
		for (int i = 0; i < mData.size(); i++) {
			// Entry(yValue,xIndex);一个Entry表示一个点，第一个参数为y值，第二个为X轴List的角标
			entryList.add(new Entry(values.get(i), i));
		}

		LineDataSet dataSet = new LineDataSet(entryList, entity.getLineName());
		dataSet.setLineWidth(entity.getmLineWidth());
		dataSet.setColor(entity.getmLineColor());
		dataSet.setCircleSize(entity.getmLineCircleSize());
		dataSet.setCircleColor(entity.getmLineColor());
		dataSet.setHighLightColor(entity.getmHighLightColor());// 设置点击某个点时，横竖两条线的颜色
		dataSet.setDrawValues(true);// 是否在点上绘制Value

		// LineData表示一个LineChart的所有数据(即一个LineChart中所有折线的数据)
		LineData mChartData = new LineData(keys, dataSet);

		// set data
		lineChart.setData((LineData) mChartData);
		lineChart.animateX(1000);// 设置动画
	}

	/**
	 * 设置报表数据
	 * 
	 * @param barChart
	 *            柱形图
	 * @param entityList
	 *            柱形数据集合，，如果要在同一个柱形报表上显示多柱形，则所有的柱形应该具有相同的格式
	 * @param lis
	 *            报表选择监听器
	 */
	public void setData(BarChart barChart, List<BarChartEntity> entityList,
			OnChartValueSelectedListener lis) {
		setBarChartAppearance(barChart);
		barChart.setOnChartValueSelectedListener(lis);

		ArrayList<String> commonkeys = new ArrayList<String>();
		ArrayList<BarDataSet> bardatasetlist = new ArrayList<BarDataSet>();
		for (BarChartEntity entity : entityList) {
			LinkedHashMap<String, Float> mData = entity.getmData();
			ArrayList<Float> values = new ArrayList<Float>();
			ArrayList<String> keys = new ArrayList<String>();

			Iterator<?> iter = mData.entrySet().iterator();
			while (iter.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry entry = (Map.Entry) iter.next();
				keys.add((String) entry.getKey());
				values.add((Float) entry.getValue());
			}

			commonkeys = keys;

			ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
			for (int i = 0; i < mData.size(); i++) {
				entries.add(new BarEntry(values.get(i), i));
			}

			// 柱形数据的集合
			BarDataSet mBarDataSet = new BarDataSet(entries,
					entity.getmBarName());
			mBarDataSet.setBarSpacePercent(entity.getmBarSpacePercent());
			mBarDataSet.setColors(new int[] { entity.getmBarColor() });// 设置每条柱子的颜色，数组和X轴长度不一定相同
			mBarDataSet.setHighLightAlpha(255);// 设置点击后高亮颜色透明度
			mBarDataSet.setHighLightColor(entity.getmHighLightColor());

			bardatasetlist.add(mBarDataSet);
		}// end for

		BarData mBarData = new BarData(commonkeys, bardatasetlist);
		barChart.setData(mBarData);
		barChart.animateY(1000);// 设置动画
	}

	/**
	 * 设置报表数据
	 * 
	 * @param barChart
	 *            折线图和柱状图混合
	 * @param entityList1
	 *            柱形数据集合，，如果要在同一个柱形报表上显示多柱形，则所有的柱形应该具有相同的格式
	 * @param lis
	 *            报表选择监听器
	 */
		public void setData(CombinedChart comchart, List<CombinedChartEntity> entityList,List<LineChartEntity> entityList1,List<BarChartEntity> entityList_bar,
				OnChartValueSelectedListener lis) {
			setCombinedChartAppearance(comchart);
			comchart.setOnChartValueSelectedListener(lis);

			ArrayList<String> commonkeys = new ArrayList<String>();
			ArrayList<LineDataSet> mLineDataSetList = new ArrayList<LineDataSet>();
			for (LineChartEntity entity : entityList1) {
				LinkedHashMap<String, Float> mData = entity.getmData();
				ArrayList<Float> values = new ArrayList<Float>();
				ArrayList<String> keys = new ArrayList<String>();

				Iterator<?> iter = mData.entrySet().iterator();
				while (iter.hasNext()) {
					@SuppressWarnings("rawtypes")
					Map.Entry entry = (Map.Entry) iter.next();
					keys.add((String) entry.getKey());
					values.add((Float) entry.getValue());
				}
				commonkeys = keys;

				ArrayList<Entry> entryList = new ArrayList<Entry>();
				for (int i = 0; i < mData.size(); i++) {
					// Entry(yValue,xIndex);一个Entry表示一个点，第一个参数为y值，第二个为X轴List的角标
					entryList.add(new Entry(values.get(i), i));
				}

				LineDataSet dataSet = new LineDataSet(entryList,
						entity.getLineName());
				dataSet.setLineWidth(entity.getmLineWidth());
				dataSet.setColor(entity.getmLineColor());
				dataSet.setCircleSize(entity.getmLineCircleSize());
				dataSet.setCircleColor(entity.getmLineColor());
				dataSet.setHighLightColor(entity.getmHighLightColor());// 设置点击某个点时，横竖两条线的颜色
				dataSet.setDrawValues(true);// 是否在点上绘制Value
				LineData d = new LineData();
				mLineDataSetList.add(dataSet);

			}// end for

			// LineData表示一个LineChart的所有数据(即一个LineChart中所有折线的数据)
			LineData mChartData = new LineData(commonkeys, mLineDataSetList);

			
			ArrayList<String> commonkeys1 = new ArrayList<String>();
			ArrayList<BarDataSet> bardatasetlist = new ArrayList<BarDataSet>();
			for (BarChartEntity entity : entityList_bar) {
				LinkedHashMap<String, Float> mData = entity.getmData();
				ArrayList<Float> values = new ArrayList<Float>();
				ArrayList<String> keys = new ArrayList<String>();

				Iterator<?> iter = mData.entrySet().iterator();
				while (iter.hasNext()) {
					@SuppressWarnings("rawtypes")
					Map.Entry entry = (Map.Entry) iter.next();
					keys.add((String) entry.getKey());
					values.add((Float) entry.getValue());
				}

				commonkeys1 = keys;

				ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
				for (int i = 0; i < mData.size(); i++) {
					entries.add(new BarEntry(values.get(i), i));
				}

				// 柱形数据的集合
				BarDataSet mBarDataSet = new BarDataSet(entries,
						entity.getmBarName());
				mBarDataSet.setBarSpacePercent(entity.getmBarSpacePercent());
				mBarDataSet.setColors(new int[] { entity.getmBarColor() });// 设置每条柱子的颜色，数组和X轴长度不一定相同
				mBarDataSet.setHighLightAlpha(255);// 设置点击后高亮颜色透明度
				mBarDataSet.setHighLightColor(entity.getmHighLightColor());

				bardatasetlist.add(mBarDataSet);
			}// end for

			BarData mBarData = new BarData(commonkeys, bardatasetlist);
			
			CombinedData combinedData=new CombinedData(commonkeys);
			combinedData.setData(mBarData);
			combinedData.setData(mChartData);
			comchart.setData(combinedData);
			comchart.animateXY(1000, 1000);
		}
		
		

	/**
	 * 设置报表数据
	 * 
	 * @param barChart
	 *            柱形图
	 * @param entity
	 *            柱形数据
	 * @param lis
	 *            报表选择监听器
	 */
	public void setData(BarChart barChart, BarChartEntity entity,
			OnChartValueSelectedListener lis) {
		setBarChartAppearance(barChart);
		barChart.setOnChartValueSelectedListener(lis);

		LinkedHashMap<String, Float> mData = entity.getmData();
		ArrayList<Float> values = new ArrayList<Float>();
		ArrayList<String> keys = new ArrayList<String>();

		Iterator<?> iter = mData.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			keys.add((String) entry.getKey());
			values.add((Float) entry.getValue());
		}

		ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
		for (int i = 0; i < mData.size(); i++) {
			entries.add(new BarEntry(values.get(i), i));
		}

		// 柱形数据的集合
		BarDataSet mBarDataSet = new BarDataSet(entries, entity.getmBarName());
		mBarDataSet.setBarSpacePercent(entity.getmBarSpacePercent());
		mBarDataSet.setColors(new int[] { entity.getmBarColor() });// 设置每条柱子的颜色，数组和X轴长度不一定相同
		mBarDataSet.setHighLightAlpha(255);// 设置点击后高亮颜色透明度
		mBarDataSet.setHighLightColor(entity.getmHighLightColor());

		BarData mBarData = new BarData(keys, mBarDataSet);
		barChart.setData(mBarData);
		barChart.animateY(1000);// 设置动画
	}

	public void setData(PieChart pieChart, PieChartEntity entity,
			PieCharSettings mPieCharSettings, OnChartValueSelectedListener lis) {
		// setPieChartAppearance(pieChart);

		pieChart.setDescription("");
		pieChart.setHoleRadius(52f);
		pieChart.setTransparentCircleRadius(57f);
		pieChart.setCenterTextSize(17f);
		pieChart.setUsePercentValues(mPieCharSettings.usePercentValue);
		// pieChart.setUsePercentValues(true);

		// 中心文字颜色
		pieChart.setCenterTextColor(Color.BLACK);

		pieChart.setOnChartValueSelectedListener(lis);

		LinkedHashMap<String, Float> mData = entity.getmData();
		ArrayList<Float> values = new ArrayList<Float>();
		ArrayList<String> keys = new ArrayList<String>();

		Iterator<?> iter = mData.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			keys.add((String) entry.getKey());
			// keys.add("");
			values.add((Float) entry.getValue());
		}

		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (int i = 0; i < mData.size(); i++) {
			entries.add(new BarEntry(values.get(i), i));
		}

		PieDataSet mPieDataSet = new PieDataSet(entries, "");

		// space between slices
		mPieDataSet.setSliceSpace(2f);
		mPieDataSet.setColors(mPieCharSettings.colors);

		PieData mPieChartData = new PieData(keys, mPieDataSet);

		// set data
		pieChart.setData(mPieChartData);
		pieChart.setDrawSliceText(mPieCharSettings.drawSliceText);

		// 设置动画
		pieChart.animateXY(1000, 1000);

		Legend l = pieChart.getLegend();
		l.setPosition(mPieCharSettings.legendPosition);
		l.setTextSize(mPieCharSettings.legendTextSize);

		if (mPieCharSettings.usePercentValue == true) {
			mPieChartData.setValueFormatter(new PercentFormatter());// 设置显示成百分比
		}
		//
		// mChartData.setValueTypeface(mTf);
		mPieChartData.setValueTextSize(mPieCharSettings.valueTextSize);// 设置文字大小
		mPieChartData.setValueTextColor(mPieCharSettings.valueTextColor);

		// 设置中心数据
		pieChart.setCenterText(entity.getmCenterText());
	}

	/**
	 * 设置报表数据
	 * 
	 * @param pieChart
	 *            饼形图
	 * @param entity
	 *            饼形图数据
	 * @param lis
	 *            报表选择监听器
	 */
	public void setData(PieChart pieChart, PieChartEntity entity,
			OnChartValueSelectedListener lis) {
		setPieChartAppearance(pieChart);
		pieChart.setOnChartValueSelectedListener(lis);

		LinkedHashMap<String, Float> mData = entity.getmData();
		ArrayList<Float> values = new ArrayList<Float>();
		ArrayList<String> keys = new ArrayList<String>();

		Iterator<?> iter = mData.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			keys.add((String) entry.getKey());
			values.add((Float) entry.getValue());
		}

		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (int i = 0; i < mData.size(); i++) {
			entries.add(new BarEntry(values.get(i), i));
		}

		PieDataSet mPieDataSet = new PieDataSet(entries, "");

		// space between slices
		mPieDataSet.setSliceSpace(2f);
		mPieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

		PieData mPieChartData = new PieData(keys, mPieDataSet);

		// set data
		pieChart.setData(mPieChartData);

		// 设置动画
		pieChart.animateXY(1000, 1000);

		Legend l = pieChart.getLegend();
		l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
		l.setTextSize(12f);

		mPieChartData.setValueFormatter(new PercentFormatter());// 设置显示成百分比
		// mChartData.setValueTypeface(mTf);
		mPieChartData.setValueTextSize(12f);// 设置文字大小
		mPieChartData.setValueTextColor(Color.BLACK);

		// 设置中心数据
		pieChart.setCenterText(entity.getmCenterText());
	}

	/**
	 * 设置折线图的整体外观
	 * 
	 * @param lineChart
	 */
	private void setLineChartAppearance(LineChart lineChart) {
		lineChart.setScaleEnabled(true);
		lineChart.setDoubleTapToZoomEnabled(false);
		lineChart.setDescription("");
		// 设置X轴
		XAxis xAxis = lineChart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);// 设置X轴的位置
		// xAxis.setTypeface(mTf);//设置字体
		xAxis.setDrawGridLines(true);
		xAxis.setDrawAxisLine(true);
		xAxis.setDrawLabels(true);
		xAxis.setSpaceBetweenLabels(0);
		// 获得左侧侧坐标轴
//		YAxis leftAxis = lineChart.getAxisLeft();
		// leftAxis.setTypeface(mTf);
//		leftAxis.setLabelCount(5);
		// leftAxis.setAxisLineWidth(1.5f);

		// 设置右侧坐标轴
		YAxis rightAxis = lineChart.getAxisRight();
		rightAxis.setDrawAxisLine(false);// 右侧坐标轴线
		rightAxis.setDrawLabels(false);// 右侧坐标轴数组Lable
	}

	/**
	 * 设置柱形图的整体外观
	 * 
	 * @param barChart
	 */
	private void setBarChartAppearance(BarChart barChart) {
		barChart.setDrawGridBackground(false);// 设置网格背景
		barChart.setScaleEnabled(true);// 设置缩放
		barChart.setDoubleTapToZoomEnabled(false);
		barChart.setDescription("");

		// 设置X轴
		XAxis xAxis = barChart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);// 设置X轴的位置
		// xAxis.setTypeface(mTf);//设置字体
		xAxis.setDrawGridLines(false);
		xAxis.setDrawAxisLine(true);
		xAxis.setSpaceBetweenLabels(0);
		// 获得左侧侧坐标轴
		// YAxis leftAxis = barChart.getAxisLeft();
		// leftAxis.setTypeface(mTf);
		// leftAxis.setLabelCount(5);
		// leftAxis.setAxisLineWidth(1.5f);

		// 设置右侧坐标轴
		YAxis rightAxis = barChart.getAxisRight();
		rightAxis.setDrawAxisLine(false);// 右侧坐标轴线
		rightAxis.setDrawLabels(false);// 右侧坐标轴数组Lable
	}

	/**
	 * 设置折线图柱状图混合柱形图的整体外观
	 * 
	 * @param barChart
	 */
	private void setCombinedChartAppearance(CombinedChart comChart) {
		comChart.setDrawGridBackground(false);// 设置网格背景
		comChart.setScaleEnabled(true);// 设置缩放
		comChart.setDoubleTapToZoomEnabled(false);
		comChart.setDescription("");

		// 设置X轴
		XAxis xAxis = comChart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);// 设置X轴的位置
		// xAxis.setTypeface(mTf);//设置字体
		xAxis.setDrawGridLines(false);
		xAxis.setDrawAxisLine(true);
		xAxis.setDrawLabels(true);
		xAxis.setSpaceBetweenLabels(-1);
//		xAxis.setAvoidFirstLastClipping(true);
		// 获得左侧侧坐标轴
		// YAxis leftAxis = barChart.getAxisLeft();
		// leftAxis.setTypeface(mTf);
		// leftAxis.setLabelCount(5);
		// leftAxis.setAxisLineWidth(1.5f);

		// 设置右侧坐标轴
		YAxis rightAxis = comChart.getAxisRight();
		rightAxis.setDrawAxisLine(false);// 右侧坐标轴线
		rightAxis.setDrawLabels(false);// 右侧坐标轴数组Lable
	}

	/**
	 * 设置饼形图的整体外观
	 * 
	 * @param barChart
	 */
	private void setPieChartAppearance(PieChart pieChart) {
		pieChart.setDescription("");
		pieChart.setHoleRadius(52f);
		pieChart.setTransparentCircleRadius(57f);
		pieChart.setCenterTextSize(17f);
		pieChart.setUsePercentValues(true);

		// 中心文字颜色
		pieChart.setCenterTextColor(Color.BLACK);
	}
}
