package me.dio.matchessimulatorapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import me.dio.matchessimulatorapp.R;
import me.dio.matchessimulatorapp.data.MatchesAPI;
import me.dio.matchessimulatorapp.databinding.ActivityMainBinding;
import me.dio.matchessimulatorapp.domain.Match;
import me.dio.matchessimulatorapp.ui.adapter.MatchesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MatchesAPI api;
    private MatchesAdapter matchesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
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

    private void setupHttpClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viniciusjmr.github.io/dio-santander-bootcamp-mobile/Modulo2/MatchesSimulatorApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MatchesAPI.class);
    }

    private void setupMatchesList() {
        binding.rvMatches.setHasFixedSize(true);
        binding.rvMatches.setLayoutManager(new LinearLayoutManager(this));

        api.getMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if(response.isSuccessful()){
                    List<Match> matches = response.body();
                    matchesAdapter = new MatchesAdapter(matches);
                    binding.rvMatches.setAdapter(matchesAdapter);
                } else{
                    showErrorMessage();
                }

            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }
}
