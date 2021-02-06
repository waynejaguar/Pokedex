package com.pokemon.Pokedex.Response;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class AllPokemonResponse {
  private List<PokemonResponse> pokemonList;

  public AllPokemonResponse(final List<PokemonResponse> pokemonList) {
    this.pokemonList= pokemonList;
  }

}

