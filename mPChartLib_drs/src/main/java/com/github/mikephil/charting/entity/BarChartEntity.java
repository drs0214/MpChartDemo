package com.github.mikephil.charting.entity;

import java.util.LinkedHashMap;

/**
 * @author Dell-
 *柱形图实体类
 */
public class BarChartEntity {
	
	private static final float BAR_SPACE_PERCENT = 20f;
	private static final int BAR_COLOR = 0Xffecb8b8;
	private static final int BAR_HIGH_LIGHT_COLOR = 0Xff35e7f2;

	// 柱形图名称或者图例名称
	private String mBarName = "";
	// 柱形图值
	private LinkedHashMap<String, Float> mData;
	
	private float mBarSpacePercent = BAR_SPACE_PERCENT;
	private int mBarColor = BAR_COLOR;
	private int mHighLightColor = BAR_HIGH_LIGHT_COLOR;
	
	
	/**
	 * @param mBarName 图例名称
	 * @param mData 柱形图数据
	 */
	public BarChartEntity(String mBarName, LinkedHashMap<String, Float> mData) {
		super();
		this.mBarName = mBarName;
		this.mData = mData;
	}


	public String getmBarName() {
		return mBarName;
	}


	public void setmBarName(String mBarName) {
		this.mBarName = mBarName;
	}


	public LinkedHashMap<String, Float> getmData() {
		return mData;
	}


	public void setmData(LinkedHashMap<String, Float> mData) {
		this.mData = mData;
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


	public int getmHighLightColor() {
		return mHighLightColor;
	}


	public void setmHighLightColor(int mHighLightColor) {
		this.mHighLightColor = mHighLightColor;
	}
	
	
	
	
}
