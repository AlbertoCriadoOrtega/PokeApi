package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o **una base de datos**
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class PokemonDAOImp implements PokemonDAO{

    Connection conection;

    public PokemonDAOImp(){
        try {
            Class.forName("org.sqlite.JDBC");
            this.conection = DriverManager.getConnection("jdbc:sqlite:bbdd/Pokeapi.db");
            System.out.println("Conexión establecida con la base de datos");
            crearTabla();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearTabla() {
        try {
            conection.createStatement().executeUpdate(
                    "CREATE TABLE IF NOT EXISTS pokemon (" +
                            "nombre string primary key ," +
                            "tipo varchar(30),"+
                            "habilidades varchar(255) ," +
                            "vida varchar(30)," +
                            "ataque int," +
                            "defensa int," +
                            "velocidad int)");
            System.out.println("Tabla creada con éxito");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla"+e.getMessage());
        }
    }

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        try(Statement st = conection.createStatement()){
            st.executeUpdate("INSERT INTO pokemon (nombre) VALUES ('"+pokemon.getNombre()+"')");
        } catch (SQLException e){
            System.err.println("Error al insertar persona");
        }
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
            /* UPDATE POKEMON SET "DATOS" WHERE POKEMON.NAME = POKEMON.NAMEeXT */
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
