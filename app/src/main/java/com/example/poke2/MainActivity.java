package com.example.poke2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.poke2.databinding.ActivityMainBinding;
import com.example.poke2.fragments.ListPokemonFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction().replace(binding.containerView.getId(), ListPokemonFragment.newInstance(PokemonRepo.getPokemonList())).commit();
    }
}