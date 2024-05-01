package com.example.poke2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poke2.databinding.PokemonListItemRowBinding;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter {


    private List<Pokemon> pokemonList;
    private final LayoutInflater inflator;

    public PokemonListAdapter(Context context, List<Pokemon> pokemonList) {
        this.inflator = LayoutInflater.from(context);
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(PokemonListItemRowBinding.inflate(inflator));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PokemonViewHolder)holder).updateViewHolder(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
