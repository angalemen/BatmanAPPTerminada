package com.example.apipokemon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.apipokemon.databinding.FragmentSecondBinding;
import com.squareup.picasso.Picasso;


public class SecondFragment extends Fragment {


    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        Bundle args = getArguments();


        Picasso.get().load(args.getString("ImagenBatman")).into(binding.Foto2);


        binding.idSteam.setText(args.getString("Id Steam"));


        binding.idTitulo.setText("ID Juego en Steam:");
    }


    @Override
    public void onDestroyView() {

        super.onDestroyView();

        binding = null;
    }
}