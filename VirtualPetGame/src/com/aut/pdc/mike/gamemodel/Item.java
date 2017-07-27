package com.aut.pdc.mike.gamemodel;

/**
 * This class represents an item that can be used in this game.
 *
 * @author Minghao Yang
 *
 */
public abstract class Item {

    private String name;
    private String desciption;

    /**
     * Constructor with no parameters
     */
    public Item() {
        super();
    }

    /**
     * Construct an item with known attributes.
     *
     * @param name
     * @param desciption
     */
    public Item(String name, String desciption) {
        super();
        this.name = name;
        this.desciption = desciption;
    }

    /**
     * Return the name of the item
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the item
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the description of the item
     *
     * @return
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * Set the description of the item
     *
     * @param desciption
     */
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return name;
    }

}
