package com.example.simpleftp.storage;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.simpleftp.entities.FTPServer;

public class CRUDServersFTP {
	
	private Context context;
	
	public CRUDServersFTP(Context context){
		this.context = context;
	}
	
	//Create
	public long create(FTPServer serverFTP){
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
		
		//Close Data Base connection
		dataBaseHelper.close();
		
		//Return the lastId, if and error occurred We return -1
		return lastId;
	}
	
	//Read
	public FTPServer read(long id){
		//Create an instance of DataBaseHelper
		DataBaseHelper dataBaseHelper = new DataBaseHelper(this.context);
						
		//Get SQLite DataBase from DataBase helper
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
				
		//Return Query result inside a Cursor 
		Cursor c = db.rawQuery(TableServersFTP.QUERY_GET_SINGLE_ITEM+id, null);
		
		FTPServer ftpServer = null;
		
		if (c != null){
	        c.moveToFirst();
	        ftpServer = new FTPServer();
	        ftpServer.setId(c.getInt(c.getColumnIndex(TableServersFTP.COLUMN_ID)));
	        ftpServer.setHost(c.getString(c.getColumnIndex(TableServersFTP.COLUMN_HOST)));
	        ftpServer.setPort(c.getInt(c.getColumnIndex(TableServersFTP.COLUMN_PORT)));
	        ftpServer.setUser(c.getString(c.getColumnIndex(TableServersFTP.COLUMN_USER)));
	        ftpServer.setPassword(c.getString(c.getColumnIndex(TableServersFTP.COLUMN_PASSWORD)));
		}
	 
	    return ftpServer;
			 
	}
	
	//Update
	public void update(FTPServer serverFTP){
		
	}
	
	//Delete
	public void delete(FTPServer serverFTP){
		
	}
	
	//Read All FTPServers
	public ArrayList<FTPServer> readAll(){
		ArrayList<FTPServer> ftpServers = new ArrayList<FTPServer>();
		
		//Create an instance of DataBaseHelper
		DataBaseHelper dataBaseHelper = new DataBaseHelper(this.context);
				
		//Get SQLite DataBase from DataBase helper
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
		
		//Return Query result inside a Cursor 
	    Cursor c = db.rawQuery(TableServersFTP.QUERY_GET_ALL, null);
	 
	    // Looping through all rows and adding to list
	    if (c.moveToFirst()) {
	        do {
	            FTPServer ftpServer = new FTPServer();
	            ftpServer.setId(c.getInt((c.getColumnIndex(TableServersFTP.COLUMN_ID))));
	            ftpServer.setHost((c.getString(c.getColumnIndex(TableServersFTP.COLUMN_HOST))));
	            ftpServer.setPort((c.getInt(c.getColumnIndex(TableServersFTP.COLUMN_PORT))));
	            ftpServer.setUser((c.getString(c.getColumnIndex(TableServersFTP.COLUMN_USER))));
	            ftpServer.setUser((c.getString(c.getColumnIndex(TableServersFTP.COLUMN_PASSWORD))));
	            //Adding to FTPServers's list
	            ftpServers.add(ftpServer);
	        } while (c.moveToNext());
	    }
	    //Close cursor
	    c.close();
	    
	    //Close Data Base Connection
	    dataBaseHelper.close();
	    
	    return ftpServers;
	}
	
}
