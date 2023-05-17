package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o una base de datos
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class PokemonDAOImp implements PokemonDAO{

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        List<Pokemon> pokemonList = new ArrayList<>();

        if (pokemonList.contains(pokemon)) {
            throw new PokemonRepeatedException("El Pokémon ya existe en la lista.");
        }

        pokemonList.add(pokemon);
    }

    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < pokemonList.size(); i++) {
            if (nombre == pokemonList.get(i).getNombre()){
                return pokemonList.get(i);
            }
        }
        try {
            throw new PokemonNotFoundException("no se encuentra el pokemon que se busca");
        } catch (PokemonNotFoundException e){
            return null;
        }
    }

    @Override
    public List<Pokemon> leerTodos() {
        List<Pokemon> pokemonList = new ArrayList<>();

        List<Pokemon> devuelve = new ArrayList<>();

        for (int i = 0; i < pokemonList.size(); i++) {
            devuelve.add(pokemonList.get(i));
        }

        return devuelve;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < pokemonList.size(); i++) {
            if (pokemon.equals(pokemonList.get(i))){

            }
        }


    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < pokemonList.size(); i++) {
            if (nombre == pokemonList.get(i).getNombre()){
                pokemonList.remove(pokemonList.get(i));
            }
        }
    }
}
