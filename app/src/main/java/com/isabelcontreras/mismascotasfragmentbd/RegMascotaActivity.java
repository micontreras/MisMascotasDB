package com.isabelcontreras.mismascotasfragmentbd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.isabelcontreras.mismascotasfragment.R;
import com.isabelcontreras.mismascotasfragmentbd.adapter.PaginaAdaptador;
import com.isabelcontreras.mismascotasfragmentbd.fragment.PerfilFragment;
import com.isabelcontreras.mismascotasfragmentbd.fragment.RecyclerViewFragment;

import java.util.ArrayList;
/**
*
* Actividad que permite el registro de mascotas
*
**/
public class RegMascotaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //Esto es para fragments
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        //tabLayout.set
        viewPager=findViewById(R.id.viewPager);
        setUpViewPager();
      /*  if(toolbar!=null){
            setSupportActionBar(toolbar);
        }*/
    }

    //Para agregar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    //Control del menu que se agrega
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcerca:
                Intent intentAcerca = new Intent(this, BiosDesarrolloActivity.class);
                startActivity(intentAcerca);
                break;
            case R.id.mFavoritos:
                Intent intentConfig = new Intent(this, FavoritasActivity.class);
                startActivity(intentConfig);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PaginaAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.icon_hueso_color);
        tabLayout.getTabAt(1).setIcon(R.mipmap.icon_hueso_color);
    }
}
