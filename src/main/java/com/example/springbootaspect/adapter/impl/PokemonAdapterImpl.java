package com.example.springbootaspect.adapter.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootaspect.adapter.PokemonAdapter;
import com.github.javafaker.Faker;
import com.github.javafaker.Pokemon;


@Service("PokemonAdapter")
public class PokemonAdapterImpl implements PokemonAdapter {

	Faker faker = new Faker();
	
	@Override
	public Pokemon catchPokemon() {
		
		
		return faker.pokemon();
	}

	@Override
	public List<Pokemon> myPokemon() {
		
		return List.of(faker.pokemon(),faker.pokemon());
	}

}
