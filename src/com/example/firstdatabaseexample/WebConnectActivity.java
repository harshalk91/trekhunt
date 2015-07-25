package com.example.firstdatabaseexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class WebConnectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_connect);
	}
	
public void onChakram(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chakramhikers.com"));
		startActivity(browserIntent);

   }
   public void onExplorer(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.explorers.com"));
		startActivity(browserIntent);

   }
   public void onGtc(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.giridarshan.com"));
		startActivity(browserIntent);

   }
   public void onOffbeat(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.offbeatsahyadri.com"));
		startActivity(browserIntent);

   }
   public void onTrekMates(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trekmatesindia.com"));
		startActivity(browserIntent);

   }
   public void onTrekdi(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.Trekdi.com"));
		startActivity(browserIntent);

   }
   public void onYuvashakti(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yuvashakti.com"));
		startActivity(browserIntent);

   }
   public void onTrekshitiz(View v)
   {
	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trekshitiz.com"));
		startActivity(browserIntent);

   }
   
}
