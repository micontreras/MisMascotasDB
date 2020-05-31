package com.isabelcontreras.mismascotasfragmentbd.presentador;

import android.content.Context;

import com.isabelcontreras.mismascotasfragmentbd.db.ConstructorMascotas;
import com.isabelcontreras.mismascotasfragmentbd.fragment.IRecyclerViewFragmentView;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotasLista;

    public RecyclerViewFragmentPresentador(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas= new ConstructorMascotas(context);
        mascotasLista = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotasLista));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
