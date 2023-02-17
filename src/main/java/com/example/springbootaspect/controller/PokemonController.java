package com.example.springbootaspect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootaspect.annotation.LogExecutionTime;
import com.example.springbootaspect.service.PokemonService;

@RestController
public class PokemonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping(value="/catchpokemon")
	public ResponseEntity<?> getPokemon() {
		logger.debug("start - mypokemon");
		return new ResponseEntity<>(pokemonService.catchPokemon(),HttpStatus.OK);
	}
	
	@LogExecutionTime
	@GetMapping(value="/mypokedex")
	public ResponseEntity<?> myPokedex(){
		return new ResponseEntity<>(pokemonService.retrieveMyPokemon(),HttpStatus.OK);
	}
	

}
