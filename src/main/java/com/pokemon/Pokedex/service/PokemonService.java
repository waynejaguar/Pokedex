package com.pokemon.Pokedex.service;


import com.pokemon.Pokedex.Response.PokemonResponse;
import com.pokemon.Pokedex.Response.SpecificPokemon;
import java.util.List;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public interface PokemonService {


  List<PokemonResponse> getAllPokemon(int offset, int limmit) throws Exception;

  SpecificPokemon getPokemonByid(int id);

  PokemonResponse SinglePokemonResponse(Pokemon pokemon);

}
