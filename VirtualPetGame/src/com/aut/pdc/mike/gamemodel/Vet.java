package com.aut.pdc.mike.gamemodel;

/**
 * This class represents a vet that can be used in the game. It is used to cure
 * the pet.
 *
 * @author Minghao Yang
 *
 */
public class Vet {

    private final int health = 30;

    /**
     * Cure method
     *
     * @return
     */
    public int cure() {
        return health;
    }
}
