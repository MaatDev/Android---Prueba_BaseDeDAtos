package com.my.classStatic;


public class TodoSQL {
	
	//Sentencias
		
		public static final String sentencia_createTabla = 			


			"create table Tipo(cod_tipo integer primary key autoincrement, desc_tipo text);"+

			"create table Rating(cod_rating integer primary key autoincrement, num_estrellas integer, desc_comentario text);"+

			"create table Region(cod_region integer primary key autoincrement, desc_region text);"+

			"create table Tip(cod_tip integer primary key autoincrement, desc_tip text);"+

			"create table Fuente_Archivo(cod_fuente integer primary key autoincrement, desc_fuente text);"+

			"create table Ingrediente(cod_ingrediente integer primary key autoincrement, desc_ingrediente text);"+




			"create table Imagen_Primario(cod_img_prim integer primary key autoincrement, cod_fuente integer, url_external_img text, url_local_img text, foreign key (cod_fuente) references Fuente_Archivo(cod_fuente));"+

			"create table Plato(Cod_Plato integer primary key autoincrement, cod_tipo integer, cod_region integer, cod_tip integer, cod_rating integer, cod_img_prim integer, desc_plato text, foreign key (cod_tipo) references Tipo(cod_tipo), foreign key (cod_region) references Region(cod_region), foreign key(cod_tip) references Tip(cod_tip), foreign key (cod_rating) references Rating(cod_rating), foreign key(cod_img_prim) references Imagen_Primario(cod_img_prim) );"+


			"create table Video(cod_video integer primary key autoincrement, cod_fuente integer, url_external_video text, url_local_video text, cod_plato integer, foreign key(cod_plato) references Plato(cod_plato), foreign key(cod_fuente) references Fuente_Archivo(cod_fuente));"+

			"create table Imagen_Secundario(cod_img_sec integer primary key autoincrement, cod_fuente integer, url_external_img text, url_local_img text, cod_plato integer, foreign key(cod_plato) references Plato(cod_plato), foreign key (cod_fuente) references Fuente_Archivo(cod_fuente));"+



			"create table Asc_plato_ingrediente(cod_plato integer, cod_ingrediente, cantidad real, unidad text, foreign key (cod_plato) references Plato(cod_plato), foreign key (cod_ingrediente) references Igrediente(cod_ingrediente) );";
		
		public static final String sentencia_dropAll = 
			"drop table if exists Asc_plato_ingrediente;"+
			"drop table if exists Plato;"+
			"drop table if exists Imagen_Primario;"+
			"drop table if exists Imagen_Secundario;"+
			"drop table if exists Video;"+

			"drop table if exists Fuente_Archivo;"+
			"drop table if exists Ingrediente;"+
			"drop table if exists Rating;"+
			"drop table if exists Region;"+
			"drop table if exists Tip;"+
			"drop table if exists Tipo;";
		
		public static final String sentencia_serchTables = "select name from sqlite_master where type='table';";
		
		public static final String dbPath = "/data/data/com.my/databases/";		
	
		public static final String nombreDB = "cevicheDB2";
		
		public static final int dbVersion = 1;

//		public static final String nombreTabla = "ceviche";
		
		//Nombre de tablas
		public static final String tabla_tipo="Tipo";
		public static final String tabla_rating="Rating";
		public static final String tabla_region="Region";
		public static final String tabla_tip="Tip";
		public static final String tabla_fuente_archivo="Fuente_Archivo";
		public static final String tabla_ingrediente="Ingrediente";
		public static final String tabla_imagen_primario="Imagen_Primario";
		public static final String tabla_plato="Plato";
		public static final String tabla_video="Video";
		public static final String tabla_image_secundario="Imagen_Secundario";
		public static final String tabla_asc_plato_ingrediente="Asc_plato_ingrediente";
		
		
		public static final String whereSimple = "codigo=";
}
