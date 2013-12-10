package com.example.simpleftp.asynctask;

import com.example.simpleftp.ftpcommands.FTPCommand;

import android.os.AsyncTask;
import android.util.Log;

public class FTPServerRequest extends AsyncTask<Void, Void, Object>{
	
	private FTPCommand ftpCommand;
	
	public FTPServerRequest(FTPCommand command){
		this.ftpCommand = command;
	}

	@Override
	protected Object doInBackground(Void... params) {
		try{
			this.ftpCommand.executeCommand();
		}catch(Exception exception){
			Log.d("Test", exception.getMessage());
		}
		return null;
	}

}
