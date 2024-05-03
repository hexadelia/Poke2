package com.example.poke2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poke2.Pokemon;
import com.example.poke2.PokemonRepo;
import com.example.poke2.R;
import com.example.poke2.databinding.FragmentEditPokemonBinding;

import java.util.function.Consumer;

public class EditPokemonFragment extends Fragment {
    private static final String ARG_CURRENT_POKEMON = "param1";

    private FragmentEditPokemonBinding bindings;

    private Consumer<Pokemon> onModifyClickEvent;
    private boolean hasDelete;

    private Pokemon editedPokemon;


    public EditPokemonFragment() {

    }


    public static EditPokemonFragment newInstance(Pokemon editedPokemon, Consumer<Pokemon> onModifyClickEvent, boolean hasDelete) {
        EditPokemonFragment fragment = new EditPokemonFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CURRENT_POKEMON, editedPokemon);
        fragment.setArguments(args);
        fragment.onModifyClickEvent = onModifyClickEvent;
        fragment.hasDelete = hasDelete;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            editedPokemon = (Pokemon) getArguments().getSerializable(ARG_CURRENT_POKEMON);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindings = FragmentEditPokemonBinding.inflate(LayoutInflater.from(container.getContext()));

        bindings.deleteButton.setVisibility(hasDelete ?  View.VISIBLE : View.INVISIBLE);
        return bindings.getRoot();
    }

    @Override
    public void onStart() {
        bindings.saveButton.setOnClickListener(v -> {
            onModifyClick();
            navigateToHome();
        });

        if (hasDelete) {
            bindings.deleteButton.setOnClickListener(v -> {
                PokemonRepo.getPokemonList().remove(editedPokemon);
                navigateToHome();
            });
        }
        super.onStart();
    }

    private void navigateToHome() {
        getParentFragmentManager().beginTransaction().replace(R.id.container_view, ListPokemonFragment.newInstance(PokemonRepo.getPokemonList())).commit();
    }

    private void onModifyClick() {
        editedPokemon.setName(bindings.pokemonName.getText().toString());
        editedPokemon.setName(bindings.pokemonDescription.getText().toString());
        onModifyClickEvent.accept(editedPokemon);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}