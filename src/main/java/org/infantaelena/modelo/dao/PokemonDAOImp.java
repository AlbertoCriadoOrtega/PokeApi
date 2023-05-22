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
        try (Statement st = conection.createStatement()) {
            String query = "INSERT INTO pokemon (nombre, tipo, habilidades, vida, ataque, defensa, velocidad) " +
                    "VALUES ('" + pokemon.getNombre() +
                    "', '" + pokemon.getTipo() +
                    "', '" + pokemon.getHabilidades() +
                    "', " + pokemon.getVida() +
                    ", " + pokemon.getAtaque() +
                    ", " + pokemon.getDefensa() +
                    ", " + pokemon.getVelocidad() +
                                ")";
            st.executeUpdate(query);
        } catch (SQLException e ) {
            System.err.println("Error al insertar pokemon: " + e.getMessage());
        }
    }


    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        try(Statement st = conection.createStatement()){
            st.executeUpdate( "SELECT * FROM pokemon WHERE nombre = '" + nombre);
        } catch (SQLException e) {
            System.err.println();
        }
        return null;//esta a null por que no se como hacer este método, luego lo veo
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
        try(Statement st = conection.createStatement()) {
            st.executeUpdate( "UPDATE pokemon SET tipo = '" + pokemon.getTipo() +
                    "', habilidades = '" + pokemon.getHabilidades()+
                    "', vida = '" + pokemon.getVida() +
                    "', ataque = " + pokemon.getAtaque() +
                    ", defensa = " + pokemon.getDefensa() +
                    ", velocidad = " + pokemon.getVelocidad() +
                    " WHERE nombre = '" + pokemon.getNombre());
            System.out.println("Pokemon actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar pokemon");
        }


    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
       try(Statement st = conection.createStatement()){
          st.executeUpdate("DELETE pokemon from pokemon nombre = " + nombre );
       }catch (SQLException e){
           System.err.println("El pokemon no se ha podido eliminar");
       }
    }
}
