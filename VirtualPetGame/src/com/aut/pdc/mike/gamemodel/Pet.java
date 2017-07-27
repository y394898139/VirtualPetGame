package com.aut.pdc.mike.gamemodel;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Pet Class
 *
 * @author Minghao Yang
 *
 */
public class Pet {

    private String name;
    private int energy;
    private int happiness;
    private double health;
    private double age;
    private boolean alive;
    private String strain;

    public Pet() {
        super();
    }

    /**
     * Construct a pet object with known attributes.
     *
     * @param name
     * @param energy
     * @param happiness
     * @param health
     * @param age
     * @param strain
     */
    public Pet(String name, int energy, int happiness, double health, double age, boolean alive, String strain) {
        super();
        this.name = name;
        this.energy = energy;
        this.happiness = happiness;
        this.health = health;
        this.age = age;
        this.alive = alive;
        this.strain = strain;
    }

    /**
     * Get the name of the pet
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the pet
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the energy of the pet
     *
     * @return
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Set the energy of the pet
     *
     * @param energy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Get the happiness of the pet
     *
     * @return
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Set the happiness of the pet
     *
     * @param happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * Get the health of the pet
     *
     * @return
     */
    public double getHealth() {
        return health;
    }

    /**
     * Set the health of the pet
     *
     * @param health
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Get the age of the pet
     *
     * @return
     */
    public double getAge() {
        return age;
    }

    /**
     * Set the pet of the pet
     *
     * @param age
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * Get the strain of the pet
     *
     * @return
     */
    public String getStrain() {
        return strain;
    }

    /**
     * Set the strain of the pet
     *
     * @param strain
     */
    public void setStrain(String strain) {
        this.strain = strain;
    }

    /**
     * Get the survival state of the pet
     *
     * @return
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Get the pet's live situation
     *
     * @return
     */
    public String AliveString() {
        if (this.isAlive()) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    /**
     * Set the survival state of the pet
     *
     * @param alive
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Every 10 seconds the pet grows The energy, happiness, health and age of
     * the pet will be changed
     */
    public void grow() {
        this.energy -= 2;
        this.happiness--;
        this.health -= 0.2;
        this.age += 0.05;
    }

    /**
     * Check the situation of the pet. If the situation is not good, give the
     * player a prompt.
     */
    public String situationCheck() {
        String message = "";
        String energyWarn = "";
        String happinessWarn = "";
        String healthWarn = "";
        if (this.energy < 50 && this.energy > 30) {
            energyWarn = "T^T " + this.getName() + " is hungery,please feed him some food.\n";
        } else if (this.energy < 30 && this.energy > 10) {
            energyWarn = "TOT " + this.getName() + " is starve to death, please feed him some food.\n";
        } else if (this.energy < 10) {
            energyWarn = ">.< You really need to feed some food for " + this.getName() + "!!!Right Now!!!\n";
        }

        if (this.happiness < 50 && this.happiness > 20) {
            happinessWarn = "T^T " + this.getName() + " looks sad, please make him happy.\n";
        } else if (this.happiness < 20) {
            happinessWarn = ">.< " + this.getName() + " is really upset, please play with him.\n";
        }
        if (this.health < 50) {
            healthWarn = this.getName() + " looks bad, please pay attention to his health.\n";
        }
        message = energyWarn + happinessWarn + healthWarn;
        return message;
    }

    /**
     * The pet will randomly gets sick. Generate a random integer number, and if
     * the number equals 10, the pet's health will decrease. If the pet gets
     * sick, the health and energy will decrease.
     */
    public void getSick() {
        Random rand = new Random();
        int sickNum = rand.nextInt(20) + 1;
        if (sickNum == 10) {
            this.setHealth(this.getHealth() - 30);
            this.setEnergy(this.getEnergy() - 15);
            this.setHappiness(this.getHappiness() - 10);
        }

    }

    @Override
    public String toString() {
        return "Pet [name=" + name + ", energy=" + energy + ", happiness=" + happiness + ", health="
                + new DecimalFormat("0").format(health) + ", age=" + new DecimalFormat("0").format(age) + ", alive="
                + alive + ", strain=" + strain + "]";
    }

}
