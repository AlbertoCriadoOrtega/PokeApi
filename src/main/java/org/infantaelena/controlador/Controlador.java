package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Type;
import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author
 * @version 1.0
 * @date 24/04/2023
 */


public class Controlador {

    private Vista vista;
    private PokemonDAOImp modelo;

    public Controlador() {
        vista = new Vista();
        modelo = new PokemonDAOImp();

        Pokemon pokemon1 = new Pokemon("Bulbasur",Type.Planta,"Latigo cepa; Drenadora", 100,100,100,50);
        Pokemon pokemon3 = new Pokemon("Charmander",Type.Fuego,"Ascuas; Pantalla Humo", 100,100,100,50);
        Pokemon pokemon2 = new Pokemon("Squirtle",Type.Agua,"Pistola agua; Burbuja", 100,100,100,50);
        try {
            modelo.crear(pokemon1);
            modelo.crear(pokemon2);
            modelo.crear(pokemon3);
        } catch (PokemonRepeatedException e) {
            throw new RuntimeException(e);
        }

        try {
            vista.getBtnCrear().addActionListener(e -> {
                insertar();
            });

            vista.getBtnBorrar().addActionListener(e -> {
                borrar();
            });

            vista.getBtnBuscar().addActionListener(e -> {
                try {
                    vista.getAtributosTableModel().setRowCount(0);
                    LeerNombre();
                } catch (PokemonNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });

            vista.getBtnFiltrar().addActionListener(e -> {
                vista.getAtributosTableModel().setRowCount(0);
                LeerTipo();
            });

            vista.getBtnListar().addActionListener(e -> {
                vista.getAtributosTableModel().setRowCount(0);
                LeerTodos();
            });

            vista.getBtnModificar().addActionListener(e -> {
                actualizar();
            });
        } catch (RuntimeException e){}
        catch (Exception e){}

    }

    public Pokemon crearPokemon() {
        String nombre = String.valueOf(vista.getNombre().getText());
        Type tipo = Type.valueOf((String) vista.getTipo().getSelectedItem());
        String habilidades = String.valueOf(vista.getHabilidades().getText());
        int vida = Integer.parseInt(vista.getHp().getText());
        int ataque = Integer.parseInt(vista.getHp().getText());
        int defensa = Integer.parseInt(vista.getAtaque().getText());
        int velocidad = Integer.parseInt(vista.getDefensa().getText());

        Pokemon pokemon = new Pokemon(nombre, tipo, habilidades, vida, ataque, defensa, velocidad);
        return pokemon;
    }

    public void insertar() {
        try {
            modelo.crear(crearPokemon());
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText()+ " se ha añadido correctamente", "Añadido correctamente", JOptionPane.INFORMATION_MESSAGE);
        } catch (PokemonRepeatedException e) {
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText()+" "+ e.getMessage(), "insercion incorrecta", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }


    public void borrar() {
        try {
            modelo.eliminarPorNombre(String.valueOf(vista.getNombre().getText()));
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText() + " se ha borrado correctamente", "borrado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } catch (PokemonNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText()+" "+ e.getMessage(), "borrado incorrecto", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void actualizar() {
        try {
            modelo.actualizar(crearPokemon());
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText() + " se ha actualizado correctamente", "actualizado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } catch (PokemonNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El pokemon " + vista.getNombre().getText()+" "+ e.getMessage(), "actualizacion no posible", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void LeerNombre() throws PokemonNotFoundException {
       try{
            Pokemon pokemon = modelo.leerPorNombre(vista.getNombre().getText());
            Object[] rowData = new Object[]{
                    pokemon.getNombre(),
                    pokemon.getTipo(),
                    pokemon.getHabilidades(),
                    pokemon.getVida(),
                    pokemon.getAtaque(),
                    pokemon.getDefensa(),
                    pokemon.getVelocidad()
            };
            vista.getAtributosTableModel().addRow(rowData);
       } catch (PokemonNotFoundException e){
           System.out.println(e.getMessage());
       }
    }

    public void LeerTodos(){
        for(Pokemon pokemon : modelo.leerTodos()){
            Object[] rowData = new Object[]{
                    pokemon.getNombre(),
                    pokemon.getTipo(),
                    pokemon.getHabilidades(),
                    pokemon.getVida(),
                    pokemon.getAtaque(),
                    pokemon.getDefensa(),
                    pokemon.getVelocidad()
            };
            vista.getAtributosTableModel().addRow(rowData);
        }
    }

    public void LeerTipo() {
        for(Pokemon pokemon : modelo.leerTipo(String.valueOf(vista.getTipo().getSelectedItem()))){
            Object[] rowData = new Object[]{
                    pokemon.getNombre(),
                    pokemon.getTipo(),
                    pokemon.getHabilidades(),
                    pokemon.getVida(),
                    pokemon.getAtaque(),
                    pokemon.getDefensa(),
                    pokemon.getVelocidad()
            };
            vista.getAtributosTableModel().addRow(rowData);
        }
    }


}
