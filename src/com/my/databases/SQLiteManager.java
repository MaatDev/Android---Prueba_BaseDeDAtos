package com.my.databases;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.my.classDTO.CevicheDTO;
import com.my.classStatic.TodoSQL;

public class SQLiteManager {
	
	private String TAG = getClass().getSimpleName();
	
	private SQLiteDatabase dbManager;
	private SQLiteHelperCeviche dbHelper;
	private int dbVersion=1;
	
	public SQLiteManager(Context context){
		Log.v(TAG, "Estoy en SQLiteManager: Constructor");
		dbHelper = new SQLiteHelperCeviche(context, TodoSQL.nombreDB, null, TodoSQL.dbVersion);
		dbManager = dbHelper.getWritableDatabase();
	}
	
	public boolean existeTablas(){
		Log.v(TAG, "Estoy en SQLiteManager: existeTablas");
		//select name from sqlite_master where type='table'
		
//		Cursor miCursor = (Cursor) dbManager.query("sqlite_master", null,"type='table'", null, null, null, null);
		Cursor miCursor = (Cursor) dbManager.query("Plato", null, null, null, null, null, null);
		if(miCursor.getCount() >3){
			
			return true;
			
		}
		return false;
		
	}
	
	
	public void actualizarDatos(ArrayList<CevicheDTO> ceviche){
		
		
	}

}
