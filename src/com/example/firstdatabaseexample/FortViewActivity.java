package com.example.firstdatabaseexample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class FortViewActivity extends Activity {
	
	private TextView textFortName = null;
	private TextView textHeight = null;
	private TextView textType = null;
	private TextView textRange = null;
	private TextView textGrade = null;
	private TextView textSpots = null;
	private TextView textWayToReach = null;
	private TextView textAccomodation = null;
	private TextView textFood = null;
	private TextView textWater = null;
	private TextView textTimeToReach = null;
	private Button buttonImage = null;
	private Button buttonMap = null;
 //Add variables for all controls

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
		setContentView(R.layout.fort_view);
		initEditTextControls();
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Bundle b = getIntent().getExtras();
		if((b == null )|| (!b.containsKey("fort_id")))
			finish();
		 fort_id = b.getInt("fort_id");
		filldata(fort_id);
	}
	private void filldata(int fort_id) {
		FortsDataSource fdatasource = new FortsDataSource(this);
		fdatasource.open();
		Fort fort = fdatasource.getFortFromFortId(fort_id);
		if(fort == null)
		{
			finish();
		}
		
		dist_id = (int) fort.getDistrictId();
		img_path_1 = fort.getImagePath1();
		img_path_2 = fort.getImagePath2();
		img_path_3 = fort.getImagePath3();
		img_path_4 = fort.getImagePath4();
		map_path = fort.getMapPath();
		if(textFortName != null)
		{
			textFortName.setText(fort.getName());
		}
		
		if(textHeight != null) //repeat this for all views
		{
			textHeight.setText(fort.getHeight());
		}
	
		if(textType != null)
		{
			textType.setText(fort.getType());
			
		}
		
		if(textRange != null) 
		{
			textRange.setText(fort.getRange());
		}
		
		if(textGrade != null) 
		{
			textGrade.setText(fort.getGrade());
		}
		
		if(textSpots != null)
		{
			textSpots.setText(fort.getSpots());
		}
		
		if(textWayToReach != null) 
		{
			textWayToReach.setText(fort.waysToReach());
			
		}
		
		if(textAccomodation != null) 
		{
			textAccomodation.setText(fort.getAccomodation());
			
		}
		
		if(textFood != null) 
		{
			textFood.setText(fort.getFood());
		}
		
		if(textWater != null) 
		{
			textWater.setText(fort.getWater());
		}
		
		if(textTimeToReach != null) 
		{
			textTimeToReach.setText(fort.getTimeToReach());
		}
		
		
		if(img_path_1.equalsIgnoreCase("path")&&
		   img_path_2.equalsIgnoreCase("path")&&
		   img_path_3.equalsIgnoreCase("path")&&
		   img_path_4.equalsIgnoreCase("path"))
		{
			if(buttonImage!=null)
			{
				buttonImage.setVisibility(View.INVISIBLE);
			}
		}
		
		
		
		if(map_path.equalsIgnoreCase("path"))
		{
			if(buttonMap!=null)
			{
				buttonMap.setVisibility(View.INVISIBLE);
			}
		}

	}
   // This will initialize controls
	private void initEditTextControls() {
		textFortName = (TextView) findViewById(R.id.textFortName);
		textHeight = (TextView) findViewById(R.id.textHeight);
		textType = (TextView) findViewById(R.id.textType);
		textRange = (TextView) findViewById(R.id.textRange);
		textGrade = (TextView) findViewById(R.id.textGrade);
		textSpots = (TextView) findViewById(R.id.textSpots);
		textWayToReach = (TextView) findViewById(R.id.textWayToReach);
		textAccomodation = (TextView) findViewById(R.id.textAccomodation);
		textFood = (TextView) findViewById(R.id.textFood);
		textWater = (TextView) findViewById(R.id.textWater);
		textTimeToReach = (TextView) findViewById(R.id.textTimeToReach);
		buttonImage = (Button) findViewById(R.id.buttonImage);
		buttonMap = (Button) findViewById(R.id.buttonMap);
		// to write for all controls
	}
	
	public void onClickImages(View v)
	{
		Intent i = new Intent(this,MainActivity.class);
		i.putExtra("image", "image");
		i.putExtra("img_path_1",img_path_1);
		i.putExtra("img_path_2",img_path_2);
		i.putExtra("img_path_3",img_path_3);
		i.putExtra("img_path_4",img_path_4);
		startActivity(i);
	}
	
	public void onClickMap(View v)
	{
		Intent i = new Intent(this,MainActivity.class);
		i.putExtra("map", "map");
		i.putExtra("map_path",map_path);
		startActivity(i);
	}
	

	
}
