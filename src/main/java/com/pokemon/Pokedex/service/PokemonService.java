package com.pokemon.Pokedex.service;


import com.pokemon.Pokedex.Response.PokemonResponse;
import java.util.List;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public interface PokemonService {


  List<PokemonResponse> getAllPokemon(int quantityPokemons);

}
