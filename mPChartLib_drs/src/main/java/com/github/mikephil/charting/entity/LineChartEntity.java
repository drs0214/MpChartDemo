package com.github.mikephil.charting.entity;

import java.util.LinkedHashMap;

/**
 * @author Dell-
 *折线图实体类，代表一条折线
 */
public class LineChartEntity {
	
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
	
	
	/**
	 * @param lineName 折线名称或者图例名称
	 * @param mData 折线值
	 */
	public LineChartEntity(String lineName, LinkedHashMap<String, Float> mData) {
		super();
		this.lineName = lineName;
		this.mData = mData;
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


	
	
	

}
