package com.pokemon.Pokedex.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.sargunvohra.lib.pokekotlin.model.Characteristic;
import me.sargunvohra.lib.pokekotlin.model.EvolutionChain;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SpecificPokemon {


  public PokemonResponse pokemonResponse;
  public EvolutionChain evolutionChain;
  public Characteristic characteristic;


}

