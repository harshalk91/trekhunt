package com.example.firstdatabaseexample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
 
public class FeedbackActivity extends Activity {
 
static Button mButton;
static EditText mName, mEmail, mContact, mRate;
static TextView mText;
static String mNm, mEm,mCn,mRt;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
       for(int i=0;i<1;i++)
       {
       Toast toast=Toast.makeText(getApplicationContext(), "Feedback Form will send SMS or E-mail to Development team",
				Toast.LENGTH_SHORT);  
       LinearLayout toastLayout = (LinearLayout) toast.getView();
       TextView toastTV = (TextView) toastLayout.getChildAt(0);
       toastTV.setTextSize(20);
       toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
       toast.show();
       }
       
       
        
       mButton = (Button)findViewById(R.id.button1);
        
      mButton.setOnClickListener(new OnClickListener() {

    	
    	  public void onClick(View v) {

    		                
    		      		// write on SD card file data in the text box
    		try {
    			 mName   = (EditText)findViewById(R.id.editText1);
    			 mName.setSelection(mName.getText().length());
    	         mContact   = (EditText)findViewById(R.id.editText2);
    	         mEmail   = (EditText)findViewById(R.id.EditText01);
    	         mRate   = (EditText)findViewById(R.id.EditText02);
    	         
    	         
    	        File myFile = new File("/sdcard/feedbackData.txt");
    			myFile.createNewFile();
    			FileOutputStream fOut = new FileOutputStream(myFile);
    			OutputStreamWriter myOutWriter = 
    									new OutputStreamWriter(fOut);
    			mNm=mName.getText().toString();
    			mEm=mEmail.getText().toString();
    			mCn=mContact.getText().toString();
    			mRt=mRate.getText().toString();
    			if(mNm.equals("") || mEm.equals("") || mRt.equals(""))
   	         {
   	        	 String st="Name, Email & Rating is required.";
   	        	 Toast.makeText(getApplicationContext(), st, Toast.LENGTH_LONG).show();
   	         }
   		
   	         else
   	         {
   	        	
   	        	 
   	        	String sms="Feedback from "+mNm+"\nEmail id: "+mEm+"\nContact Number: "+mCn+"\nRating:"+mRt;
   	        	SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(Welcome.contact_number, null, sms, null, null);
				Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				
				myOutWriter.write(mNm+"\n");
    			myOutWriter.write(mEm+"\n");
    			myOutWriter.write(mCn+"\n");
    			myOutWriter.write(mRt+"\n**********");
    			
    			myOutWriter.close();
    			fOut.close();
    			Toast.makeText(getBaseContext(),
    					"Done writing SD 'feedbackData.txt'",
    					Toast.LENGTH_SHORT).show();
    			
   	          String to = "harshalk.91@gmail.com";
   	          String subject=mNm+" TrekHunt Feedback";
   	     //     String attachment=Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + myFile;
   	          Intent email = new Intent(Intent.ACTION_SEND);
  			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
  			  email.putExtra(Intent.EXTRA_TEXT, to);
  			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
  			  email.putExtra(Intent.EXTRA_TEXT, sms);
  			  //email.putExtra(Intent.EXTRA_STREAM, attachment);
  			  email.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://" + myFile));


  			
  			  //need this to prompts email client only
  			  email.setType("message/rfc822");
  			  
  			  startActivity(Intent.createChooser(email, "Choose an Email client :"));
   	        	 
    			
   	         }
    		} catch (Exception e) {
    			Toast.makeText(getBaseContext(), e.getMessage(),
    					Toast.LENGTH_SHORT).show();
    		}
    		   
    	}// onClick
    	}); // btnWriteSDFile
        
      /*  mButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
        try{
            mName   = (EditText)findViewById(R.id.editText1);
            mContact   = (EditText)findViewById(R.id.editText2);
            mEmail   = (EditText)findViewById(R.id.EditText01);
            mRate   = (EditText)findViewById(R.id.EditText02);
            mNm=mName.getText().toString();
            mText = (TextView)findViewById(R.id.textView1);
            mText.setText("Welcome "+mName.getText().toString()+"!");
          //  mText.setText("Contact "+mContact.getText().toString()+"!");
         //   mText.setText("Email "+mEmail.getText().toString()+"!");
          //  mText.setText("Rating "+mRate.getText().toString()+"!");
           
          	  File file=new File("assets\\FeedbackData.txt");
          	  FileWriter f1=new FileWriter(file);
          	  f1.write(mNm);
          	  f1.close();
          	Toast.makeText(getApplicationContext(), mNm, Toast.LENGTH_LONG).show();
          }catch(Exception e)
          {
          	e.printStackTrace();
          	
          }
            
          }
        });*/
        
       
    }
    
}