package com.example.simpleftp.activities;

import com.example.simpleftp.Configuration;
import com.example.simpleftp.R;
import com.example.simpleftp.entities.ServerFTP;
import com.example.simpleftp.storage.CRUDServersFTP;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CRUDServerFTPActivity extends ActionBarActivity{
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crudserverftp);	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crudserverftp, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
	  		case R.id.action_crudserverftp_save:
	  			create();
	  	        break;
	  		case R.id.action_crudserverftp_delete:
	  			delete();
	  			break;    
	  		case R.id.action_crudserverftp_cancel:
	  			setResult(RESULT_CANCELED);
	  			finish();
	  	        break;    
		}
		return true;
	}
	
	private void create(){
		//Get Information from Activity's layout
		EditText serverFTPHost = (EditText)findViewById(R.id.editTextServerFTPHost);
		EditText serverFTPPort = (EditText)findViewById(R.id.editTextServerFTPPort);
		EditText serverFTPUser = (EditText)findViewById(R.id.editTextServerFTPUser);
		EditText serverFTPPassword = (EditText)findViewById(R.id.editTextServerFTPPassword);
		
		//Create an instance of ServerFTP Class, and then set date
		ServerFTP serverFTP = new ServerFTP();
		serverFTP.setHost(serverFTPHost.getText().toString());
		serverFTP.setPort(Integer.parseInt(serverFTPPort.getText().toString()));
		serverFTP.setUser(serverFTPUser.getText().toString());
		serverFTP.setPassword(serverFTPPassword.getText().toString());
		
		//Save Server FTP 
		long lastId = new CRUDServersFTP(getApplicationContext()).create(serverFTP);
				
		//Checking for errors
		if(lastId != -1){
			//Return result from caller activity
			Intent intent = getIntent();
			intent.putExtra("lastId", lastId);
			setResult(RESULT_OK, intent);
		}else{
			//An error occurred, so return RESULT_CANCELED
			setResult(Configuration.RESULT_ERROR);
		}
		
		//Finish the activity to return to the caller activity
		finish();
	}
	
	private void update(){
		
	}
	
	private void read(int serverFTPId){
		
	}
	
	private void delete(){
		
	}
	
	
}
