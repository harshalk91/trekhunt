package com.example.firstdatabaseexample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FortsDataSource {

	
  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.ID,
		  						MySQLiteHelper.NAME,
		  						MySQLiteHelper.HEIGHT,
		  						MySQLiteHelper.TYPE,
		  						MySQLiteHelper.RANGE,
		  						MySQLiteHelper.GRADE,
		  						MySQLiteHelper.SPOTS,
		  						MySQLiteHelper.WAYS_TO_REACH,
		  						MySQLiteHelper.ACCOMODATION,
		  						MySQLiteHelper.FOOD,
		  						MySQLiteHelper.WATER,
		  						MySQLiteHelper.TIME_TO_REACH,
		  						MySQLiteHelper.IMG_PATH_1,
		  						MySQLiteHelper.IMG_PATH_2,
		  						MySQLiteHelper.IMG_PATH_3,
		  						MySQLiteHelper.IMG_PATH_4,
		  						MySQLiteHelper.MAP_PATH,
		  						MySQLiteHelper.DIST_ID};//all columns

  public FortsDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Fort createFort(int id,String name,String height,String type,
		  String range,String grade,String spots,String ways_to_reach,String accomodation,
		  String food,String water,String time_to_reach,String img_path_1,
		  String img_path_2,String img_path_3,String img_path_4,String map_path,int dist_id) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.ID, id);
    values.put(MySQLiteHelper.NAME, name);
    values.put(MySQLiteHelper.HEIGHT, height);
    values.put(MySQLiteHelper.TYPE, type);
    values.put(MySQLiteHelper.RANGE,range);
    values.put(MySQLiteHelper.GRADE,grade);
    values.put(MySQLiteHelper.SPOTS,spots);
    values.put(MySQLiteHelper.WAYS_TO_REACH,ways_to_reach);
    values.put(MySQLiteHelper.ACCOMODATION, accomodation);
    values.put(MySQLiteHelper.FOOD,food);
    values.put(MySQLiteHelper.WATER,water);
    values.put(MySQLiteHelper.TIME_TO_REACH,time_to_reach);
    values.put(MySQLiteHelper.IMG_PATH_1, img_path_1);
    values.put(MySQLiteHelper.IMG_PATH_2, img_path_2);
    values.put(MySQLiteHelper.IMG_PATH_3, img_path_3);
    values.put(MySQLiteHelper.IMG_PATH_4, img_path_4);
    values.put(MySQLiteHelper.MAP_PATH, map_path);
    values.put(MySQLiteHelper.DIST_ID, dist_id);
    long insertId = database.insert(MySQLiteHelper.TABLE_FORT, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_FORT,
        allColumns, MySQLiteHelper.ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Fort newFort = cursorToFort(cursor);
    cursor.close();
    return newFort;
  }

/*  public void deleteDistrict(District district) {
    long id = district.getId();
    System.out.println("District deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_DISTRICT, MySQLiteHelper.DISTRICT_ID
        + " = " + id, null);
  }*/

  public Cursor getFortsforDistrict(int dist_id)
  {
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FORT,
		        allColumns, MySQLiteHelper.DIST_ID+"="+dist_id, null, null, null, null);
	  return cursor;
  }
  public List<Fort> getAllForts() {
    List<Fort> Forts = new ArrayList<Fort>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_FORT,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Fort fort = cursorToFort(cursor);
      Forts.add(fort);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return Forts;
  }

  public Fort getFortFromFortId(int fort_id)
  {
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FORT, allColumns,
			  MySQLiteHelper.ID+"=?",new String[]{fort_id+""}, null, null, null);
	  // select * from fort where _id=1;
	  Fort fort = null;
	  if(cursor != null)
	  {
		cursor.moveToFirst();
	    fort = cursorToFort(cursor);
	    cursor.close();
	  }
	  return fort;
  }
  private Fort cursorToFort(Cursor cursor) {
    Fort fort = new Fort();
    int i=0;
    fort.setId(cursor.getLong(i++));
    fort.setName(cursor.getString(i++));
    fort.setHeight(cursor.getString(i++));
    fort.setType(cursor.getString(i++));
    fort.setRange(cursor.getString(i++));
    fort.setGrade(cursor.getString(i++));
    fort.setSpots(cursor.getString(i++));
    fort.setWaysToReach(cursor.getString(i++));
    fort.setAccomodation(cursor.getString(i++));
    fort.setFood(cursor.getString(i++));
    fort.setWater(cursor.getString(i++));
    fort.setTimeToReach(cursor.getString(i++));
    fort.setImagePath1(cursor.getString(i++));
    fort.setImagePath2(cursor.getString(i++));
    fort.setImagePath3(cursor.getString(i++));
    fort.setImagePath4(cursor.getString(i++));
    fort.setMapPath(cursor.getString(i++));
    fort.setDistrictId(cursor.getInt(i++));
    return fort;
  }
} 