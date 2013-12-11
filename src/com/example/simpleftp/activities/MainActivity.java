package com.example.simpleftp.activities;

import java.util.Observable;
import java.util.Observer;

import com.example.simpleftp.R;
import com.example.simpleftp.dialogs.AEServerFTPDialog;

import android.os.Bundle;
import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
		  			 // Create an instance of the dialog fragment and show it
		  	        AEServerFTPDialog dialog = new AEServerFTPDialog();
		  	        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
		  			break;
			}
		    return true;
	 } 
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
