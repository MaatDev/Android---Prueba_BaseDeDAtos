package com.my.databases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.my.classStatic.TodoSQL;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


//Fuente: http://www.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/

public class SQLiteHelperCeviche2 extends SQLiteOpenHelper{

	private final Context myContext;
	private SQLiteDatabase miDB;
		
	public SQLiteHelperCeviche2(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.myContext = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}	
	
	
	public SQLiteDatabase getMiDB() {
		return miDB;
	}

	public void setMiDB(SQLiteDatabase miDB) {
		this.miDB = miDB;
	}

	public void crearDataBase() throws IOException{
		
		boolean existeDB = verificarDB();
		
		if(existeDB){
			//Si existe, no debe hacer nada
		}else{
			//Se crea automáticamente una base de datos vacío
			this.getWritableDatabase();
			
			try{
				
				copiarDB();
				
			}catch(IOException e){
				
				throw new Error("Error al copiar la base de datos");
				
			}
			
		}
		
		
	}

	private boolean verificarDB() {
		SQLiteDatabase verDB = null;
		
		try{
			
			String miRuta = TodoSQL.dbPath+TodoSQL.nombreDB;
			verDB = SQLiteDatabase.openDatabase(miRuta, null,SQLiteDatabase.OPEN_READWRITE);
			
		}catch(SQLiteException e){
			
			//No existe la base de datos
			
		}
		
		if(verDB != null){
			
			verDB.close();
			return true;
			
		}else{
			
			return false;
			
		}	
		
//		return verDB != null ? true : false;		
		
	}
	
	public void copiarDB() throws IOException{
		
		//Abrir la base de datos local como flujo de entrada
		InputStream miInput = this.myContext.getAssets().open(TodoSQL.nombreDB);
		
		//Ruta de la base de datos vacio creado
		String salidaDelArchivo = TodoSQL.dbPath+TodoSQL.nombreDB;
		
		//Abrir base de datos  como flujo de salida
		OutputStream miOutput = new FileOutputStream(salidaDelArchivo);
		
		//Transferencia de bytes desdel input hacia output
		byte[] buffer = new byte[1024];
		int longitud;
		while( (longitud = miInput.read(buffer)) > 0 ){
			
			miOutput.write(buffer, 0, longitud);
			
		}
		
		//Cerrar los flujos
		miOutput.flush();
		miOutput.close();
		miInput.close();
		
	}
	
	public void abrirDB() throws SQLException{
		
		//Abrir la base de datos
		String miRuta = TodoSQL.dbPath + TodoSQL.nombreDB;
		this.miDB = SQLiteDatabase.openDatabase(miRuta, null, SQLiteDatabase.OPEN_READWRITE);		
	}
	
	@Override
	public synchronized void close(){
		
		if(this.miDB != null){
			
			this.miDB.close();
			
		}
		
		super.close();
		
	}
	
	

}
