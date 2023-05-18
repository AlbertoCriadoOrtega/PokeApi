package org.infantaelena.modelo.entidades;
/**
 * Clase que representa a un pokemon
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class Pokemon {

    public String nombre;
    private Type tipo;
    private String Habilities;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;


    public Pokemon(String nombre, Type type, String habilities, int vida, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.tipo = type;
        Habilities = habilities;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public Pokemon() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

    public String getHabilities() {
        return Habilities;
    }

    public void setHabilities(String habilities) {
        Habilities = habilities;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        return nombre.equals(pokemon.nombre);
    }

}
