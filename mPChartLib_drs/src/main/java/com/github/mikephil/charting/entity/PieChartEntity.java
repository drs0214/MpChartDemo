package com.github.mikephil.charting.entity;

import java.util.LinkedHashMap;

public class PieChartEntity {

	// 饼形图中心显示名称
	private String mCenterText = "";
	// 饼形图值
	private LinkedHashMap<String, Float> mData;
	
	public PieChartEntity(String mDescription, LinkedHashMap<String, Float> mData) {
		super();
		this.mCenterText = mDescription;
		this.mData = mData;
	}

	public String getmCenterText() {
		return mCenterText;
	}

	public void setmCenterText(String mCenterText) {
		this.mCenterText = mCenterText;
	}

	public LinkedHashMap<String, Float> getmData() {
		return mData;
	}

	public void setmData(LinkedHashMap<String, Float> mData) {
		this.mData = mData;
	}
	
	
	
}
