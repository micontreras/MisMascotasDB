package com.isabelcontreras.mismascotasfragmentbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<Mascota> listadoMascotas;
    Activity activity;
    //Constructor que recibira nuestra lista de contactos
    public PerfilAdaptador(ArrayList<Mascota> listadoMascotas, Activity activity){
        this.listadoMascotas=listadoMascotas;
        this.activity=activity;
    }

    //Este es el metodo que infla o maneja cada Card view que se usara
    //y se lo pasa al viewHolder para que el obtenga cada elemento view
    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    //Aqui pasaremos la lista de contactos a cada elemento que se tiene, seteamos los calores que tiene cada elemento
    //de mi lista de contactos, se va invocando 1 a 1 por cada elemento de la lista
    //asocia cada elemento de nuestra vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final PerfilViewHolder mascotaViewHolder, int position) {
        final Mascota mascota= listadoMascotas.get(position);
        mascotaViewHolder.imgFotoPerfilCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvTotalLikePerfilCV.setText(""+mascota.getLikes()+" Likes");

    }

    //Cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return listadoMascotas.size();
    }

    //Permite declarar los elementos del view
    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoPerfilCV;
        private TextView tvTotalLikePerfilCV;
        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoPerfilCV=(ImageView)itemView.findViewById(R.id.imgFotoPerfilCV);
            tvTotalLikePerfilCV=(TextView)itemView.findViewById(R.id.tvTotalLikePerfilCV);

        }
    }
}

