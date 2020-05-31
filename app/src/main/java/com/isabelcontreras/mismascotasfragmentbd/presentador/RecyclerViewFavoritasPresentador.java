package com.isabelcontreras.mismascotasfragmentbd.presentador;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaFavoritaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.db.ConstructorMascotas;
import com.isabelcontreras.mismascotasfragmentbd.fragment.IRecyclerViewFragmentView;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFavoritasPresentador implements IRecyclerViewFavoritasPresentador {

    private Activity activity;
    private RecyclerView recyclerView;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotasLista;

    public RecyclerViewFavoritasPresentador(RecyclerView recyclerView, Activity activity) {
        this.activity=activity;
        this.recyclerView=recyclerView;
        obtenerMascotasFavoritas();
    }

    @Override
    public void obtenerMascotasFavoritas() {
        constructorMascotas= new ConstructorMascotas(activity);
        mascotasLista = constructorMascotas.obtenerMascotasFavoritas(5);
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        inicializarAdaptadorRV(crearAdaptador(mascotasLista));
        generarLinearLayoutVertical();
    }

    public void generarLinearLayoutVertical() {
        LinearLayoutManager lm = new LinearLayoutManager(activity);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
    }

    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaFavoritaAdaptador adaptador= new MascotaFavoritaAdaptador(mascotas,activity);
        return adaptador;
    }

    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador) {
        recyclerView.setAdapter(adaptador);
    }
}
