package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Type;
import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;

/**
 *
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */


public class Controlador {

    private Vista vista;
    private PokemonDAOImp modelo;

    public Controlador() {
        vista = new Vista();
        modelo = new PokemonDAOImp();

       /* Pokemon pokemon = new Pokemon("Squirlte", Type.Agua,"Pistola agua;Burbuja",100,100,100,100);
        insertar(pokemon);*/
        //LeerNombre("Squirtle");
        Pokemon pokemon = new Pokemon("Squirlte", Type.Agua,"Pistola agua;Burbuja",200,200,100,100);
        actualizar(pokemon);
    }

    public void insertar(Pokemon pokemon) {
        try{
            modelo.crear(pokemon);
        } catch (PokemonRepeatedException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(String nombre) {
        try{
            modelo.eliminarPorNombre(nombre);
        } catch (PokemonNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void actualizar(Pokemon pokemon) {
        try {
            modelo.actualizar(pokemon);
        } catch (PokemonNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    public void LeerNombre(String nombre){
        Pokemon pokemon;
        try {
            pokemon = modelo.leerPorNombre(nombre);
            pokemon.toString();
        } catch (PokemonNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void LeerTodos(String nombre){
        try {
            modelo.leerPorNombre(nombre);
        } catch (PokemonNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void LeerTipo(String nombre){
        try {
            modelo.leerPorNombre(nombre);
        } catch (PokemonNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
