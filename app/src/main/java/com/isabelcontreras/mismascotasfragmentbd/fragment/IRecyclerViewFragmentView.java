package com.isabelcontreras.mismascotasfragmentbd.fragment;

import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaFavoritaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
