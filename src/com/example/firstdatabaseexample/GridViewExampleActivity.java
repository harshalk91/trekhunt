package com.example.firstdatabaseexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewExampleActivity extends Activity {
    /** Called when the activity is first created. */
	
	private GridviewAdapter mAdapter;
	private ArrayList<String> listCountry;
	private ArrayList<Integer> listFlag;
	
	private GridView gridView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        prepareList();
        
        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridviewAdapter(this,listCountry, listFlag);
        
        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(mAdapter);
        
        // Implement On Item click listener
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				String pos=mAdapter.getItem(position);
			  
		Toast.makeText(GridViewExampleActivity.this, pos,Toast.LENGTH_SHORT).show();
		if(pos.equalsIgnoreCase("giridarshan"))
		{
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.giridarshan.com"));
			startActivity(browserIntent);
		}
		if(pos.equalsIgnoreCase("chakram hikers"))
		{
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chakramhikers.com"));
			startActivity(browserIntent);

		}	
		if(pos.equalsIgnoreCase("explorers"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.explorers.com"));
			 startActivity(browserIntent);

		}
		if(pos.equalsIgnoreCase("trek mates india"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trekmatesindia.com"));
			 startActivity(browserIntent);

		}
		if(pos.equalsIgnoreCase("trekdi"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trekdi.com"));
			 startActivity(browserIntent);

		}
			
		if(pos.equalsIgnoreCase("offbeat sahyadri"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.offbeatsahyadri.com"));
			 startActivity(browserIntent);

		}
		
		if(pos.equalsIgnoreCase("yuvashakti"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yuvashakti.com"));
			 startActivity(browserIntent);

		}
		
		if(pos.equalsIgnoreCase("trekshitiz"))
		{
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trekshitiz.com"));
			 startActivity(browserIntent);

		}
		}
		});
        
    }
    
    public void prepareList()
    {
    	  listCountry = new ArrayList<String>();
    	  
    	  listCountry.add("Chakram Hikers");
    	  listCountry.add("Explorers");
          listCountry.add("Giridarshan");
          listCountry.add("Trek Mates India");
          listCountry.add("TrekDi");
          listCountry.add("Offbeat Sahyadri");
          listCountry.add("Yuvashakti");
          listCountry.add("Trekshitiz");
         
          
          
          listFlag = new ArrayList<Integer>();
          listFlag.add(R.drawable.chakram);
          listFlag.add(R.drawable.explorers);
          listFlag.add(R.drawable.gtc);
          listFlag.add(R.drawable.trekmates);
          listFlag.add(R.drawable.trekdi);
          listFlag.add(R.drawable.offbeat);
          listFlag.add(R.drawable.yuvashakti);
          listFlag.add(R.drawable.trekshitiz);
         
          
    }
   
}