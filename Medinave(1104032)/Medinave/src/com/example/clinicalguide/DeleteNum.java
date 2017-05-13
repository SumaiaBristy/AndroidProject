package com.example.clinicalguide;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
public class DeleteNum extends Activity{

	private DbHelper mHelper;
	private SQLiteDatabase dataBase;
	DataHandler handler;
	String phn,message;

	private ArrayList<String> userId = new ArrayList<String>();
	private ArrayList<String> user_fName = new ArrayList<String>();
	private ArrayList<String> user_lName = new ArrayList<String>();

	private ListView userList;
	private AlertDialog.Builder build;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete_num);

		userList = (ListView) findViewById(R.id.List);

		mHelper = new DbHelper(this);
		 handler=new DataHandler(this);
		
		
		//click to update data
		userList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent i = new Intent(getApplicationContext(),
						Update.class);
				i.putExtra("Fname", user_fName.get(arg2));
				i.putExtra("Lname", user_lName.get(arg2));
				i.putExtra("ID", userId.get(arg2));
				i.putExtra("update", true);
				startActivity(i);

			}
		});
		
		//long click to delete data
		userList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {

				build = new AlertDialog.Builder(DeleteNum.this);
				build.setTitle("Delete " + user_fName.get(arg2) + " "
						+ user_lName.get(arg2));
				build.setMessage("Do you want to delete ?");
				build.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {

								Toast.makeText(
										getApplicationContext(),
										user_fName.get(arg2) + " "
												+ user_lName.get(arg2)
												+ " is deleted.", 3000).show();

								dataBase.delete(
										DbHelper.TABLE_NAME,
										DbHelper.KEY_ID + "="
												+ userId.get(arg2), null);
								displayData();
								dialog.cancel();
							}
						});

				build.setNegativeButton("No",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});
				AlertDialog alert = build.create();
				alert.show();

				return true;
			}
		});
	}

	@Override
	protected void onResume() {
		displayData();
		super.onResume();
	}

	/**
	 * displays data from SQLite
	 */
	private void displayData() {
		dataBase = mHelper.getWritableDatabase();
		Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
				+ DbHelper.TABLE_NAME, null);

		userId.clear();
		user_fName.clear();
		user_lName.clear();
		if (mCursor.moveToFirst()) {
			do {
				userId.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_ID)));
				user_fName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_FNAME)));
				user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

			} while (mCursor.moveToNext());
			
			Toast.makeText(getApplicationContext(),"Click once to update record",Toast.LENGTH_LONG).show();	
		}
		else Toast.makeText(getApplicationContext(), "No saved contact available!Set contacts,sms body then shake to send sms",
				Toast.LENGTH_LONG).show();
		DisplayAdapter disadpt = new DisplayAdapter(DeleteNum.this,userId, user_fName, user_lName);
		userList.setAdapter(disadpt);
		mCursor.close();
	}

		
	}

	


