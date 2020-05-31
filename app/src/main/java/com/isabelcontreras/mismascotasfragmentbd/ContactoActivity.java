package com.isabelcontreras.mismascotasfragmentbd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.isabelcontreras.mismascotasfragment.R;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText tvNombre;
    TextInputEditText tvEmail;
    TextInputEditText tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        tvNombre=findViewById(R.id.tvNombre);
        tvEmail=findViewById(R.id.tvEmail);
        tvMensaje=findViewById(R.id.tvMensaje);
    }

    public void enviarComentario(View v){
        String nombre=tvNombre.getText().toString();
        String email=tvEmail.getText().toString();
        String mensaje=tvMensaje.getText().toString();
        String respuesta="";
        respuesta="Estimado(a) "+nombre;
        respuesta+=", su mensaje: \n "+mensaje;
        respuesta+="\n ha sido enviado, muchas gracias por sus comentarios. ";
        try {
            // respuesta = EnviarEmailUtileria.enviarCorreo(nombre, email, mensaje);
        }catch (Exception e){

        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(respuesta);
        builder.setPositiveButton(R.string.boton_dialogo_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
