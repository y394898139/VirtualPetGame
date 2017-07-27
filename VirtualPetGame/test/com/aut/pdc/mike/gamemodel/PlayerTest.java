/*
 *Junit Test for the Player class
 */
package com.aut.pdc.mike.gamemodel;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Player Test
 * @author Minghao Yang
 */
public class PlayerTest {
    
    public PlayerTest() {
       
    }
    
   

    /**
     * Test of createAccount method, of class Player.
     * The user name is not existed and successfully create a new account
     */
    @Test
    public void testCreateAccountSuccessful() {
        System.out.println("createAccountSuccess");
        String userName = "PLAYERTEST";
        String password = "123456";
        Player instance = new Player();
        String result = instance.createAccount(userName, password);
        System.out.println(result);
    }
    
     /**
     * Test of createAccount method, of class Player.
     * If the user name is already exsited
     */
    @Test
    public void testCreateAccountFail() {
        System.out.println("createAccountFail");
        String userName = "JUST4TEST";
        String password = "123456";
        Player instance = new Player();
        String result = instance.createAccount(userName, password);
        System.out.println(result);
    }

    /**
     * Test of login method, of class Player.
     * If the the account is existed, successfully login 
     */
    @Test
    public void testLoginSuccess() {
        System.out.println("loginSuccess");
        String username = "PLAYERTEST";
        String password = "123456";
        Player instance = new Player();
        String result = instance.login(username, password);
        System.out.println(result);
    }

    /**
     * Test of login method, of class Player.
     * If the the account is not existed, fail login 
     */
    @Test
    public void testLoginSuccessFail() {
        System.out.println("loginFail");
        String username = "PLAYERTEST";
        String password = "123456";
        Player instance = new Player();
        String result = instance.login(username, password);
        System.out.println(result);
    }
    
    /**
     * Test of loginCheck method, of class Player.
     * The account is existed and the login check is successful
     */
    @Test
    public void testLoginCheckSuccess() {
        System.out.println("loginCheckSuccess");
        String name = "PLAYERTEST";
        String password = "123456";
        Player instance = new Player();
        int expResult = 1;
        int result = instance.loginCheck(name, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of loginCheck method, of class Player.
     * The account is not existed and the login check is fail
     */
    @Test
    public void testLoginCheckFail() {
        System.out.println("loginCheckFail");
        String name = "NOSUCHUSER";
        String password = "123456";
        Player instance = new Player();
        int expResult = 0;
        int result = instance.loginCheck(name, password);
        assertEquals(expResult, result);
    }


    /**
     * Test of adopt method, of class Player.
     */
    @Test
    public void testAdopt() {
        System.out.println("adopt");
        Player instance = new Player("PLAYERTEST","123456");
        String result = instance.adopt();
        System.out.println(result);
    }

    
    /**
     * Test of feed method, of class Player.
     */
    @Test
    public void testFeed() {
        System.out.println("feed");
        Food food = new Food("Beef","It can restore 15 starvation for the pet",15);
        Player instance = new Player("JUST4TEST","123123");
        instance.setPet(new Pet("FeedTest", 40, 70, 80, 0, true, "Test"));
        String result = instance.feed(food);
        System.out.println(result);
        System.out.println(instance.getPet());
    }

    /**
     * Test of playWithPet method, of class Player.
     */
    @Test
    public void testPlayWithPet() {
        System.out.println("playWithPet");
        Toys toy = new Toys("Test", "Test", 20, 10);
        Player instance = new Player("JUST4TEST","123123");
        instance.setPet(new Pet("FeedTest", 40, 70, 80, 0, true, "Test"));
        String result = instance.playWithPet(toy);
        System.out.println(result);
        System.out.println(instance.getPet());
        
    }

    /**
     * Test of cure method, of class Player.
     */
    @Test
    public void testCure() {
        System.out.println("cure");
        Player instance = new Player("JUST4TEST","123123");
        instance.setPet(new Pet("FeedTest", 40, 70, 80, 0, true, "Test"));
        String result = instance.cure();
        System.out.println(result);
        System.out.println(instance.getPet());
    }

    /**
     * Test of getPetByName method, of class Player.
     */
    @Test
    public void testGetPetByName() {
        System.out.println("getPetByName");
        String name = "JUST4TEST";
        Player instance = new Player();
        instance.getPetByName(name);
    }

    /**
     * Test of readItemInfo method, of class Player.
     */
    @Test
    public void testReadItemInfo() {
        System.out.println("readItemInfo");
        Player instance = new Player();
        instance.readItemInfo();
    }

    
}
