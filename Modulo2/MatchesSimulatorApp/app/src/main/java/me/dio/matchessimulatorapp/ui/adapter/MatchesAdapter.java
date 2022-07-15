package me.dio.matchessimulatorapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.dio.matchessimulatorapp.databinding.MatchItemBinding;
import me.dio.matchessimulatorapp.domain.Match;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches){
        this.matches = matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Match match = matches.get(position);

        //Adapta os dados da partida recuperada da api para o layout
        Glide.with(context)
                .load(match.getHomeTeam().getImage())
                .into(holder.binding.ivFirstTeam);
        //Para imagens redondas
        //Glide.with(context).load(match.getHomeTeam().getImage()).into(holder.binding.ivFirstTeam);

        holder.binding.tvFirstTeamName.setText(match.getHomeTeam().getName());
        Glide.with(context)
                .load(match.getAwayTeam().getImage())
                .into(holder.binding.ivSecondTeam);
        holder.binding.tvSecondTeamName.setText(match.getAwayTeam().getName());

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
