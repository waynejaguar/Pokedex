package com.pokemon.Pokedex.service;

import java.util.List;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.junit.jupiter.api.Test;

public class PokemonServiceImplTest {






  @Test
  public void should_return_all_pokemons(){

   PokemonServiceImpl pl = new PokemonServiceImpl();

    List<Pokemon> salida = pl.getAllPokemon(10);



  }

}
