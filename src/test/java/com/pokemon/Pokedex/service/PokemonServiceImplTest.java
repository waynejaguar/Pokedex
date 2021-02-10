package com.pokemon.Pokedex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import com.pokemon.Pokedex.Response.PokemonResponse;
import com.pokemon.Pokedex.Response.SpecificPokemon;
import java.util.ArrayList;
import java.util.List;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.ChainLink;
import me.sargunvohra.lib.pokekotlin.model.Characteristic;
import me.sargunvohra.lib.pokekotlin.model.Description;
import me.sargunvohra.lib.pokekotlin.model.EvolutionChain;
import me.sargunvohra.lib.pokekotlin.model.EvolutionDetail;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonAbility;
import me.sargunvohra.lib.pokekotlin.model.PokemonHeldItem;
import me.sargunvohra.lib.pokekotlin.model.PokemonHeldItemVersion;
import me.sargunvohra.lib.pokekotlin.model.PokemonMove;
import me.sargunvohra.lib.pokekotlin.model.PokemonMoveVersion;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import me.sargunvohra.lib.pokekotlin.model.PokemonStat;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import me.sargunvohra.lib.pokekotlin.model.VersionGameIndex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PokemonServiceImplTest {


 @Mock
 private  PokemonServiceImpl service;

 @Mock
 private final PokeApi pokeApi = new PokeApiClient();


  @Test
  public void should_return_one_pokemon_by_id(){


   PokemonServiceImpl pokemonService = new PokemonServiceImpl();

    NamedApiResource namedApiResourcedummy = new NamedApiResource("dummy", "category", 1);
    List<NamedApiResource> namedApiResourceListFormsDummy = new ArrayList<>();
    namedApiResourceListFormsDummy.add(0, namedApiResourcedummy);

    PokemonAbility pokemonAbilityDummy = new PokemonAbility(true, 1, namedApiResourcedummy);
    List<PokemonAbility> listAbilitityDummy = new ArrayList<>();
    listAbilitityDummy.add(0,pokemonAbilityDummy);

    VersionGameIndex versionGameIndexDummy = new VersionGameIndex(1,namedApiResourcedummy );
    List<VersionGameIndex> versionGameIndexListDummy = new ArrayList<>();
    versionGameIndexListDummy.add(0, versionGameIndexDummy);

    PokemonHeldItemVersion pokemonHeldItemVersionDummy = new PokemonHeldItemVersion(namedApiResourcedummy, 2);
    List<PokemonHeldItemVersion>  pokemonHeldItemVersionListDummy = new ArrayList<>();
    pokemonHeldItemVersionListDummy.add(pokemonHeldItemVersionDummy);
    PokemonHeldItem pokemonHeldItemDummy = new PokemonHeldItem(namedApiResourcedummy, pokemonHeldItemVersionListDummy);
    List<PokemonHeldItem> pokemonHeldItemListDummy = new ArrayList<>();
    pokemonHeldItemListDummy.add(0, pokemonHeldItemDummy);

    PokemonMoveVersion pokemonMoveVersionDummy = new PokemonMoveVersion(namedApiResourcedummy, namedApiResourcedummy, 1);
    List<PokemonMoveVersion> pokemonMoveVersionListDummy = new ArrayList<>();
    pokemonMoveVersionListDummy.add(pokemonMoveVersionDummy);
    PokemonMove pokemonMoveDummy = new PokemonMove(namedApiResourcedummy,pokemonMoveVersionListDummy );
    List<PokemonMove> pokemonMoveListDummy = new ArrayList<>();
    pokemonMoveListDummy.add(0,pokemonMoveDummy);

    PokemonStat pokemonStatDummy = new PokemonStat(namedApiResourcedummy, 1, 2);
    List<PokemonStat> listApokemonStatDummy = new ArrayList<>();
    listApokemonStatDummy.add(0,pokemonStatDummy);

    PokemonType pokemonTypeDumy = new PokemonType(1,namedApiResourcedummy );
    List<PokemonType> pokemonTypeListDummy = new ArrayList<>();
    pokemonTypeListDummy.add(0,pokemonTypeDumy );

    PokemonSprites pokemonSpritesDummy = new PokemonSprites("url", "url", "url", "url", "url", "url" ,"url" , "url");

   Pokemon pokemonDummy = getPokemon(namedApiResourcedummy, namedApiResourceListFormsDummy,
       listAbilitityDummy,
       versionGameIndexListDummy, pokemonHeldItemListDummy, pokemonMoveListDummy,
       listApokemonStatDummy, pokemonTypeListDummy, pokemonSpritesDummy);

   PokemonType pokemonTypeDumyExpect = new PokemonType(1,namedApiResourcedummy );
    List<PokemonType> pokemonTypeListDummyExpect = new ArrayList<>();
    pokemonTypeListDummy.add(0,pokemonTypeDumyExpect );

    PokemonAbility pokemonAbilityDummyExpect = new PokemonAbility(true, 1, namedApiResourcedummy);
    List<PokemonAbility> listAbilitityDummyExpecet = new ArrayList<>();
    listAbilitityDummyExpecet.add(0,pokemonAbilityDummyExpect);

    PokemonSprites pokemonSpritesDummyExpect = new PokemonSprites("url", "url", "url", "url", "url", "url" ,"url" , "url");

    PokemonResponse expect = PokemonResponse.builder().id(1).name("bulbasaur")
        .weight(1).type(pokemonTypeListDummyExpect).
            listAbilities(listAbilitityDummyExpecet).sprites(pokemonSpritesDummyExpect).build();

    PokemonResponse actual = pokemonService.SinglePokemonResponse(pokemonDummy);
    assertEquals(actual.getName(),expect.getName() );

  }


 private Pokemon getPokemon(NamedApiResource namedApiResourcedummy,
     List<NamedApiResource> namedApiResourceListFormsDummy,
     List<PokemonAbility> listAbilitityDummy, List<VersionGameIndex> versionGameIndexListDummy,
     List<PokemonHeldItem> pokemonHeldItemListDummy, List<PokemonMove> pokemonMoveListDummy,
     List<PokemonStat> listApokemonStatDummy, List<PokemonType> pokemonTypeListDummy,
     PokemonSprites pokemonSpritesDummy) {
  return new Pokemon(
        1, "bulbasaur", 1, 1, true, 1,
        1, namedApiResourcedummy, listAbilitityDummy , namedApiResourceListFormsDummy, versionGameIndexListDummy
    , pokemonHeldItemListDummy, pokemonMoveListDummy, listApokemonStatDummy, pokemonTypeListDummy, pokemonSpritesDummy);
 }

 @Test
  public void should_return_all_pokemons_details(){
    PokemonServiceImpl pl = new PokemonServiceImpl();
    pl.getPokemonByid(1);

  }


  @Test
 public void should_return_specific_pokemon_by_id(){


   NamedApiResource namedApiResourcedummy = new NamedApiResource("dummy", "dummy", 1);

   Description description = new Description("dummy",namedApiResourcedummy);
   List<Description>  descriptionListDummy = new ArrayList<>();
   descriptionListDummy.add(0, description);

   List<Integer> integerListDummy = new ArrayList<>();
   integerListDummy.add(0, 1);
   integerListDummy.add(1, 12);

   EvolutionDetail evolutionDetail = new EvolutionDetail(namedApiResourcedummy,null,1,namedApiResourcedummy,namedApiResourcedummy,namedApiResourcedummy,namedApiResourcedummy,1,2,2,1,namedApiResourcedummy,namedApiResourcedummy,1,"",namedApiResourcedummy,false,false);
   List<EvolutionDetail> evolutionDetailList = new ArrayList<>();
   evolutionDetailList.add(evolutionDetail);

   ChainLink chainLink = new ChainLink(true, namedApiResourcedummy,evolutionDetailList,
       new ArrayList<>());


   EvolutionChain evolutionChainDummy = new EvolutionChain(1,namedApiResourcedummy,chainLink);

   Characteristic characteristiDummy = new Characteristic(1,1,integerListDummy,descriptionListDummy );


   PokemonType pokemonTypeDumy = new PokemonType(1,namedApiResourcedummy );
   List<PokemonType> pokemonTypeListDummy = new ArrayList<>();
   pokemonTypeListDummy.add(0,pokemonTypeDumy );

   PokemonType pokemonTypeDumyExpect = new PokemonType(1,namedApiResourcedummy );
   List<PokemonType> pokemonTypeListDummyExpect = new ArrayList<>();
   pokemonTypeListDummy.add(0,pokemonTypeDumyExpect );

   PokemonAbility pokemonAbilityDummyExpect = new PokemonAbility(true, 1, namedApiResourcedummy);
   List<PokemonAbility> listAbilitityDummyExpecet = new ArrayList<>();
   listAbilitityDummyExpecet.add(0,pokemonAbilityDummyExpect);

   PokemonSprites pokemonSpritesDummyExpect = new PokemonSprites("url", "url", "url", "url", "url", "url" ,"url" , "url");

   PokemonResponse pokemonResponse = PokemonResponse.builder().id(1).name("bulbasaur")
       .weight(1).type(pokemonTypeListDummyExpect).
           listAbilities(listAbilitityDummyExpecet).sprites(pokemonSpritesDummyExpect).build();

   SpecificPokemon specificPokemon = SpecificPokemon.builder().characteristic(characteristiDummy)
       .evolutionChain(evolutionChainDummy).pokemonResponse(pokemonResponse).build();

   ///////////////////////

   NamedApiResource namedApiResourcedummys = new NamedApiResource("dummy", "category", 1);
   List<NamedApiResource> namedApiResourceListFormsDummy = new ArrayList<>();
   namedApiResourceListFormsDummy.add(0, namedApiResourcedummys);


   PokemonAbility pokemonAbilityDummy = new PokemonAbility(true, 1, namedApiResourcedummy);
   List<PokemonAbility> listAbilitityDummy = new ArrayList<>();
   listAbilitityDummy.add(0,pokemonAbilityDummy);

   VersionGameIndex versionGameIndexDummy = new VersionGameIndex(1,namedApiResourcedummy );
   List<VersionGameIndex> versionGameIndexListDummy = new ArrayList<>();
   versionGameIndexListDummy.add(0, versionGameIndexDummy);

   PokemonHeldItemVersion pokemonHeldItemVersionDummy = new PokemonHeldItemVersion(namedApiResourcedummy, 2);
   List<PokemonHeldItemVersion>  pokemonHeldItemVersionListDummy = new ArrayList<>();
   pokemonHeldItemVersionListDummy.add(pokemonHeldItemVersionDummy);
   PokemonHeldItem pokemonHeldItemDummy = new PokemonHeldItem(namedApiResourcedummy, pokemonHeldItemVersionListDummy);
   List<PokemonHeldItem> pokemonHeldItemListDummy = new ArrayList<>();
   pokemonHeldItemListDummy.add(0, pokemonHeldItemDummy);

   PokemonMoveVersion pokemonMoveVersionDummy = new PokemonMoveVersion(namedApiResourcedummy, namedApiResourcedummy, 1);
   List<PokemonMoveVersion> pokemonMoveVersionListDummy = new ArrayList<>();
   pokemonMoveVersionListDummy.add(pokemonMoveVersionDummy);
   PokemonMove pokemonMoveDummy = new PokemonMove(namedApiResourcedummy,pokemonMoveVersionListDummy );
   List<PokemonMove> pokemonMoveListDummy = new ArrayList<>();
   pokemonMoveListDummy.add(0,pokemonMoveDummy);

   PokemonStat pokemonStatDummy = new PokemonStat(namedApiResourcedummy, 1, 2);
   List<PokemonStat> listApokemonStatDummy = new ArrayList<>();
   listApokemonStatDummy.add(0,pokemonStatDummy);


   PokemonSprites pokemonSpritesDummy = new PokemonSprites("url", "url", "url", "url", "url", "url" ,"url" , "url");


   Pokemon pokemonDummy = getPokemon(namedApiResourcedummy, namedApiResourceListFormsDummy,
       listAbilitityDummy,
       versionGameIndexListDummy, pokemonHeldItemListDummy, pokemonMoveListDummy,
       listApokemonStatDummy, pokemonTypeListDummy, pokemonSpritesDummy);


   PokemonResponse pokemonResponseExpect = PokemonResponse.builder().id(1).name("bulbasaur")
       .weight(1).type(pokemonTypeListDummyExpect).
           listAbilities(listAbilitityDummyExpecet).sprites(pokemonSpritesDummyExpect).build();


/*   when(this.pokeApi.getCharacteristic(1)).thenReturn(characteristiDummy);
   when(this.pokeApi.getEvolutionChain(1)).thenReturn(evolutionChainDummy);
   when(this.service.SinglePokemonResponse(pokemonDummy)).thenReturn(pokemonResponseExpect);*/

   SpecificPokemon expect = SpecificPokemon.builder()
       .characteristic(characteristiDummy)
       .evolutionChain(evolutionChainDummy)
       .pokemonResponse(pokemonResponseExpect).build();

   PokemonServiceImpl pokemonService = new PokemonServiceImpl();
   SpecificPokemon actual = pokemonService.getPokemonByid(1);

assertTrue(actual.pokemonResponse.getName().equals(expect.pokemonResponse.getName()));

 }

}
