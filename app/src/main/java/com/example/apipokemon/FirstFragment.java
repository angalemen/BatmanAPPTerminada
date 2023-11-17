package com.example.apipokemon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.apipokemon.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {


    private FragmentFirstBinding binding;


    private ArrayList<Batman> listaJuegos;


    private BatmanAdapter batmanAdapter;


    @NonNull
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar
        listaJuegos = new ArrayList<>();


        batmanAdapter = new BatmanAdapter(
                getContext(),
                R.layout.lv_batman_row,
                listaJuegos
        );


        binding.listview1.setAdapter(batmanAdapter);


        refresh();


        binding.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Batman batmaninfo = batmanAdapter.getItem(position);


                Bundle args = new Bundle();
                args.putString("ImagenBatman", batmaninfo.getUrlImagen());
                args.putString("Id Steam", batmaninfo.getIdJuego());


                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, args);
            }
        });
    }


    private void refresh() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Handler handler = new Handler(Looper.myLooper());


        executorService.execute(() -> {

            BatmanApi apiGato = new BatmanApi();

            ArrayList<Batman> result = apiGato.getJuego();


            handler.post(() -> {

                batmanAdapter.clear();

                for (Batman g : result) {
                    batmanAdapter.add(g);
                }
            });
        });
    }

    // Método llamado cuando la vista del fragmento está siendo destruida
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Liberar el objeto de binding para evitar fugas de memoria
        binding = null;
    }
}
