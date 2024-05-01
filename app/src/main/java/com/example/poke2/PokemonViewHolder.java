package com.example.poke2;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poke2.databinding.PokemonListItemRowBinding;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    PokemonListItemRowBinding pokemonListItemRowBinding;
    public PokemonViewHolder(@NonNull PokemonListItemRowBinding pokemonListItemRowBinding) {
        super(pokemonListItemRowBinding.getRoot());
        this.pokemonListItemRowBinding = pokemonListItemRowBinding;

    }

    public void updateViewHolder(Pokemon pokemon) {
        this.pokemonListItemRowBinding.pokemonName.setText(pokemon.getName());
        this.pokemonListItemRowBinding.pokemonDescription.setText(pokemon.getDescription());
    }

}
