package com.example.simpleftp.activities;

import java.util.Observable;
import java.util.Observer;

import com.example.simpleftp.Configuration;
import com.example.simpleftp.R;


import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Observer{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	  public boolean onOptionsItemSelected(MenuItem item) {
		  	switch (item.getItemId()) {
		  		case R.id.action_add_server:
		  			// Create an instance of CRUDServerFTPActivity
		  	        Intent intent = new Intent(MainActivity.this, CRUDServerFTPActivity.class);
		  	        startActivityForResult(intent, Configuration.REQUEST_CODE_CRUDSERVERFTP);
		  	        break;
			}
		    return true;
	 } 
	
	  
	  @Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  //We define a message variable which we are going to use it to show it inside 
		  //a Toast notification
		  String message = "";
		  
	      //Check which request we're responding to
	      if (requestCode == Configuration.REQUEST_CODE_CRUDSERVERFTP) {
	          // Make sure the request was successful
	          if (resultCode == RESULT_OK) {
	             message = getResources().getString(R.string.new_serverftp_was_added);
	          }else if(resultCode == Configuration.RESULT_ERROR){
	        	  message = getResources().getString(R.string.an_error_occurred);
	          }
	          
	          //Make a toast notification to show the message
	          Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	      }
	  }
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
