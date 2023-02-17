package com.example.springbootaspect.mapper;

import com.example.springbootaspect.model.PokemonModel;
import com.github.javafaker.Pokemon;

public interface PokemonMapper {
	
	default PokemonModel mapPokemon(Pokemon pokemon) {
		
		PokemonModel pokemonModel = PokemonModel
				.builder()
				.name(pokemon.name())
				.location(pokemon.location())
				.build();
		
		return pokemonModel;
		
	}

}
