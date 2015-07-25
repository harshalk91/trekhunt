package com.example.firstdatabaseexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.lang.*;
import java.io.*;

public class Welcome extends Activity {
static final String contact_number="09604848511"; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Resources res = getApplicationContext().getResources();
        TransitionDrawable transition = (TransitionDrawable) res.getDrawable(R.drawable.expand_collapse);
        ImageView image = (ImageView) findViewById(R.id.toggle_image);
        image.setImageDrawable(transition);
 
        transition.startTransition(3000);
        
	}

		
    public void onForward(View v)
    {
    	Intent i=new Intent(this, TestDatabaseActivity.class);
    	startActivity(i);
    	//finish();
    }
    public void onHelp(View v)
    {
    	
   	 Intent intent = new Intent(this,GridViewExampleActivity.class);
   	 startActivity(intent);
    }
    public void onFeedback(View V)
	{
		Intent intent = new Intent(this,FeedbackActivity.class);
	   	 startActivity(intent);
	}
    public void onCall(View v)
    {
    	/*Intent callIntent = new Intent(Intent.ACTION_CALL);
    	callIntent.setData(Uri.parse("tel:9822172798"));
    	startActivity(callIntent);*/
    	Intent intent = new Intent(this,EmergencyCallActivity.class);
	   	startActivity(intent);
    }
    
	public void onInform(View v)
    {
	  String details="Designed & Developed by " +
    		"\nHarshal S Kulkarni " +
    		"\nPune" +
    		"\nIndia" +
    		"\ncontact Number:"+contact_number;
	  	  
	  
	//	Toast.makeText(getApplicationContext(), details, Toast.LENGTH_LONG).show();
		//Intent i2=new Intent(this,AboutUsActivity.class);
    	//startActivity(i2);
    AlertDialog ad = new AlertDialog.Builder(this).create();  
    ad.setCancelable(false); // This blocks the 'BACK' button  
    ad.setMessage(details);  
    ad.setButton("OK", new DialogInterface.OnClickListener() {  
        @Override  
        public void onClick(DialogInterface dialog, int which) {  
            dialog.dismiss();                      
        }  
    });  
    ad.show(); 
    }
  
	
  
}
