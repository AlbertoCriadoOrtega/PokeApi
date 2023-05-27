package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.modelo.entidades.Type;

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
    private Connection connection;

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
                            "nombre varchar(30) primary key ," +
                            "tipo varchar(30),"+
                            "habilidades varchar(255) ," +
                            "vida int(30)," +
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


    public Pokemon SacarPokemonLeerUno(String nombre) {
        try (Statement st = connection.createStatement()) {
            String query = "SELECT * FROM pokemon WHERE nombre = '" + nombre + "'";
            ResultSet rs = st.executeQuery(query);

            String nombreP = rs.getString("nombre");
            Type tipo = Type.valueOf(rs.getString("tipo"));
            String habilidades = rs.getString("habilidades");
            int vida = rs.getInt("vida");
            int ataque = rs.getInt("ataque");
            int defensa = rs.getInt("defensa");
            int velocidad = rs.getInt("velocidad");
            Pokemon pokemon = new Pokemon(nombreP, tipo, habilidades, vida, ataque, defensa, velocidad);

            return pokemon;
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

        return null;
    }


    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        Pokemon pokemon = null;

        try (Statement st = connection.createStatement()) {
            String query = "SELECT * FROM pokemon WHERE nombre = '" + nombre + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                pokemon = SacarPokemonLeerUno(nombre);
            } else {
                throw new PokemonNotFoundException("Pokemon not found with name: " + nombre);
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

        try {
            if (pokemon == null) {
                throw new PokemonNotFoundException("Pokemon no encontrado");
            }
        } catch (PokemonNotFoundException e) {
            System.err.println("Pokemon no encontrado");
        }

        return pokemon;
    }

    public Pokemon SacarPokemonLeerTodos() {
        try (Statement st = connection.createStatement()) {
            String query = "SELECT * FROM pokemon";
            ResultSet rs = st.executeQuery(query);

            String nombreP = rs.getString("nombre");
            Type tipo = Type.valueOf(rs.getString("tipo"));
            String habilidades = rs.getString("habilidades");
            int vida = rs.getInt("vida");
            int ataque = rs.getInt("ataque");
            int defensa = rs.getInt("defensa");
            int velocidad = rs.getInt("velocidad");
            Pokemon pokemon = new Pokemon(nombreP, tipo, habilidades, vida, ataque, defensa, velocidad);

            return pokemon;

        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

        return null;
    }



    @Override
    public List<Pokemon> leerTodos() {
        Pokemon pokemon;
        List<Pokemon> pokemonList = new ArrayList<>();

        List<Pokemon> devuelve = new ArrayList<>();
        //Seleccionamos el pokemon por el tipo
        try(Statement st = conection.createStatement()) {
            String query = "Select * from pokemon";
            ResultSet rs = st.executeQuery(query);

            do {
                if (rs.next()) {
                    pokemon = SacarPokemonLeerTodos();
                    devuelve.add(pokemon);
                }

            }while (rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < pokemonList.size(); i++) {
            devuelve.add(pokemonList.get(i));
        }

        return devuelve;
    }

    public Pokemon SacarPokemonLeerTipo(String type) {
        try (Statement st = connection.createStatement()) {
            String query = "SELECT * FROM pokemon WHERE nombre = '" + type + "'";
            ResultSet rs = st.executeQuery(query);

            String nombreP = rs.getString("nombre");
            Type tipo = Type.valueOf(rs.getString("tipo"));
            String habilidades = rs.getString("habilidades");
            int vida = rs.getInt("vida");
            int ataque = rs.getInt("ataque");
            int defensa = rs.getInt("defensa");
            int velocidad = rs.getInt("velocidad");
            Pokemon pokemon = new Pokemon(nombreP, tipo, habilidades, vida, ataque, defensa, velocidad);

            return pokemon;
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Pokemon> leerTodos(String tipo) {
        Pokemon pokemon;
        List<Pokemon> pokemonList = new ArrayList<>();

        List<Pokemon> devuelve = new ArrayList<>();
        //Seleccionamos el pokemon por el tipo
        try(Statement st = conection.createStatement()) {
            String query = "SELECT * FROM pokemon WHERE tipo = '" + tipo + "'";
            ResultSet rs = st.executeQuery(query);

            do {
                if (rs.next()) {
                    pokemon = SacarPokemonLeerTipo(tipo);
                    devuelve.add(pokemon);
                }

            }while (rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < pokemonList.size(); i++) {
            devuelve.add(pokemonList.get(i));
        }

        return devuelve;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        try(Statement st = conection.createStatement()) {
            st.executeUpdate( "UPDATE pokemon SET  = '" + pokemon.getTipo() +
                    "', habilidades = '" + pokemon.getHabilidades()+
                    "', vida = '" + pokemon.getVida() +
                    "', ataque = " + pokemon.getAtaque() +
                    ", defensa = " + pokemon.getDefensa() +
                    ", velocidad = " + pokemon.getVelocidad() +
                    " WHERE nombre = '" + pokemon.getNombre());
            System.out.println("Pokemon actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar pokemon"+ e.getMessage());
        }


    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        try (Statement st = conection.createStatement()) {
            String query = "DELETE FROM pokemon WHERE nombre = '" + nombre + "'";
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected == 0) {
                throw new PokemonNotFoundException("El pokemon no se ha podido eliminar");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el pokemon: " + e.getMessage());
        }
    }
}
