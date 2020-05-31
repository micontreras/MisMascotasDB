package com.isabelcontreras.mismascotasfragmentbd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.adapter.MascotaFavoritaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;
import com.isabelcontreras.mismascotasfragmentbd.presentador.IRecyclerViewFragmentPresentador;
import com.isabelcontreras.mismascotasfragmentbd.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private RecyclerView recyclerView;
    private IRecyclerViewFragmentPresentador iRecyclerViewFragmentPresentador;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recycler_view, container,false);
        /* return super.onCreateView(inflater, container, savedInstanceState);*/
        recyclerView = v.findViewById(R.id.rvMascotas);
        iRecyclerViewFragmentPresentador=new RecyclerViewFragmentPresentador(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos) {
        MascotaAdaptador adaptador= new MascotaAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        recyclerView.setAdapter(adaptador);
    }

}