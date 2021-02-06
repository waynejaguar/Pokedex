package com.pokemon.Pokedex.service;


import com.pokemon.Pokedex.Response.PokemonResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService {



  @Override
  public List<PokemonResponse> getAllPokemon(int quantityPokemons) {


    PokeApi pokeApi = new PokeApiClient();
    List<PokemonResponse> resulList = new ArrayList<PokemonResponse>();

    NamedApiResourceList pokemonPaginate = pokeApi.getPokemonList(0, quantityPokemons);
    List<NamedApiResource> pokemonResults = pokemonPaginate.getResults();

    int count = 1;

    for (int i = 0; i < pokemonResults.size() ; i++) {

      Pokemon pokemon = pokeApi.getPokemon(count);

      PokemonResponse customPokemon = PokemonResponse.builder().id(pokemon.getId())
          .name(pokemon.getName())
          .type(pokemon.getTypes()).weight(pokemon.getWeight())
          .listAbilities(pokemon.getAbilities()).sprites(pokemon.getSprites()).build();

      resulList.add(customPokemon);
      
      count ++;
    }

    
    return  resulList;
  }

}
