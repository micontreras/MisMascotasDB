package com.isabelcontreras.mismascotasfragmentbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.db.ConstructorMascotas;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFavoritaAdaptador extends RecyclerView.Adapter<MascotaFavoritaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> listadoMascotas;
    Activity activity;
    //Constructor que recibira nuestra lista de contactos
    public MascotaFavoritaAdaptador(ArrayList<Mascota> listadoMascotas, Activity activity){
        this.listadoMascotas=listadoMascotas;
        this.activity=activity;
    }

    //Este es el metodo que infla o maneja cada Card view que se usara
    //y se lo pasa al viewHolder para que el obtenga cada elemento view
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favorita, parent, false);
        return new MascotaViewHolder(v);
    }

    //Aqui pasaremos la lista de contactos a cada elemento que se tiene, seteamos los calores que tiene cada elemento
    //de mi lista de contactos, se va invocando 1 a 1 por cada elemento de la lista
    //asocia cada elemento de nuestra vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota= listadoMascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvTotalLikeCV.setText(""+mascota.getLikes()+" Likes");
    }

    //Cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return listadoMascotas.size();
    }

    //Permite declarar los elementos del view
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTotalLikeCV;
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV=(ImageView)itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTotalLikeCV=(TextView)itemView.findViewById(R.id.tvTotalLikeCV);

        }
    }
}

