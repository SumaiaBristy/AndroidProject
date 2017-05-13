package com.example.clinicalguide;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler1 extends SQLiteOpenHelper{
	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "contactsManager";
	public static final String TABLE_CONTACTS = "contacts";
	public static final String CONTACT_ID = "id";
	public static final String CONTACT_NAME = "name";
	public static final String CONTACT_PHONE = "phone";
	
	public DataHandler1(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	 @Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);	 
	        // Create tables again
	        onCreate(db);
		}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("+ CONTACT_ID + 
				" INTEGER PRIMARY KEY AUTOINCREMENT," + CONTACT_NAME + " TEXT,"+ CONTACT_PHONE + " TEXT" + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
	}
	
	void addContact(String name,String phone)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		 
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, name);
        values.put(CONTACT_PHONE,phone);
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
	}
	
	
    
    Cursor getAllContact()
    {
    	String selectQuery = "SELECT *  FROM " + TABLE_CONTACTS;	 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //db.close();
    	return cursor;
    }

    void deleteContact(int id)
	{
		String[] selections={String.valueOf(id)};
		SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, CONTACT_ID + " = ?",selections);
        db.close();
	}
	
    
}
