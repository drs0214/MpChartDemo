package com.github.mikephil.charting.entity;

import java.util.LinkedHashMap;

public class CombinedChartEntity {
	private static final int LINE_COLOR = 0Xff72eaeb;
	private static final float LINE_WIDTH = 2.5f;
	private static final float LINE_CIRCLE_SIZE = 4.5f;
	private static final int HIGH_LIGHT_COLOR = 0Xfff9432b;

	// 折线名称或者图例名称
	private String lineName = "";
	// 折线值
	private LinkedHashMap<String, Float> mData;

	private int mLineColor = LINE_COLOR;
	private float mLineWidth = LINE_WIDTH;
	private float mLineCircleSize = LINE_CIRCLE_SIZE;
	private int mHighLightColor = HIGH_LIGHT_COLOR;

	// 柱状图部分
	private static final float BAR_SPACE_PERCENT = 20f;
	private static final int BAR_COLOR = 0Xffecb8b8;
	private static final int BAR_HIGH_LIGHT_COLOR = 0Xff35e7f2;

	// 柱形图名称或者图例名称
	private String mBarName = "";
	// 柱形图值
	private LinkedHashMap<String, Float> mData1;

	private float mBarSpacePercent = BAR_SPACE_PERCENT;
	private int mBarColor = BAR_COLOR;

	/**
	 * @param lineName
	 *            折线名称或者图例名称
	 * @param mData
	 *            折线值
	 */
	public CombinedChartEntity(String lineName,
			LinkedHashMap<String, Float> mData,
			LinkedHashMap<String, Float> mData1) {
		super();
		this.lineName = lineName;
		this.mData = mData;
		this.mData1 = mData1;
	}

	public CombinedChartEntity(Float float1, int i) {
		// TODO Auto-generated constructor stub
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public LinkedHashMap<String, Float> getmData() {
		return mData;
	}

	public void setmData(LinkedHashMap<String, Float> mData) {
		this.mData = mData;
	}

	public int getmLineColor() {
		return mLineColor;
	}

	public void setmLineColor(int mLineColor) {
		this.mLineColor = mLineColor;
	}

	public float getmLineWidth() {
		return mLineWidth;
	}

	public void setmLineWidth(float mLineWidth) {
		this.mLineWidth = mLineWidth;
	}

	public float getmLineCircleSize() {
		return mLineCircleSize;
	}

	public void setmLineCircleSize(float mLineCircleSize) {
		this.mLineCircleSize = mLineCircleSize;
	}

	public int getmHighLightColor() {
		return mHighLightColor;
	}

	public void setmHighLightColor(int mHighLightColor) {
		this.mHighLightColor = mHighLightColor;
	}

	public String getmBarName() {
		return mBarName;
	}

	public void setmBarName(String mBarName) {
		this.mBarName = mBarName;
	}

	public LinkedHashMap<String, Float> getmData1() {
		return mData1;
	}

	public void setmData1(LinkedHashMap<String, Float> mData1) {
		this.mData1 = mData1;
	}

	public float getmBarSpacePercent() {
		return mBarSpacePercent;
	}

	public void setmBarSpacePercent(float mBarSpacePercent) {
		this.mBarSpacePercent = mBarSpacePercent;
	}

	public int getmBarColor() {
		return mBarColor;
	}

	public void setmBarColor(int mBarColor) {
		this.mBarColor = mBarColor;
	}

}
