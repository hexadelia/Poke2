package com.example.poke2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poke2.Pokemon;
import com.example.poke2.PokemonListAdapter;
import com.example.poke2.databinding.FragmentListPokemonBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListPokemon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListPokemon extends Fragment {

    private FragmentListPokemonBinding binding;

    private static final String ARG_PARAM_POKELIST = "pokemonList";

    private List<Pokemon> pokemonList;

    public ListPokemon() {
    }

    public static ListPokemon newInstance(ArrayList<Pokemon> pokemonList) {
        ListPokemon fragment = new ListPokemon();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_POKELIST, pokemonList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pokemonList = (List<Pokemon>) getArguments().getSerializable(ARG_PARAM_POKELIST);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListPokemonBinding.inflate(inflater);
        binding.listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.listRecyclerView.setAdapter(new PokemonListAdapter(getContext(), pokemonList));
        return binding.getRoot();
    }

}