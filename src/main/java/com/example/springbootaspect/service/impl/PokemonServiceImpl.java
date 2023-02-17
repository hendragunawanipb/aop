package com.example.springbootaspect.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootaspect.adapter.PokemonAdapter;
import com.example.springbootaspect.mapper.PokemonMapper;
import com.example.springbootaspect.model.PokemonModel;
import com.example.springbootaspect.service.PokemonService;
import com.github.javafaker.Pokemon;

@Service("PokemonService")
public class PokemonServiceImpl implements PokemonService,PokemonMapper {

	@Autowired
	private PokemonAdapter pokemonAdapter;
	
	@Override
	public PokemonModel catchPokemon() {
		
		Pokemon pokemon = pokemonAdapter.catchPokemon();
		
		return this.mapPokemon(pokemon);
	}

	@Override
	public List<PokemonModel> retrieveMyPokemon() {
		List<PokemonModel> listPokemonModel = new ArrayList<>();
		
		listPokemonModel = pokemonAdapter.myPokemon().parallelStream().map(p -> {
			return this.mapPokemon(p);
		}).collect(Collectors.toList());
		
		return listPokemonModel;
	}

}
