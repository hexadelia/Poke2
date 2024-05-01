package com.example.poke2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepo {

    private static ArrayList<Pokemon> pokemonList = new ArrayList<>();
    static {
            pokemonList.add(new Pokemon("Pikachu", "Description1"));
            pokemonList.add(new Pokemon("Pikachu2", "Description2"));
    }
    private PokemonRepo() {

    }
    public static ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
