package com.example.firstdatabaseexample;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class FortListActivity extends ListActivity implements OnItemClickListener{
	private int dist_id = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fort_list);
		
	}

	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Bundle b = getIntent().getExtras();
		if((b == null )|| (!b.containsKey("dist_id")))
			finish();
		 dist_id = b.getInt("dist_id");
		filldata(dist_id);
		ListView lv = getListView();
		
		
		
		if(lv != null)
		{
			lv.setOnItemClickListener(this);
		}
	}
	private void filldata(int dist_id) {
		FortsDataSource fortds = new FortsDataSource(this);
		fortds.open();
		Cursor c = fortds.getFortsforDistrict(dist_id);
		if(c == null)
		  finish();
		String[] from = new String[] {MySQLiteHelper.ID,MySQLiteHelper.NAME};
		int[] to = new int[] {R.id._id,R.id.textFortName};
		
		startManagingCursor(c);
		SimpleCursorAdapter sAdapter = new SimpleCursorAdapter(this, R.layout.fort_row, c, from, to) ;
        this.setListAdapter(sAdapter) ;
		
			}
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		int fort_id=0;  
		if(v instanceof LinearLayout)
		  {
			 fort_id = getFortIdFromRowView((LinearLayout) v); 
		  }
		  
		//  Toast.makeText(this, "fort id =>"+ fort_id, Toast.LENGTH_LONG).show();
		  Intent i = new Intent(this,FortViewActivity.class);
		  i.putExtra("fort_id",fort_id);
		  startActivity(i);
		
	}
protected int getFortIdFromRowView(LinearLayout l)
	{
		LinearLayout r = null;
		if(l != null)
		{
			r = l;
			TextView _id = (TextView) r.findViewById(R.id._id);
			String str = _id.getText().toString();
			int fort_id = Integer.parseInt(str);
			return fort_id;
		}
		return 0;
	}



}

