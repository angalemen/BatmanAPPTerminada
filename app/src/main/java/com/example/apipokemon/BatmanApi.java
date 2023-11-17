package com.example.apipokemon;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class BatmanApi {


    private final String BASE_URL = "https://www.cheapshark.com/api/1.0/";


    ArrayList<Batman> getJuego() {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("games")
                .appendQueryParameter("title", "batman")
                .build();
        String url = builtUri.toString();


        return doCall(url);
    }


    private ArrayList<Batman> doCall(String url) {
        try {

            String JsonResponse = HttpUtils.get(url);

            Log.e("Bareta1", "JSON Response: " + JsonResponse);
            return processJson(JsonResponse);
        } catch (IOException e) {
            Log.e("Bareta2", "Error de E/S al hacer la llamada HTTP: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    private ArrayList<Batman> processJson(String JsonResponse) {

        ArrayList<Batman> listaBatmans = new ArrayList<>();
        try {

            JSONArray jsonArray = new JSONArray(JsonResponse);


            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject pokeJson = jsonArray.getJSONObject(i);

                Batman poke1 = new Batman();

                poke1.setIdJuego(pokeJson.getString("gameID"));
                poke1.setPrecioJuego(pokeJson.getInt("cheapest"));
                poke1.setNombreJuego(pokeJson.getString("external"));
                poke1.setUrlImagen(pokeJson.getString("thumb"));


                listaBatmans.add(poke1);
            }
        } catch (JSONException e) {

            Log.e("Bareta1", "Error al procesar JSON: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(listaBatmans);

        return listaBatmans;
    }
}





