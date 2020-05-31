package com.isabelcontreras.mismascotasfragmentbd.db;

import android.content.ContentValues;
import android.content.Context;

import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db=new BaseDatos(context);
        ArrayList<Mascota> mascotasAux=db.obtenerMascotas();
        if(mascotasAux==null || mascotasAux.isEmpty()){
            insertarInicioMascotas(db);
        }
        return db.obtenerMascotas();
    }

    public void insertarInicioMascotas(BaseDatos bd){
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Perrito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_perrito);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Gatito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_gatito);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Pecita");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_peces);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"MrCaballito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_caballito_mar);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Patito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_patito);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Caballito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_caballito);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Ham");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_hamster);
        bd.insertarMascotas(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE,"Popotito");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.mipmap.img_pajarito);
        bd.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_LIKES_NUM_LIKE, LIKE);
        db.insertarLikeMascota(contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(int maxMascotasFavoritas){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerMascotasFavoritas(maxMascotasFavoritas);
    }
}
