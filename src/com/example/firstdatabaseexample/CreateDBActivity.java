package com.example.firstdatabaseexample;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;

public class CreateDBActivity extends Activity {
	private DistrictsDataSource districtdatasource;
	private FortsDataSource fortdatasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		createTables();
		startDistrictListActivity();
	}

	private void startDistrictListActivity() {
		Intent i = new Intent(this,Welcome.class);
		startActivity(i);
		finish();
		
	}

	private void createTables() {
		createDistrictTable();
		createFortTable();
	}

	private void createFortTable() {
		fortdatasource = new FortsDataSource(this);
		try {
				createForts();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void createDistrictTable() {
		districtdatasource = new DistrictsDataSource(this);
		districtdatasource.open();
		String[] districts = new String[] { "Pune", "Nashik", "Kolhapur",
		  		  "Satara","Ratnagiri","Raigad"};
		try
	    {
	    for(int i=0;i<districts.length;i++)
	    {
	    	districtdatasource.createDistrict(i+1,districts[i]);
	    }
	    }
	    catch(Exception e)
	    {
	    	Log.e("Districts", "Tried inserting duplicate districts");
	    	e.printStackTrace();
	    }
	}
	
	  private void createForts() throws Exception {
		  fortdatasource.open();
		  AssetManager am = getAssets();
		  InputStream fin = am.open("trekhunt.csv");
		  BufferedReader CSVFile = new BufferedReader(new InputStreamReader(new DataInputStream(fin)));
		  String dataRow = CSVFile.readLine(); // Read first line.
		  
		  // The while checks to see if the data is null. If 
		  // it is, we've hit the end of the file. If not, 
		  // process the data.
		  CSV_Parser parser = new CSV_Parser();
		  ArrayList<String> data = new ArrayList<String>();
		  int i=0,j=0;
		  while (dataRow != null){
		   data = parser.extractFromCommas(dataRow);
		   
		  i=0;
		   int dist_id = 0;
		   try
		   {
			    int id = ++j;
			    String name = data.get(i++);
			    String height = data.get(i++);
			    String type = data.get(i++);
			    String range = data.get(i++);
			    String grade = data.get(i++);
			    String spots = data.get(i++);
			    String ways_to_reach = data.get(i++);
			    String accomodation = data.get(i++);
			    String food = data.get(i++);
			    String water = data.get(i++);
			    String time_to_reach = data.get(i++);
			    String img_path_1 = data.get(i++);
			    String img_path_2 = data.get(i++);
			    String img_path_3 = data.get(i++);
			    String img_path_4 = data.get(i++);
			    String map_path = data.get(i++);
			    dist_id = Integer.parseInt(data.get(i++));
				fortdatasource.createFort(id,name,height, 
						type, range, grade, spots, ways_to_reach, accomodation, 
						food, water, time_to_reach, img_path_1, img_path_2, 
						img_path_3, img_path_4, map_path, dist_id);
		   }
		   catch(NumberFormatException e)
		   {
			   Log.e("CreateDB", "Invalid value for dist_id=("+dist_id+")");
		   }
		   catch(SQLiteException se)
		   {
			   Log.e("Fort", "Tried inserting duplicate fort");  
		   }
			   //System.out.print(data.get(i)+"\t");
		   	   dataRow = CSVFile.readLine(); // Read next line of data.
		   	   
		  }
		  // Close the file once all data has been read.
		  CSVFile.close();

		
		
	}
	  
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		districtdatasource.close();
		fortdatasource.close();
	} 
}
