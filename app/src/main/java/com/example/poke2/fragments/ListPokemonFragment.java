package com.example.poke2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poke2.Pokemon;
import com.example.poke2.PokemonListAdapter;
import com.example.poke2.R;
import com.example.poke2.databinding.FragmentListPokemonBinding;

import java.util.ArrayList;

public class ListPokemonFragment extends Fragment {

    private FragmentListPokemonBinding binding;
    private NavController controller;

    private static final String ARG_PARAM_POKELIST = "pokemonList";


    public ListPokemonFragment() {
    }

    public static ListPokemonFragment newInstance(ArrayList<Pokemon> pokemonList) {
        ListPokemonFragment fragment = new ListPokemonFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_POKELIST, pokemonList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ArrayList<Pokemon> getPokemonList() {
        return (ArrayList<Pokemon>) getArguments().getSerializable(ARG_PARAM_POKELIST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListPokemonBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Navigation.findNavController(LayoutInflater.from(view);
        binding.listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.listRecyclerView.setAdapter(new PokemonListAdapter(getContext(), getPokemonList(), (pokemonPosition) -> {
            onEditClick(pokemonPosition);
        }));
    }

    public void onEditClick(int pokemonPosition) {
        EditPokemonFragment editPokemonFragment = EditPokemonFragment.newInstance(getPokemonList().get(pokemonPosition), pokemon -> {
            getPokemonList().set(pokemonPosition, pokemon);
        }, true);
        getParentFragmentManager().beginTransaction().replace(R.id.container_view, editPokemonFragment).commit();
    }
}