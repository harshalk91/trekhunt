package com.example.firstdatabaseexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyCallActivity extends Activity {
private final String vikasKaduskar="+09881422575";
private final String swanandJoshi="+09881422575";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_call);
				
	}
	
	public void onPune1(View v)
	{
		Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 Button b=(Button)findViewById(R.id.button02);
		// TextView t=(TextView)findViewById(R.id.vikas_number);
		 
	    //String text=b.getText().toString();
	  //  final String num=t.getText().toString();
		builder.setTitle("Emeregency Contact");
		builder.setMessage("Do you want to call "+vikasKaduskar);
		builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

		    public void onClick(DialogInterface dialog, int which) {
		        // Do do my action here
		    	Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse(vikasKaduskar));
				startActivity(callIntent);

		        dialog.dismiss();
		    }

		});

		builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        // I do not need any action here you might
		        dialog.dismiss();
		    }
		});

		AlertDialog alert = builder.create();
		alert.show();
		
		
	}
	public void onPune2(View v)
	{
		onPune1(v);
	}
	public void onNashik1(View v)
	{
		onPune1(v);
		
	}
	public void onNashik2(View v)
	{
		onPune1(v);
	}
	


}
