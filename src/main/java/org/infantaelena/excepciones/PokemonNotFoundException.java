package org.infantaelena.excepciones;
/**
 *
 * Esta clase se encarga de lanzar una excepción cuando no se encuentra un pokemon
 * @author Alberto Criado
 * @version 1.0
 * @date 08/05/2023
 *
 */
public class PokemonNotFoundException extends Exception {

    public PokemonNotFoundException(String mensaje) {
        super(mensaje);
    }
}
