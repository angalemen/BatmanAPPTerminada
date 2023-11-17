package com.example.apipokemon;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;
public class BatmanAdapter extends ArrayAdapter<Batman> {


    public BatmanAdapter(@NonNull Context context, int resource, List<Batman> juegosBat) {
        super(context, resource, juegosBat);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Batman pok1 = getItem(position);


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_batman_row, parent, false);
        }


        TextView NombreJuego = convertView.findViewById(R.id.Nombre);
        TextView PrecioJuego = convertView.findViewById(R.id.PrecioSteam);
        TextView IdJuego = convertView.findViewById(R.id.idSteam);
        ImageView FotoJuego = convertView.findViewById(R.id.imageView);
        ImageView FotoJuegoSeg = convertView.findViewById(R.id.Foto2);


        NombreJuego.setText(pok1.getNombreJuego());
        PrecioJuego.setText("Precio: " + pok1.getPrecioJuego() + "€");
        Log.e("ParaYa", "ID Juego: " + pok1.getIdJuego());


        Picasso.get().load(pok1.getUrlImagen()).into(FotoJuego);


        return convertView;
    }
}





