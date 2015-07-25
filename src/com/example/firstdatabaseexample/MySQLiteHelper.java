package com.example.firstdatabaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_DISTRICT = "district";
  public static final String DISTRICT_ID = "_id";
  public static final String DISTRICT_NAME = "district_name";

  
  public static final String TABLE_FORT = "fort";
  public static final String ID = "_id";
  public static final String NAME = "name";
  public static final String HEIGHT = "height";
  public static final String TYPE = "type";
  public static final String RANGE = "range";
  public static final String GRADE = "grade";
  public static final String SPOTS = "spots";
  public static final String WAYS_TO_REACH = "ways_to_reach";
  public static final String ACCOMODATION = "accomodation";
  public static final String FOOD = "food";
  public static final String WATER = "water";
  public static final String TIME_TO_REACH = "time_to_reach";
  public static final String IMG_PATH_1 = "img_path_1";
  public static final String IMG_PATH_2 = "img_path_2";
  public static final String IMG_PATH_3 = "img_path_3";
  public static final String IMG_PATH_4 = "img_path_4";
  public static final String MAP_PATH = "path";
  public static final String DIST_ID = "dist_id";//foreign key
  



  // Database creation sql statement
  private static final String FORT_DATABASE_CREATE = "create table "
      + TABLE_FORT + "(" + ID
      + " integer primary key, " + NAME
      + " text not null, " + HEIGHT + " text not null, " 
      + TYPE + " text not null, " 
      + RANGE + " text not null, " + 
      GRADE + " text not null, " 
      + SPOTS + " text not null, " 
      + WAYS_TO_REACH + " text not null, " 
      + ACCOMODATION +" text not null, "
      + FOOD +" text not null, "
      + WATER + " text not null, " 
      + TIME_TO_REACH + " text not null, " 
      + IMG_PATH_1 + " text not null, " 
      +IMG_PATH_2 + " text not null, " 
      + IMG_PATH_3 + " text not null, " 
      + IMG_PATH_4 + " text not null, " 
      + MAP_PATH + " text not null, " 
      + DIST_ID + " integer not null,"
      + " FOREIGN KEY ("+DIST_ID+") REFERENCES "+MySQLiteHelper.TABLE_DISTRICT+" ("+MySQLiteHelper.DISTRICT_ID+"))";

  private static final String DATABASE_NAME = "trekhunt.db";
  private static final int DATABASE_VERSION = 1;

  
  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_DISTRICT + "(" + DISTRICT_ID
      + " integer primary key, " + DISTRICT_NAME
      + " text not null);";

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
    database.execSQL(FORT_DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISTRICT);
    onCreate(db);
  }

} 