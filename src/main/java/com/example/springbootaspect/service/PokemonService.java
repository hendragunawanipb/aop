package com.example.springbootaspect.service;

import java.util.List;

import com.example.springbootaspect.model.PokemonModel;

public interface PokemonService {
	
	PokemonModel catchPokemon();
	
	List<PokemonModel> retrieveMyPokemon();
	
}
