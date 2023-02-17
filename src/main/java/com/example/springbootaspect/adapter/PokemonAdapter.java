package com.example.springbootaspect.adapter;

import java.util.List;

import com.github.javafaker.Pokemon;

public interface PokemonAdapter {
	Pokemon catchPokemon();
	List<Pokemon> myPokemon();
}
