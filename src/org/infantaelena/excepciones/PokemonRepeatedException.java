package org.infantaelena.excepciones;

/**
 *
 * Esta clase se encarga de lanzar una excepción cuando se intenta añadir un pokemon repetido
 * @author Alberto Criado
 * @version 1.0
 * @date 08/05/2023
 *
 */
public class PokemonRepeatedException extends Exception{

    public PokemonRepeatedException(String mensaje) {
        super(mensaje);
    }
}
