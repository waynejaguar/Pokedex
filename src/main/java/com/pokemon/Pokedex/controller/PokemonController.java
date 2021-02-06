package com.pokemon.Pokedex.controller;


import com.pokemon.Pokedex.Response.AllPokemonResponse;
import com.pokemon.Pokedex.Response.PokemonResponse;
import com.pokemon.Pokedex.service.PokemonService;
import java.util.List;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/pokemon")
public class PokemonController {


  private final PokemonService pokemonService;

  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }


  @GetMapping(path = "/{id}")
  public AllPokemonResponse paginatePokemon(@PathVariable("id") final int id){


    return  new AllPokemonResponse(this.pokemonService.getAllPokemon(id));

  }


}
