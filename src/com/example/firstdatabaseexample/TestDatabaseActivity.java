package com.example.firstdatabaseexample;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class TestDatabaseActivity extends ListActivity implements OnItemClickListener{
  private DistrictsDataSource datasource;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_database);

    datasource = new DistrictsDataSource(this);
    datasource.open();
    
    
 
  
    
  
  }

  // Will be called via the onClick attribute
  // of the buttons in main.xml
/*  public void onClick(View view) {
    @SuppressWarnings("unchecked")
    ArrayAdapter<District> adapter = (ArrayAdapter<District>) getListAdapter();
    District district = null;
    switch (view.getId()) {
    
    case R.id.delete:
      if (getListAdapter().getCount() > 0) {
        district = (District) getListAdapter().getItem(0);
        datasource.deleteDistrict(district);
        adapter.remove(district);
      }
      break;
    }
    adapter.notifyDataSetChanged();
  }*/

  @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ListView lv = getListView();
		if(lv != null)
		{
			lv.setOnItemClickListener(this);
		}
	}
  @Override
  protected void onResume() {
    datasource.open();
    super.onResume();
    filldata();
  }

  private void filldata() {
	  // List<District> values = datasource.getAllDistricts();
	    Cursor districtCursor = null;
	    // Save the new comment to the database
	    String[] from = new String[]{MySQLiteHelper.DISTRICT_ID,MySQLiteHelper.DISTRICT_NAME};
	    int[] to = new int[] {R.id._id,R.id.textDistrictName};
	    // Use the SimpleCursorAdapter to show the
	    // elements in a ListView
	    Cursor oldCursor = null;
	    if(districtCursor != null)
	    {
	    	oldCursor = districtCursor;
	    	stopManagingCursor(oldCursor);
	    }
	    districtCursor = datasource.getAllDistrictCursor();
	    if(districtCursor != null)
	    {
	    	startManagingCursor(districtCursor);
	    	SimpleCursorAdapter sAdapter = new SimpleCursorAdapter(this, R.layout.district_row, districtCursor, from, to) ;
	        this.setListAdapter(sAdapter) ;
	    }
	
}

@Override
  protected void onPause() {
    datasource.close();
    super.onPause();
  }

@Override
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	int dist_id = 0; 
	  if(v instanceof LinearLayout)
	  {
		 dist_id = getDistIdFromRowView((LinearLayout) v); 
	  }
	  
	  if(dist_id == 0)
		  return;
	  //Toast.makeText(this, "District id =>"+ dist_id, Toast.LENGTH_LONG).show();
	  Intent i = new Intent(this,FortListActivity.class);
	  i.putExtra("dist_id",dist_id);
	  startActivity(i);
	
}

protected int getDistIdFromRowView(LinearLayout l)
{
	LinearLayout r = null;
	if(l != null)
	{
		r = l;
		TextView _id = (TextView) r.findViewById(R.id._id);
		String str = _id.getText().toString();
		int dist_id = Integer.parseInt(str);
		return dist_id;
	}
	return 0;
}

} 