package com.example.firstdatabaseexample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DistrictsDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.DISTRICT_ID,
      MySQLiteHelper.DISTRICT_NAME };

  public DistrictsDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public District createDistrict(int id,String district) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.DISTRICT_ID, id);
    values.put(MySQLiteHelper.DISTRICT_NAME, district);
    long insertId = database.insert(MySQLiteHelper.TABLE_DISTRICT, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_DISTRICT,
        allColumns, MySQLiteHelper.DISTRICT_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    District newDistrict = cursorToDistrict(cursor);
    cursor.close();
    return newDistrict;
  }

/*  public void deleteDistrict(District district) {
    long id = district.getId();
    System.out.println("District deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_DISTRICT, MySQLiteHelper.DISTRICT_ID
        + " = " + id, null);
  }*/

  public Cursor getAllDistrictCursor()
  {
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_DISTRICT,
		        allColumns, null, null, null, null, null);
	  if(cursor == null)
	   return null;
	  return cursor;
  }
  public List<District> getAllDistricts() {
    List<District> Districts = new ArrayList<District>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_DISTRICT,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      District district = cursorToDistrict(cursor);
      Districts.add(district);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return Districts;
  }

  private District cursorToDistrict(Cursor cursor) {
    District district = new District();
    district.setId(cursor.getLong(0));
    district.setDistrict(cursor.getString(1));
    return district;
  }
} 