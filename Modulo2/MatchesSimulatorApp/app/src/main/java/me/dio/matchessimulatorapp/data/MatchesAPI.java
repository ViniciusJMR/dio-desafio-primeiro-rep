package me.dio.matchessimulatorapp.data;


import java.util.List;

import me.dio.matchessimulatorapp.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesAPI {

    @GET("matches.json")
    Call<List<Match>> getMatches();


}
