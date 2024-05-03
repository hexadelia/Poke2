package com.example.poke2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poke2.databinding.PokemonListItemRowBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PokemonListAdapter extends RecyclerView.Adapter {


    private List<Pokemon> pokemonList;
    private final LayoutInflater inflator;
    private final Consumer<Integer> onEditEvent;

    public PokemonListAdapter(Context context, List<Pokemon> pokemonList, Consumer<Integer> onEditEvent) {
        this.inflator = LayoutInflater.from(context);
        this.pokemonList = pokemonList;
        this.onEditEvent = onEditEvent;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(PokemonListItemRowBinding.inflate(inflator));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PokemonViewHolder)holder).updateViewHolder(pokemonList.get(position), position, onEditEvent);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
