/*
 * Created by: Vu Thai Duy
 * Created date: 20/3/2013
 * Reference:
 * 
 * Name: Gallery Custom 
 * Language: Android
 * Tool: Eclipse
 * Library: AndroidSDK
 * 
 * Description:
 * 		- Create Gallery Custom extends "Gallery" 
 * 		- and Override "onInterceptTouchEvent(MotionEvent ev)"
 * 		- in order to parent can receive event from children
 * 
 * Using:
 * 		- set GalleyCustom as widget in layout
 * 			    <com.example.gallery.GalleryCustom
        			android:id="@+id/gallery1"
        			android:layout_width="fill_parent"
        			android:layout_height="fill_parent"
        			android:spacing="20dp" />
 * 
 * 
 * Note:
 * 
 * Tip:
 */

package com.example.firstdatabaseexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class GalleryCustom extends Gallery {

	public GalleryCustom(Context context) {
		super(context);
	}

	public GalleryCustom(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GalleryCustom(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	// allow parent receive event from child context
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		onTouchEvent(ev);
		return false;
	}

}
