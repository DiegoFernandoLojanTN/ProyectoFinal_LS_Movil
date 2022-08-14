package com.example.tickets;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tickets.model.Eventos;

import java.util.List;

public class Adapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    List<Eventos> datos;

    public Adapter(Context context, List<Eventos> datos) {
        this.context = context;
        this.datos = datos;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.datos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View viste = inflater.inflate(R.layout.elemento, null);
        ImageView  imageView = (ImageView) viste.findViewById(R.id.imagen);
        TextView evento =  (TextView) viste.findViewById(R.id.nombre);
        TextView precio =(TextView) viste.findViewById(R.id.precio);
        TextView estado = (TextView) viste.findViewById(R.id.estado);
        evento.setText("Nombre: " + datos.get(i).getNombre());
        precio.setText("Precio: " + datos.get(i).getPrecio()+"");
        estado.setText("Estado: " + (datos.get(i).getEvento_valido() ? "Disponible" : "No disponible"));
        Glide.with(context).load(datos.get(i).getImage_url()).into(imageView);

        return viste;
    }
}
