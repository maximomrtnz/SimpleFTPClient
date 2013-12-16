package com.example.simpleftp.storage;

public class TableServersFTP {
	
	public static String TABLE_NAME = "ServersFTP";
	public static String COLUMN_ID = "Id";
	public static String COLUMN_HOST = "Host";
	public static String COLUMN_PORT = "Port";
	public static String COLUMN_USER = "User";
	public static String COLUMN_PASSWORD = "Password";
	
	
    public static String CREATE_TABLE = "CREATE TABLE "
		            + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
		            + COLUMN_HOST + " TEXT,"
		            + COLUMN_PORT + " INTEGER,"
		            + COLUMN_USER + " TEXT,"
		            + COLUMN_PASSWORD + " TEXT" + ")";
    
    public static String DROP_TABE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static String QUERY_GET_ALL = "SELECT * FROM "+TABLE_NAME;
    
    public static String QUERY_GET_SINGLE_ITEM = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+" = ";
}
