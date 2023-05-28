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
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o **una base de datos**
 *
 * @author
 * @version 1.0
 * @date 24/04/2023
 */
public class PokemonDAOImp implements PokemonDAO {

    private Connection connection;

    public PokemonDAOImp() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:bbdd/Pokeapi.db");
            System.out.println("Conexión establecida con la base de datos");
            crearTabla();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearTabla() {
        try {
            connection.createStatement().executeUpdate(
                    "CREATE TABLE IF NOT EXISTS pokemon (" +
                            "nombre varchar(30) primary key ," +
                            "tipo varchar(30)," +
                            "habilidades varchar(255) ," +
                            "vida int(30)," +
                            "ataque int," +
                            "defensa int," +
                            "velocidad int)");
            System.out.println("Tabla creada con éxito");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla" + e.getMessage());
        }
    }

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        try (Statement st = connection.createStatement()) {
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
        } catch (SQLException e) {
            System.err.println("Error al insertar pokemon: " + e.getMessage());
        }
    }


    public Pokemon SacarPokemonLeerUno(String nombre) {
        try (Statement st = connection.createStatement()) {
            String query = "SELECT * FROM pokemon WHERE nombre = '" + nombre.trim() + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNombre(nombre.trim().toUpperCase());
                pokemon.setTipo(Type.valueOf(rs.getString("tipo")));
                pokemon.setVida(rs.getInt("vida"));
                pokemon.setAtaque(rs.getInt("ataque"));
                pokemon.setDefensa(rs.getInt("defensa"));
                return pokemon;
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

        return null;
    }


    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        Pokemon pokemon = null;

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pokemon WHERE nombre = '" + nombre.trim() + "'");


            if (rs.next()) {
                String nombreP = rs.getString("nombre");
                pokemon = new Pokemon(nombreP);
                return pokemon;
            } else {
                throw new PokemonNotFoundException("No se encontró un Pokémon con el nombre: " + nombre.trim());
            }

        } catch (SQLException e) {
            System.err.println("Error al listar personas" + e.getMessage());
        }

        return pokemon;
    }


    @Override
    public List<Pokemon> leerTipo(String tipo) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pokemon WHERE tipo = '" + tipo.trim() + "'");
            while (rs.next()) {
                pokemons.add(new Pokemon(rs.getString("nombre")));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al listar personas");
        }

        return pokemons;
    }

    @Override
    public List<Pokemon> leerTipo() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pokemon");
            while (rs.next()) {
                pokemons.add(new Pokemon(rs.getString("nombre")));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al listar personas");
        }

        return pokemons;
    }


    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        String query = "UPDATE pokemon SET tipo=?, habilidades=?, vida=?, ataque=?, defensa=?, velocidad=? WHERE nombre=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, String.valueOf(pokemon.getTipo()));
            st.setString(2, pokemon.getHabilidades());
            st.setInt(3, pokemon.getVida());
            st.setInt(4, pokemon.getAtaque());
            st.setInt(5, pokemon.getDefensa());
            st.setInt(6, pokemon.getVelocidad());
            st.setString(7, pokemon.getNombre());

            int filasActualizadas = st.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Pokemon actualizado correctamente");
            } else {
                throw new PokemonNotFoundException("El Pokemon no se encontró en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Pokemon: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        try (Statement st = connection.createStatement()) {
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


