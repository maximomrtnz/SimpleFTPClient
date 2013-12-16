package com.example.simpleftp.activities;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.example.simpleftp.Configuration;
import com.example.simpleftp.R;
import com.example.simpleftp.adapters.FTPServerAdapter;
import com.example.simpleftp.entities.FTPServer;
import com.example.simpleftp.storage.CRUDServersFTP;


import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private ArrayList<FTPServer> ftpServers;
	private FTPServerAdapter ftpServerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		//Load FTPServers List
		loadFTPServesList();
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
	        	  //Get last ftpserver's id from last ftpserver added to database
	        	  long lastId = data.getLongExtra(Configuration.FTP_SERVER_LAST_ID,-1);
	        	  if(lastId!=-1){
	        		  FTPServer ftpServer = new CRUDServersFTP(getApplicationContext()).read(lastId);
	        		  if(ftpServer!=null){
	        			  this.ftpServers.add(ftpServer);
	        			  this.ftpServerAdapter.notifyDataSetChanged();
	        		  }else{
	        			  message = getResources().getString(R.string.an_error_occurred);
	        		  }
	        	  }else{
	        		  message = getResources().getString(R.string.an_error_occurred);
	        	  }
	          }else if(resultCode == Configuration.RESULT_ERROR){
	        	  message = getResources().getString(R.string.an_error_occurred);
	          }
	          
	          //Make a toast notification to show the message
	          Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	      }
	  }
	
	private void loadFTPServesList(){
		//Get ListView from layout
		ListView listView = (ListView)findViewById(R.id.listViewFTPServers);
		
		listView.setEmptyView(findViewById(android.R.id.empty));
		
		//Get FTPServers from DataBase
		this.ftpServers = new CRUDServersFTP(getApplicationContext()).readAll();

		//Create an instance of custom adapter
		this.ftpServerAdapter = new FTPServerAdapter(this.ftpServers, getApplicationContext());
		
		//Set adapter to list view
		listView.setAdapter(this.ftpServerAdapter);
	}
	

}
