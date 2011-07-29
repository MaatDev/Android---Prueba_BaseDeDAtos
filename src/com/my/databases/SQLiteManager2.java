package com.my.databases;

import java.io.IOException;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.my.classDTO.CevicheDTO;
import com.my.classDTO.Fuente_ArchivoDTO;
import com.my.classDTO.ImagenPrimDTO;
import com.my.classDTO.ImagenSecDTO;
import com.my.classDTO.IngredienteDTO;
import com.my.classDTO.RatingDTO;
import com.my.classDTO.RegionDTO;
import com.my.classDTO.TipDTO;
import com.my.classDTO.TipoDTO;
import com.my.classDTO.VideoDTO;
import com.my.classStatic.TodoSQL;

public class SQLiteManager2 {
	
	private String TAG = getClass().getSimpleName();
	
	private SQLiteDatabase dbManager;
	private SQLiteHelperCeviche2 dbHelper;
	private int dbVersion=1;
	
	public SQLiteManager2(Context context){
		Log.v(TAG, "Estoy en SQLiteManager: Constructor");
		
		this.dbHelper = new SQLiteHelperCeviche2(context, TodoSQL.nombreDB, null, TodoSQL.dbVersion);
		try {
			this.dbHelper.crearDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Error("No se pudo crear la base de datos");
		
		}
		
		try{
			
			this.dbHelper.abrirDB();
			
		}catch(SQLException sqle){
			
			throw sqle;
			
		}
		
		
		this.dbManager = this.dbHelper.getMiDB();
	}
	
	public boolean existeTablas(){
		Log.v(TAG, "Estoy en SQLiteManager: existeTablas");
		//select name from sqlite_master where type='table'
		
//		Cursor miCursor = (Cursor) dbManager.query("sqlite_master", null,"type='table'", null, null, null, null);
		Cursor miCursor = (Cursor) this.dbManager.query("Plato", null, null, null, null, null, null);
		if(miCursor.getCount() >3){
			
			return true;
			
		}
		return false;
		
	}
	
	public void insertarDatos(ArrayList<CevicheDTO> ceviches){
		Log.v(TAG, "Estoy en SQLiteManager: insertarDatos ");
		
		for(CevicheDTO ceviche: ceviches){
	
			//Entidades fuertes
//			insertarTipo(ceviche.getTipo());
			insertarRating(ceviche.getRating());
//			insertarRegion(ceviche.getRegion());
			insertarTip(ceviche.getTip());
			
			//...
			Fuente_ArchivoDTO f = new Fuente_ArchivoDTO();
			f.setCod_fuente(2); f.setDesc_fuente("ho");
			//...
			
//			insertarFuente(f);
			
			for(IngredienteDTO ingre:ceviche.getIngredientes()){
				insertarIngrediente(ingre);				
			}
			
			//Entidades débiles
			insertarImagenPrimario(ceviche.getImg_prim());
			insertarPlato(ceviche);
			insertarVideo(ceviche.getVideo());

			for(ImagenSecDTO img: ceviche.getImgs_sec()){
				insertarImagenSecundario(img);
			}	
			
			//Asociativa
			for(IngredienteDTO ingre: ceviche.getIngredientes()){
				insertarAscPlatoIngrediente(ingre);
			}
			
		}
				
	}
	
	
	public void actualizarDatos(ArrayList<CevicheDTO> ceviches){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarDatos");
		for(CevicheDTO ceviche: ceviches){
			
			//Entidades fuertes
//			actualizarTipo(ceviche.getTipo());
			actualizarRating(ceviche.getRating());
//			actualizarRegion(ceviche.getRegion());
			actualizarTip(ceviche.getTip());
			
			//...
			Fuente_ArchivoDTO f = new Fuente_ArchivoDTO();
			f.setCod_fuente(2); f.setDesc_fuente("ho");
			//...
			
//			actualizarFuente(f);
			
			for(IngredienteDTO ingre:ceviche.getIngredientes()){
				actualizarIngrediente(ingre);				
			}
			
			//Entidades débiles
			actualizarImagenPrimario(ceviche.getImg_prim());
			actualizarPlato(ceviche);
			actualizarVideo(ceviche.getVideo());

			for(ImagenSecDTO img: ceviche.getImgs_sec()){
				actualizarImagenSecundario(img);
			}	
			
			//Asociativa
			for(IngredienteDTO ingre: ceviche.getIngredientes()){
				actualizarAscPlatoIngrediente(ingre);
			}
			
		}		
	}
	
	public void eliminarDatos(ArrayList<CevicheDTO> ceviches){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarDatos");
		
		for(CevicheDTO cev: ceviches){
			
			
			//Asociativa
			
			eliminarAscPlatoIngrediente(cev.getCod_plato());
			
			
			//Entidad Débil
			
			eliminarImagenPrimario(cev.getImg_prim().getCod_img_prim());
			eliminarImagenSecundario(cev.getCod_plato());
			eliminarVideo(cev.getVideo().getCod_plato());
			eliminarPlato(cev.getCod_plato());
			
			//Entidad Fuerte
			
//			eliminarTipo(cev.getTipo().getCod_tipo());
			eliminarRating(cev.getRating().getCod_rating());
//			eliminarRegion(cev.getRegion().getCod_region());
			eliminarTip(cev.getTip().getCot_tip());
//			eliminarFuente(cev.getImg_prim().getFuente().getCod_fuente());
//			eliminarIngrediente(cev.getIngredientes().get(0).getCod_ingrediente());
			
		}
		
	}
	
	
	//funciones secundarias..................................................
	
	public void insertarTipo(TipoDTO tipo){
		Log.v(TAG, "Estoy en SQLiteManager: insertarTipo");
		
		//Clase para agregar los valores a insertar
    	ContentValues cv = new ContentValues();
    	cv.put(TipoDTO.campo_cod_tipo, tipo.getCod_tipo());
    	cv.put(TipoDTO.campo_desc_tipo,  tipo.getDesc_tipo());
    	this.dbManager.insert(TodoSQL.tabla_tipo, null, cv);
				
	}
	
	public void insertarRating(RatingDTO rating){
		Log.v(TAG, "Estoy en SQLiteManager: insertarRating");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(RatingDTO.campo_cod_rating, rating.getCod_rating());
		cv.put(RatingDTO.campo_num_estrellas, rating.getNum_estrellas());
		cv.put(RatingDTO.campo_desc_comentario, rating.getDesc_comentario());
		this.dbManager.insert(TodoSQL.tabla_rating, null, cv);
		
	}
	
	public void insertarRegion(RegionDTO region){
		Log.v(TAG, "Estoy en SQLiteManager: insertarRegion");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(RegionDTO.campo_cod_region, region.getCod_region());
		cv.put(RegionDTO.campo_desc_region, region.getDesc_region());
		this.dbManager.insert(TodoSQL.tabla_region, null, cv);
		
	}
	
	public void insertarTip(TipDTO tip){
		Log.v(TAG, "Estoy en SQLiteManager: insertarTip");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(TipDTO.campo_cod_tip, tip.getCot_tip());
		cv.put(TipDTO.campo_desc_tip, tip.getDesc_tip());
		this.dbManager.insert(TodoSQL.tabla_tip, null, cv);
		
	}
	
	public void insertarFuente(Fuente_ArchivoDTO fuente){
		Log.v(TAG, "Estoy en SQLiteManager: insertarFuente");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(Fuente_ArchivoDTO.campo_cod_fuente, fuente.getCod_fuente());
		cv.put(Fuente_ArchivoDTO.campo_desc_fuente, fuente.getDesc_fuente());
		this.dbManager.insert(TodoSQL.tabla_fuente_archivo, null, cv);
		
	}
	
	public void insertarIngrediente(IngredienteDTO ingre){
		Log.v(TAG, "Estoy en SQLiteManager: insertarIngrediente");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(IngredienteDTO.campo_cod_ingrediente, ingre.getCod_ingrediente());
		cv.put(IngredienteDTO.campo_desc_ingrediente, ingre.getDesc_ingrediente());
		this.dbManager.insert(TodoSQL.tabla_ingrediente, null, cv);
		
	}
	
	public void insertarImagenPrimario(ImagenPrimDTO img){
		Log.v(TAG, "Estoy en SQLiteManager: insertarImagenPrimario");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(ImagenPrimDTO.campo_cod_img_prim, img.getCod_img_prim());
		cv.put(ImagenPrimDTO.campo_cod_fuente, img.getFuente().getCod_fuente());
		cv.put(ImagenPrimDTO.campo_url_external_img, img.getUrl_external_img());
		cv.put(ImagenPrimDTO.campo_url_local_img, img.getUrl_local_img());
		this.dbManager.insert(TodoSQL.tabla_imagen_primario, null, cv);		
		
	}
	
	public void insertarPlato(CevicheDTO ceviche){
		Log.v(TAG, "Estoy en SQLiteManager: insertarPlato");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(CevicheDTO.campo_cod_plato, ceviche.getCod_plato());
		cv.put(CevicheDTO.campo_nombre, ceviche.getNombre());
		cv.put(CevicheDTO.campo_cod_img_prim, ceviche.getImg_prim().getCod_img_prim());
		cv.put(CevicheDTO.campo_cod_rating, ceviche.getRating().getCod_rating());
		cv.put(CevicheDTO.campo_cod_region, ceviche.getRegion().getCod_region());
		cv.put(CevicheDTO.campo_cod_tip, ceviche.getTip().getCot_tip());
		cv.put(CevicheDTO.campo_cod_tipo, ceviche.getTipo().getCod_tipo());
		this.dbManager.insert(TodoSQL.tabla_plato, null, cv);
		
	}
	
	public void insertarVideo(VideoDTO video){
		Log.v(TAG, "Estoy en SQLiteManager: insertarVideo");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(VideoDTO.campo_cod_video, video.getCod_video());
		cv.put(VideoDTO.campo_cod_plato, video.getCod_plato());
		cv.put(VideoDTO.campo_cod_fuente, video.getFuente().getCod_fuente());
		cv.put(VideoDTO.campo_url_external_video, video.getUrl_external_video());
		cv.put(VideoDTO.campo_url_local_video, video.getUrl_local_video());
		this.dbManager.insert(TodoSQL.tabla_video, null, cv);
		
	}
	
	public void insertarImagenSecundario(ImagenSecDTO img){
		Log.v(TAG, "Estoy en SQLiteManager: insertarImagenSecundario");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(ImagenSecDTO.campo_cod_img_sec, img.getCod_img_sec());
		cv.put(ImagenSecDTO.campo_cod_plato, img.getCod_plato());
		cv.put(ImagenSecDTO.campo_cod_fuente, img.getFuente().getCod_fuente());
		cv.put(ImagenSecDTO.campo_url_external_img, img.getUrl_external_img());
		cv.put(ImagenSecDTO.campo_url_local_img, img.getUrl_local_img());
		this.dbManager.insert(TodoSQL.tabla_image_secundario, null, cv);
				
	}
	
	public void insertarAscPlatoIngrediente(IngredienteDTO ingre){
		Log.v(TAG, "Estoy en SQLiteManager: insertarAscPlatoIngrediente");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
		cv.put(IngredienteDTO.campo_asc_cod_ingrediente, ingre.getCod_ingrediente());
		cv.put(IngredienteDTO.campo_asc_cod_plato, ingre.getCod_plato());
		cv.put(IngredienteDTO.campo_asc_cantidad, ingre.getCantidad());
		cv.put(IngredienteDTO.campo_asc_unidad, ingre.getUnidad());
		this.dbManager.insert(TodoSQL.tabla_asc_plato_ingrediente, null, cv);
		
	}
	
	public void eliminarTipo(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarTipo");
		this.dbManager.delete(TodoSQL.tabla_tipo, "_id="+codigo, null);
		
	}
	
	public void eliminarRating(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarRating");
		this.dbManager.delete(TodoSQL.tabla_rating, "_id="+codigo, null);
		
	}
	
	public void eliminarRegion(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarRegion");
		this.dbManager.delete(TodoSQL.tabla_region, "_id="+codigo, null);
		
	}
	
	public void eliminarTip(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarTip");
		this.dbManager.delete(TodoSQL.tabla_tip, "_id="+codigo, null);
		
	}
	
	public void eliminarFuente(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarFuente");
		this.dbManager.delete(TodoSQL.tabla_fuente_archivo, "_id="+codigo, null);
		
	}
	
	public void eliminarIngrediente(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarIngrediente");
		this.dbManager.delete(TodoSQL.tabla_ingrediente, "_id="+codigo, null);
		
	}
	
	public void eliminarImagenPrimario(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarImagenPrimario");
		this.dbManager.delete(TodoSQL.tabla_imagen_primario, "_id="+codigo, null);
		
	}
	
	public void eliminarPlato(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarPlato");
		this.dbManager.delete(TodoSQL.tabla_plato, "_id="+codigo, null);
		
	}
	
	public void eliminarVideo(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarVideo");
		this.dbManager.delete(TodoSQL.tabla_video, "cod_plato="+codigo, null);
		
	}
	
	public void eliminarImagenSecundario(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarImagenSecundario");
		this.dbManager.delete(TodoSQL.tabla_image_secundario, "cod_plato="+codigo, null);
		
	}
	
	public void eliminarAscPlatoIngrediente(int codigo){
		Log.v(TAG, "Estoy en SQLiteManager: eliminarAscPlatoIngrediente");
		this.dbManager.delete(TodoSQL.tabla_asc_plato_ingrediente, "cod_plato="+codigo, null);
		
	}
	
	public void actualizarTipo(TipoDTO tipo){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarTipo");
		
		//Clase para agregar los valores a actualizar
    	ContentValues cv = new ContentValues();
//    	cv.put(TipoDTO.campo_cod_tipo, tipo.getCod_tipo());
    	cv.put(TipoDTO.campo_desc_tipo,  tipo.getDesc_tipo());
    	this.dbManager.update(TodoSQL.tabla_tipo, cv, "_id="+tipo.getCod_tipo(), null);
    					
	}
	
	public void actualizarRating(RatingDTO rating){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarrRating");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(RatingDTO.campo_cod_rating, rating.getCod_rating());
		cv.put(RatingDTO.campo_num_estrellas, rating.getNum_estrellas());
		cv.put(RatingDTO.campo_desc_comentario, rating.getDesc_comentario());
		this.dbManager.update(TodoSQL.tabla_rating, cv, "_id="+rating.getCod_rating(), null);
		
	}
	
	public void actualizarRegion(RegionDTO region){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarRegion");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(RegionDTO.campo_cod_region, region.getCod_region());
		cv.put(RegionDTO.campo_desc_region, region.getDesc_region());
		this.dbManager.update(TodoSQL.tabla_region, cv, "_id="+region.getCod_region(), null);
		
	}
	
	public void actualizarTip(TipDTO tip){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarTip");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(TipDTO.campo_cod_tip, tip.getCot_tip());
		cv.put(TipDTO.campo_desc_tip, tip.getDesc_tip());
		this.dbManager.update(TodoSQL.tabla_tip, cv, "_id="+tip.getCot_tip(), null);
		
	}
	
	public void actualizarFuente(Fuente_ArchivoDTO fuente){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarFuente");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(Fuente_ArchivoDTO.campo_cod_fuente, fuente.getCod_fuente());
		cv.put(Fuente_ArchivoDTO.campo_desc_fuente, fuente.getDesc_fuente());
		this.dbManager.update(TodoSQL.tabla_fuente_archivo, cv, "_id="+fuente.getCod_fuente(), null);
		
	}
	
	public void actualizarIngrediente(IngredienteDTO ingre){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarIngrediente");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(IngredienteDTO.campo_cod_ingrediente, ingre.getCod_ingrediente());
		cv.put(IngredienteDTO.campo_desc_ingrediente, ingre.getDesc_ingrediente());
		this.dbManager.update(TodoSQL.tabla_ingrediente, cv, "_id="+ingre.getCod_ingrediente(), null);
		
	}
	
	public void actualizarImagenPrimario(ImagenPrimDTO img){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarImagenPrimario");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(ImagenPrimDTO.campo_cod_img_prim, img.getCod_img_prim());
		cv.put(ImagenPrimDTO.campo_cod_fuente, img.getFuente().getCod_fuente());
		cv.put(ImagenPrimDTO.campo_url_external_img, img.getUrl_external_img());
		cv.put(ImagenPrimDTO.campo_url_local_img, img.getUrl_local_img());
		this.dbManager.update(TodoSQL.tabla_imagen_primario, cv, "_id="+img.getCod_img_prim(), null);		
		
	}
	
	public void actualizarPlato(CevicheDTO ceviche){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarrPlato");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(CevicheDTO.campo_cod_plato, ceviche.getCod_plato());
		cv.put(CevicheDTO.campo_nombre, ceviche.getNombre());
		cv.put(CevicheDTO.campo_cod_img_prim, ceviche.getImg_prim().getCod_img_prim());
		cv.put(CevicheDTO.campo_cod_rating, ceviche.getRating().getCod_rating());
		cv.put(CevicheDTO.campo_cod_region, ceviche.getRegion().getCod_region());
		cv.put(CevicheDTO.campo_cod_tip, ceviche.getTip().getCot_tip());
		cv.put(CevicheDTO.campo_cod_tipo, ceviche.getTipo().getCod_tipo());
		this.dbManager.update(TodoSQL.tabla_plato, cv, "_id="+ceviche.getCod_plato(), null);
		
	}
	
	public void actualizarVideo(VideoDTO video){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarVideo");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(VideoDTO.campo_cod_video, video.getCod_video());
		cv.put(VideoDTO.campo_cod_plato, video.getCod_plato());
		cv.put(VideoDTO.campo_cod_fuente, video.getFuente().getCod_fuente());
		cv.put(VideoDTO.campo_url_external_video, video.getUrl_external_video());
		cv.put(VideoDTO.campo_url_local_video, video.getUrl_local_video());
		this.dbManager.update(TodoSQL.tabla_video, cv, "_id="+video.getCod_video(), null);
		
	}
	
	public void actualizarImagenSecundario(ImagenSecDTO img){
		Log.v(TAG, "Estoy en SQLiteManager: actualizarImagenSecundario");
		//Clase para agregar los valores a actualizar
		ContentValues cv = new ContentValues();
//		cv.put(ImagenSecDTO.campo_cod_img_sec, img.getCod_img_sec());
		cv.put(ImagenSecDTO.campo_cod_plato, img.getCod_plato());
		cv.put(ImagenSecDTO.campo_cod_fuente, img.getFuente().getCod_fuente());
		cv.put(ImagenSecDTO.campo_url_external_img, img.getUrl_external_img());
		cv.put(ImagenSecDTO.campo_url_local_img, img.getUrl_local_img());
		this.dbManager.update(TodoSQL.tabla_image_secundario, cv, "_id="+img.getCod_img_sec(), null);
				
	}
	
	public void actualizarAscPlatoIngrediente(IngredienteDTO ingre){
		Log.v(TAG, "Estoy en SQLiteManager: insertarAscPlatoIngrediente");
		//Clase para agregar los valores a insertar
		ContentValues cv = new ContentValues();
//		cv.put(IngredienteDTO.campo_asc_cod_ingrediente, ingre.getCod_ingrediente());
//		cv.put(IngredienteDTO.campo_asc_cod_plato, ingre.getCod_plato());
		cv.put(IngredienteDTO.campo_asc_cantidad, ingre.getCantidad());
		cv.put(IngredienteDTO.campo_asc_unidad, ingre.getUnidad());
		this.dbManager.update(TodoSQL.tabla_asc_plato_ingrediente, cv, "cod_plato="+ingre.getCod_plato()+" and cod_ingrediente="+ingre.getCod_ingrediente(), null);
		
	}
	

}
