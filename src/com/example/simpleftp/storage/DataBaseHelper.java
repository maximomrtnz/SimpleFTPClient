package com.example.simpleftp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.simpleftp.*;

public class DataBaseHelper extends SQLiteOpenHelper{
	

	
	public DataBaseHelper(Context context) {
		super(context, Configuration.DATABASE_NAME, null, Configuration.DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// creating required tables
        db.execSQL(TableServersFTP.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 // on upgrade drop older tables
        db.execSQL(TableServersFTP.DROP_TABE);
 
        // create new tables
        onCreate(db);
	}

}
