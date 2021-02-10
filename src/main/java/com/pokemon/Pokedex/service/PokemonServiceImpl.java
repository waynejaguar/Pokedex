package com.pokemon.Pokedex.service;


import com.pokemon.Pokedex.Response.PokemonResponse;
import com.pokemon.Pokedex.Response.SpecificPokemon;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Characteristic;
import me.sargunvohra.lib.pokekotlin.model.EvolutionChain;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService {


  private PokeApi pokeApi = new PokeApiClient();

  @Override
  public List<PokemonResponse> getAllPokemon(int offset, int limmit) throws Exception {

    PokeApi pokeApi = new PokeApiClient();// Todo
    List<PokemonResponse> resulList = new ArrayList<>();

    int count = 1;
    try{
    NamedApiResourceList pokemonPaginate = pokeApi.getPokemonList(offset, limmit);
    List<NamedApiResource> pokemonResults = pokemonPaginate.getResults();

    for (int i = 0; i < pokemonResults.size() ; i++) {
      Pokemon pokemon = pokeApi.getPokemon(count);
      PokemonResponse customPokemon = SinglePokemonResponse(pokemon);
      resulList.add(customPokemon);
      count ++;
    }
    }catch (Exception e){

      log.error("something was wrong");
    }

    return  resulList;
  }


  @Override
  public SpecificPokemon getPokemonByid(int id) {

    EvolutionChain evolutionChain = pokeApi.getEvolutionChain(id);
    Characteristic characteristic = pokeApi.getCharacteristic(id);
    PokemonResponse poekemonResponse = this.SinglePokemonResponse(pokeApi.getPokemon(id));


    return new SpecificPokemon(poekemonResponse, evolutionChain, characteristic);
  }

  @Override
  public PokemonResponse SinglePokemonResponse(Pokemon pokemon) {

    return PokemonResponse.builder().id(pokemon.getId())
        .name(pokemon.getName())
        .type(pokemon.getTypes()).weight(pokemon.getWeight())
        .listAbilities(pokemon.getAbilities()).sprites(pokemon.getSprites()).build();
  }

}
