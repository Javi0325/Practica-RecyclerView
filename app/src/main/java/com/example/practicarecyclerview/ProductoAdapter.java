package com.example.practicarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>{
    private ArrayList<Producto> listaproducto;

    public ProductoAdapter(ArrayList<Producto> listaproducto){this.listaproducto=listaproducto;}

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);

        return new ProductoViewHolder(Itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto=listaproducto.get(position);
        holder.tvproducto.setText(producto.getNombre());

        String inicial=producto.getCategoría().substring(0,1).toUpperCase();
        holder.tvInicial.setText(inicial);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {return listaproducto.size();}

    public static class ProductoViewHolder extends RecyclerView.ViewHolder{

        public TextView tvproducto,tvInicial;
        public ProductoViewHolder(View view) {
            super(view);
            tvproducto=view.findViewById(R.id.tvProducto);
            tvInicial=view.findViewById(R.id.tvIncial);
        }
    }
}
