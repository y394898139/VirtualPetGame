package com.aut.pdc.mike.gamemodel;

/**
 * This class represents a food that can be used in the game.
 *
 * @author Minghao Yang
 */
public class Food extends Item {

    private int energy;

    /**
     * Construct a food object with known attributes.
     *
     * @param name
     * @param description
     * @param energy
     */
    public Food(String name, String description, int energy) {
        super(name, description);
        this.energy = energy;
    }

    /**
     * Constructor with no parameters
     */
    public Food() {
        super();
    }

    /**
     * Return the energy value of the food
     *
     * @return
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Set each food's energy value
     *
     * @param energy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
