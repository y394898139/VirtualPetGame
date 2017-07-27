package com.aut.pdc.mike.gamemodel;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class represents a player in the game.
 *
 * @author Minghao Yang
 *
 */
public class Player {

    private Pet pet;
    Scanner scan = new Scanner(System.in);
    private String name;
    private String password;
    private ArrayList foodArrayList;
    private ArrayList toyArrayList;

    private VirtualPetGame petDB = new VirtualPetGame();
    /**
     * Constructor with no attributes
     */
    public Player() {
        
    }

    /**
     * Construct a player object with known attributes.
     *
     * @param name
     * @param password
     */
    public Player(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    /**
     * The method is used to ensure the player can create a new personal account
     * if he/she hasn't got a account yet.
     */
    public String createAccount(String userName, String password) {
        if (petDB.createPlayerAccount(userName, password)) {
            return "Sorry, the user name is existed. ";
        } else {
            return "Congratulations! The register operation is successful.";
        }
    }

    /**
     * If the player has created a account, he/she can input his/her user name
     * and password to login in. The user has three opportunities to enter the
     * user name and password, if it is still unsuccessful will quit the game
     */
    public String login(String username, String password) {
        /**
         * According to the loginCheck method return value to check whether the
         * login is successful
			 *
         */
        String message = "";
        int check = this.loginCheck(username, password);
        if (check == 1) {
            this.setName(username);
            this.setPassword(password);
            this.getPetByName(username);
            message = "Successfully Login!\nWelcomen to virtual pet game, " + name + "!";

        } else if (check == 0) {
            message = "The user name is not existed.";
        } else {
            message = "You have entered a wrong password.";
        }
        return message;
    }

    /**
     * The method is used to check the player's input of the user name and
     * password If the input is correct and the method will return 1, or return
     * -1
     *
     * @param name
     * @param password
     * @return
     */
    public int loginCheck(String name, String password) {
        return petDB.loginCheck(name, password);
    }

    /**
     * Get the user name of the player
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user name of the player
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the password of the player
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the player
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the pet object of the player
     *
     * @return
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set the pet object of the player
     *
     * @param pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Get food list
     *
     * @return
     */
    public ArrayList getFoodArrayList() {
        return foodArrayList;
    }

    /**
     * Get the toy list
     *
     * @return
     */
    public ArrayList getToyArrayList() {
        return toyArrayList;
    }

    /**
     * If the player has not got a pet, this method will help player to adopt a
     * new pet. The created pet object will be a parameter of the player object
     */
    public String adopt() {
        String message;
        this.pet = new Pet();
        this.pet.setName("Luson");
        this.pet.setAlive(true);
        this.pet.setAge(0.0);
        this.pet.setHappiness(100);
        this.pet.setEnergy(100);
        this.pet.setHealth(100);
        this.pet.setStrain("Schnauzer");
        message = "Congratulations!! You've got the Luson!";
        return message;
    }

    /**
     * Player can feed the pet and the pet will restore the starvation/
     */
    public String feed(Food food) {
        String message = null;
        this.pet.setEnergy(this.pet.getEnergy() + food.getEnergy());
        if (this.pet.getEnergy() >= 100) {
            this.pet.setEnergy(100);
            message = "You feed your pet too much! It's not good for your pet's health!!";
            this.pet.setHealth(this.pet.getHealth() - 30);

        } else {
            message = "Luson has eaten the " + food.getName() + " and has restored " + food.getEnergy() + " energy.";
        }
        return message;
    }

    /**
     * Player can play with the pet and the pet will restore the happiness
     */
    public String playWithPet(Toys toy) {
        String message = null;
        this.pet.setHappiness(this.pet.getHappiness() + toy.getHappiness());     
        this.pet.setEnergy(this.pet.getEnergy() - toy.getEnergyCost());
        if (this.pet.getHappiness() >= 100) {
            this.pet.setHappiness(100);
        }
        message = "Luson has restored " + toy.getHappiness() + " happiness and cost it " + toy.getEnergyCost() + " energy.";
        return message;
    }

    /**
     * If the pet's health is not good, then the player can cure the pet to
     * restore its health
     */
    public String cure() {
        String message = null;
        Vet vet = new Vet();
        if (this.pet.getHealth() > 70) {
            message = "Your pet's health is fine, it doesn't need to be cure.";
        } else {
            this.pet.setHealth(this.pet.getHealth() + vet.cure());
            message = "Luson has been treated.";
            if (this.pet.getHealth() > 100) {
                this.pet.setHealth(100);
                message = "Your pet is in good health! Don't worry!";
            }
        }
        return message;
    }

    /**
     * This method will be used in the login method. If the player successfully
     * log in and the player has adopted a pet, the player will get the stored
     * pet object by player's user name
     *
     * @param name
     */
    public void getPetByName(String name) {
        if (petDB.getPetByPlayerName(name) != null) {
            this.pet = petDB.getPetByPlayerName(name);
        } else {
            this.adopt();
        }
    }

    /**
     * Save the current pet's information according to the player's user name
     *
     * @param userName
     */
    public void saveAndExit(String userName) {
        Pet pet = new Pet();
        pet = petDB.getPetByPlayerName(userName);
        if (pet.getName() != null) {
            petDB.saveGameIfPetExists(userName, this.pet);
        } else {
            petDB.saveNewPet(userName, this.pet);
        }
        //Close the program
        System.exit(0);
    }

    /**
     * Read the item information.
     */
    public void readItemInfo() {
        this.foodArrayList = petDB.readFoodTable();
        this.toyArrayList = petDB.readToyTable();
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", password=" + password + "]";
    }

}
