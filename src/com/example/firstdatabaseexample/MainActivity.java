/*
 * Created by: Vu Thai Duy
 * Created date: 20/3/2013
 * Reference:
 * 		- https://github.com/jasonpolites/gesture-imageview
 * 
 * Name: MainActivity
 * Language: Android
 * Tool: Eclipse
 * Library: 
 * 		- AndroidSDK
 * 		- gesture-imageview: used for zooming image
 * 			https://github.com/jasonpolites/gesture-imageview
 * 
 * Description:
 * 		- Display image into gallery
 * 		- zoom and slide image
 * 
 * Using:
 * 		- get Gallery object from layout
 * 		- set Data for gallery using BaseAdapter
 * 
 * Note:	
 * 
 * Tip:	
 */

package com.example.firstdatabaseexample;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;

import com.polites.android.GestureImageView;

public class MainActivity extends Activity {

	Integer[] mPhoto = null/*{ R.drawable.loh1, R.drawable.loh2, R.drawable.loh3,
			R.drwable, R.drawable.loh5, R.drawable.img_06, }*/;
	private int fort_id = 0;
	private int dist_id = 0;
	private String img_path_1 = "";
	private String img_path_2 = "";
	private String img_path_3 = "";
	private String img_path_4 = "";
	private String map_path = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		fillData();
		// using GalleryCustom which is extends of Gallery
		// and override "onInterceptTouchEvent"
		final GalleryCustom gallery = (GalleryCustom) findViewById(R.id.gallery1);
		gallery.setAdapter(new ImageAdapter(this, mPhoto));

		// set Default image which is display first when gallery load
		gallery.setSelection(0);

	}
	
	private void fillData()
	{
		Bundle b = getIntent().getExtras();
		if(b.containsKey("image"))
		{
		img_path_1 = b.getString("img_path_1");
		img_path_2 = b.getString("img_path_2");
		img_path_3 = b.getString("img_path_3");
		img_path_4 = b.getString("img_path_4");
		mPhoto = new Integer[] {getResources().getIdentifier(img_path_1, "drawable", "com.example.firstdatabaseexample"),
				getResources().getIdentifier(img_path_2, "drawable", "com.example.firstdatabaseexample"),
				getResources().getIdentifier(img_path_3, "drawable", "com.example.firstdatabaseexample"),
				getResources().getIdentifier(img_path_4, "drawable", "com.example.firstdatabaseexample")};
			return;
		}
		
		if(b.containsKey("map"))
		{
			map_path = b.getString("map_path");
			mPhoto = new Integer[] {
					getResources().getIdentifier(map_path, "drawable", "com.example.firstdatabaseexample")
			};
		}
	}
	private class ImageAdapter extends BaseAdapter {

		Context mContext;
		Integer[] mImages;

		public ImageAdapter(Context context, Integer[] images) {
			mContext = context;
			mImages = images;
		}

		@Override
		public int getCount() {
			return mImages.length;
		}

		@Override
		public Object getItem(int position) {
			return mImages[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			// create new GestureImageView
			GestureImageView iv = new GestureImageView(mContext);
			iv.setImageResource(mImages[position]);
			iv.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.FILL_PARENT,
					Gallery.LayoutParams.FILL_PARENT));

			// set Scale for zooming
			iv.setMinScale((float) 0.7);
			iv.setMaxScale((float) 6.0);

			// add GestureImage to Gallery
			return iv;
		}
	}

}
