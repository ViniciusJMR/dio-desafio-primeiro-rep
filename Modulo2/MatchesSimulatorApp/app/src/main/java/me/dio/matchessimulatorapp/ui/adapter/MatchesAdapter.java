package me.dio.matchessimulatorapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.dio.matchessimulatorapp.databinding.MatchItemBinding;
import me.dio.matchessimulatorapp.domain.Match;
import me.dio.matchessimulatorapp.ui.DetailActivity;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches){
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Match match = matches.get(position);
        String score;

        //Adapta os dados da partida recuperada da api para o layout

        //Para imagens redondas
        //Glide.with(context).load(match.getHomeTeam().getImage()).into(holder.binding.ivFirstTeam);
        Glide.with(context)
                .load(match.getHomeTeam().getImage())
                .into(holder.binding.ivFirstTeam);
        holder.binding.tvFirstTeamName.setText(match.getHomeTeam().getName());
        if (match.getHomeTeam().getScore() != null){
            score = String.valueOf(match.getHomeTeam().getScore());
            holder.binding.tvFirstTeamScore.setText(score);

        }

        Glide.with(context)
                .load(match.getAwayTeam().getImage())
                .into(holder.binding.ivSecondTeam);
        if (match.getAwayTeam().getScore() != null){
            score = String.valueOf(match.getAwayTeam().getScore());
            holder.binding.tvSecondTeamScore.setText(score);
        }
        holder.binding.tvSecondTeamName.setText(match.getAwayTeam().getName());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.Extras.MATCH, match);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
