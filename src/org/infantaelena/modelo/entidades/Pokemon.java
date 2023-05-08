package org.infantaelena.modelo.entidades;
/**
 * Clase que representa a un pokemon
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class Pokemon {

    private int health;
    private int atack;
    private int defense;
    private int speed;
    private Type type;
    private String Habilities;

    public Pokemon(int health, int atack, int defense, int speed, Type type, String habilities) {
        this.health = health;
        this.atack = atack;
        this.defense = defense;
        this.speed = speed;
        this.type = type;
        Habilities = habilities;
    }

    public Pokemon() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getHabilities() {
        return Habilities;
    }

    public void setHabilities(String habilities) {
        Habilities = habilities;
    }
}
