package com.aut.pdc.mike.gamemodel;

/**
 * This class represents a toy that can be used in the game.
 *
 * @author Minghao Yang
 *
 */
public class Toys extends Item {

    private int happiness;
    private int energyCost;

    /**
     * Construct a toy object with known attributes.
     *
     * @param name
     * @param description
     * @param happiness
     */
    public Toys(String name, String description, int happiness, int energyCost) {
        super(name, description);
        this.happiness = happiness;
        this.energyCost = energyCost;
    }

    /**
     * Constructor
     */
    public Toys() {
        super();
    }

    /**
     * Get the happiness that toy can restore
     *
     * @return
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Set the happiness that toy can restore
     *
     * @param happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * Get the energy cost of the toy
     *
     * @return
     */
    public int getEnergyCost() {
        return energyCost;
    }

    /**
     * Set the energy cost of the toy
     *
     * @param energy
     */
    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

}
