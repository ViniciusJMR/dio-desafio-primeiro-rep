package me.dio.matchessimulatorapp.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Random;

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
        binding.fabSimulate.setOnClickListener(view -> {
            view.animate().rotationBy(360).setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Random random = new Random();
                            for(int i=0; i < matchesAdapter.getItemCount(); i++){
                                Match match = matchesAdapter.getMatches().get(i);
                                match.getHomeTeam().setScore(random.nextInt(match.getHomeTeam().getStars() + 1));
                                match.getAwayTeam().setScore(random.nextInt(match.getAwayTeam().getStars() + 1));
                                matchesAdapter.notifyItemChanged(i);
                            }

                        }
                });
        });
    }

    private void setupMatchesRefresh() {
        binding.srlMatches.setOnRefreshListener(this::findMatchesFromApi);
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

        findMatchesFromApi();
    }

    private void findMatchesFromApi() {
        binding.srlMatches.setRefreshing(true);
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
                binding.srlMatches.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                showErrorMessage();
                binding.rvMatches.setAdapter(matchesAdapter);
            }
        });
    }

    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }
}
