package com.isabelcontreras.mismascotasfragmentbd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.adapter.PerfilAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.pojo.Mascota;
import com.isabelcontreras.mismascotasfragmentbd.pojo.PerfilMascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    PerfilMascota perfilMascota;
    private RecyclerView recyclerView;
    public PerfilAdaptador adaptador;
    private ImageView imgFotoPerfil;
    private TextView tvNombrePerfil;
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerView = v.findViewById(R.id.rvPerfil);
        GridLayoutManager lm = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(lm);
        obtenerPerfilMascota();
        imgFotoPerfil= v.findViewById(R.id.imgFotoPerfil);
        tvNombrePerfil=v.findViewById(R.id.tvNombrePerfil);

        imgFotoPerfil.setImageResource(perfilMascota.getFotoPerfil());
        tvNombrePerfil.setText(perfilMascota.getNombre());
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador() {
        adaptador = new PerfilAdaptador(perfilMascota.getDetalleFotosPerfil(), getActivity());
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerPerfilMascota() {
        perfilMascota= new PerfilMascota();
        perfilMascota.setNombre("Patito");
        perfilMascota.setFotoPerfil(R.mipmap.img_patito);
        perfilMascota.setDetalleFotosPerfil(new ArrayList<Mascota>());

        perfilMascota.getDetalleFotosPerfil().add(new Mascota(10, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(11, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(12, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(7, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(8, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(6, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(15, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(5, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(9, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(15, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(5, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(9, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(15, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(5, R.mipmap.img_patito));
        perfilMascota.getDetalleFotosPerfil().add(new Mascota(9, R.mipmap.img_patito));

    }
}