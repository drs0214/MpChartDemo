package com.github.mikephil.charting.entity;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.graphics.Color;

public class PieCharSettings {

	public int[] colors = ColorTemplate.VORDIPLOM_COLORS;// 分区颜色值数组
	public float valueTextSize = 12f;// 分区显示的值的字体大小
	public int valueTextColor = Color.BLACK;// 分区显示的值的字体颜色
	public float legendTextSize = 12f;// 图例字体大小
	public LegendPosition legendPosition = Legend.LegendPosition.BELOW_CHART_LEFT;// 图例摆放的位置
	public boolean usePercentValue = false;
	public boolean drawSliceText = true;
}
