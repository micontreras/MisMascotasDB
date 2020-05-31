package com.isabelcontreras.mismascotasfragmentbd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.NOMBRE_BASE_DATOS, null, ConstantesBaseDatos.VERSION_BASE_DATOS);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Aqui se crea la estructura de la base de datos
        String queryCrearTablaContacto="CREATE TABLE "+ConstantesBaseDatos.TABLA_MASCOTA +" ( "+
                ConstantesBaseDatos.TABLA_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE + " TEXT, "+
                ConstantesBaseDatos.TABLA_MASCOTA_FOTO + " INTEGER "+
                " ) ";


        String queryCrearTablaContactoLikes="CREATE TABLE "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES +" ( "+
                ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA + " INTEGER, "+
                ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE + " INTEGER, "+
                " FOREIGN KEY ( "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA+" ) "+
                " REFERENCES "+ConstantesBaseDatos.TABLA_MASCOTA +" ( "+  ConstantesBaseDatos.TABLA_MASCOTA_ID +" ) "+
                " ) ";

        sqLiteDatabase.execSQL(queryCrearTablaContacto);
        sqLiteDatabase.execSQL(queryCrearTablaContactoLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +ConstantesBaseDatos.TABLA_MASCOTA_LIKES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +ConstantesBaseDatos.TABLA_MASCOTA);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> contactosList= new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBaseDatos.TABLA_MASCOTA;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registro=db.rawQuery(query,null);

        while (registro.moveToNext()){
            Mascota mascotaAct= new Mascota();
            mascotaAct.setId(registro.getInt(0));
            mascotaAct.setNombre(registro.getString(1));
            mascotaAct.setFoto(registro.getInt(2));
            int likes=0;
            String queryCantidad="SELECT COUNT( "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE+" ) "
                    +" FROM "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES
                    +" WHERE "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA + " = "+mascotaAct.getId();
            Cursor registrosLikes=db.rawQuery(queryCantidad,null);
            if(registrosLikes.moveToNext()){
                likes=registrosLikes.getInt(0);
            }
            mascotaAct.setLikes(likes);
            contactosList.add(mascotaAct);
        }
        db.close();
        return contactosList;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase sqlDB=this.getReadableDatabase();
        sqlDB.insert(ConstantesBaseDatos.TABLA_MASCOTA,null,contentValues);
        sqlDB.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase sqlDB=this.getReadableDatabase();
        sqlDB.insert(ConstantesBaseDatos.TABLA_MASCOTA_LIKES,null,contentValues);
        sqlDB.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes=0;
        String queryCantidad="SELECT COUNT( "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE+" ) "
                +" FROM "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES
                +" WHERE "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA + " = "+mascota.getId();

        SQLiteDatabase sqlDB=this.getReadableDatabase();

        Cursor registros=sqlDB.rawQuery(queryCantidad, null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        sqlDB.close();

        return likes;
    }


    public ArrayList<Mascota> obtenerMascotasFavoritas(int maxMascotasFavoritas){
        ArrayList<Mascota> contactosList= new ArrayList<>();
        String query="SELECT "
                +ConstantesBaseDatos.TABLA_MASCOTA+"."+ConstantesBaseDatos.TABLA_MASCOTA_ID
                +", "+ConstantesBaseDatos.TABLA_MASCOTA+"."+ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE
                +", "+ConstantesBaseDatos.TABLA_MASCOTA+"."+ConstantesBaseDatos.TABLA_MASCOTA_FOTO
                +", COUNT("+ConstantesBaseDatos.TABLA_MASCOTA_LIKES+"."+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE
                +") AS "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE
                +" FROM "+ConstantesBaseDatos.TABLA_MASCOTA
                +" JOIN "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES +" ON "
                +ConstantesBaseDatos.TABLA_MASCOTA_LIKES+"."+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA+" = "
                +ConstantesBaseDatos.TABLA_MASCOTA+"."+ConstantesBaseDatos.TABLA_MASCOTA_ID
                +" GROUP BY  " +ConstantesBaseDatos.TABLA_MASCOTA+"."+ConstantesBaseDatos.TABLA_MASCOTA_ID
                +", " +ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE
                +" ORDER BY "+ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE +" DESC "
                +" LIMIT "+ maxMascotasFavoritas +" ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registro=db.rawQuery(query,null);

        while (registro.moveToNext()){
            Mascota mascotaAct= new Mascota();
            mascotaAct.setId(registro.getInt(0));
            mascotaAct.setNombre(registro.getString(1));
            mascotaAct.setFoto(registro.getInt(2));
            mascotaAct.setLikes(registro.getInt(3));
            contactosList.add(mascotaAct);
        }
        db.close();
        return contactosList;
    }
}
