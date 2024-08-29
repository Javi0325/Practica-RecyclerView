package com.example.practicarecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre,precio;
    Spinner categoria,temporada;
    Button registrar,ver;
    ArrayList<Producto>listaproductos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.txtNombre);
        precio=findViewById(R.id.txtPrecio);
        categoria=findViewById(R.id.spCategoria);
        temporada=findViewById(R.id.spTemporada);
        registrar=findViewById(R.id.btnRegistrar);
        ver=findViewById(R.id.btnLista);
    }
    public void Registrar(View v){

        Producto pac=new Producto(nombre.getText().toString(),categoria.getSelectedItem().toString(),temporada.getSelectedItem().toString(),Double.parseDouble(precio.getText().toString()));
        listaproductos.add(pac);

        nombre.setText("");
        precio.setText("");
        categoria.setSelection(0);
        temporada.setSelection(0);
    }

    public void Ver(View v) {
        Intent it=new Intent(getApplicationContext(), listaProductos.class);
        it.putExtra("Lista",(Serializable) listaproductos);
        startActivity(it);
    }
}