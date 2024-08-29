package com.example.practicarecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listaProductos extends AppCompatActivity {
    RecyclerView lista;
    ArrayList<Producto> listaProducto;
    ProductoAdapter productoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_productos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaProducto = (ArrayList<Producto>) getIntent().getSerializableExtra("Lista");

        // Inicializa el adaptador con la lista de estudiantes
        productoAdapter = new ProductoAdapter(listaProducto);

        // Configura el RecyclerView
        lista = findViewById(R.id.rvLista);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(productoAdapter);

        // Si es necesario notificar una inserción en la lista, esto debería hacerse después de inicializar el adaptador
        if (!listaProducto.isEmpty()) {
            productoAdapter.notifyItemInserted(listaProducto.size() - 1);
        }
    }
}