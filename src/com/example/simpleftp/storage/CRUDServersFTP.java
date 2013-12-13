package com.example.simpleftp.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.simpleftp.entities.ServerFTP;

public class CRUDServersFTP {
	
	private Context context;
	
	public CRUDServersFTP(Context context){
		this.context = context;
	}
	
	//Create
	public long create(ServerFTP serverFTP){
		//Create an instance of DataBaseHelper
		DataBaseHelper dataBaseHelper = new DataBaseHelper(this.context);
		
		//Get SQLite DataBase from DataBase helper
		SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
		
		//Create a Content values to help us to storage data
		ContentValues values = new ContentValues();
		values.put(TableServersFTP.COLUMN_HOST, serverFTP.getHost());
		values.put(TableServersFTP.COLUMN_PORT, serverFTP.getPort());
		values.put(TableServersFTP.COLUMN_USER, serverFTP.getUser());
		values.put(TableServersFTP.COLUMN_PASSWORD, serverFTP.getPassword());
		
		//Finally, insert Server FTP data
		long lastId = db.insert(TableServersFTP.TABLE_NAME, null, values);
		
		//Return the lastId, if and error occurred We return -1
		return lastId;
	}
	
	//Read
	public ServerFTP read(int id){
		return null;
	}
	
	//Update
	public void update(ServerFTP serverFTP){
		
	}
	
	//Delete
	public void delete(ServerFTP serverFTP){
		
	}
}
