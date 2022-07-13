package me.dio.matchessimulatorapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.dio.matchessimulatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMatchesList();
        setupMatchesRefresh();
        setupFloatActionButton();
    }

    private void setupFloatActionButton() {
        //TODO Criar evento de click e simulação de partidas
    }

    private void setupMatchesRefresh() {
        //TODO Atualizar as partidas na ação de swipe
    }

    private void setupMatchesList() {
        //TODO Listar as partidas, consumindo nossa API
    }
}
