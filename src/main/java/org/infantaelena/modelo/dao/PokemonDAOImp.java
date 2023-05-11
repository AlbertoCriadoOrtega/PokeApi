package org.infantaelena.modelo.dao;


import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.sql.*;
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

    private Connection conection;

    public PokemonDAOImp() {
        try {
            this.conection = DriverManager.getConnection("jdbc:sqlite:bbdd/personas.db");
            System.out.println("Conexión establecida con la base de datos");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
        }
    }


    /* <!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.36.0.3</version>
    </dependency>


    */

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
    }

    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        return null;
    }

    @Override
    public List<Pokemon> leerTodos() {
        return null;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {

    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {

    }
}
