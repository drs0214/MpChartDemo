package com.github.mikephil.charting.helper;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper {

	public static void show(Context context, String msg)
	{
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}
