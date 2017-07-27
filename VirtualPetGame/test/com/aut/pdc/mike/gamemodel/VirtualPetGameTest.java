/*
 *Junit Test for the VirtualPetGame class
 */
package com.aut.pdc.mike.gamemodel;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * VirtualPetGame Test
 * @author Minghao Yang
 */
public class VirtualPetGameTest {
    private VirtualPetGame vpg = new VirtualPetGame();
    
    public VirtualPetGameTest() {
    }
   

    /**
     * Test of autoConnectVirtualPetDB method, of class VirtualPetGame.
     */
    @Test
    public void testAutoConnectVirtualPetDB() {
        System.out.println("AutoConnectVirtualPetDB");
        vpg.autoConnectVirtualPetDB();    
    }

    /**
     * Test of createPlayerAccount method, of class VirtualPetGame.
     */
    @Test
    public void testCreatePlayerAccountSuccess() {
        System.out.println("CreatePlayerAccount");
        boolean expResult = false;
        //There is no user name named "JUST4TEST" and the expected return value should be false
        boolean result = vpg.createPlayerAccount("JUST4TEST", "123123");
        assertEquals(expResult, result);
    }

    /**
     * Test of createPlayerAccount method, of class VirtualPetGame.
     */
    @Test
    public void testCreatePlayerAccountFailure() {
        System.out.println("CreatePlayerAccountUserNameExisted");
        //There is a record with user name is "JUST4TEST" and the return value should be true
        boolean expResult = true;
        boolean result = vpg.createPlayerAccount("JUST4TEST", "123123");
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkTableExisting method, of class VirtualPetGame.
     */
    @Test
    public void testCheckTableExisting() {
        System.out.println("checkTableExistingAlreadyExisted");
        String newTableName = "FOOD";
        //The expResult if false, that means the table is already exsited
        Boolean expResult = false;
        Boolean result = vpg.checkTableExisting(newTableName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPetByPlayerName method, of class VirtualPetGame.
     * 
     * Compare the name,energy,happiness,strain of the pet to justfy whether the 
     * pet is belong to the player
     */
    @Test
    public void testGetPetByPlayerName() {
        System.out.println("getPetByPlayerName");
        Pet expResult = new Pet("Luson", 100, 100, 100.0, 0, true, "Schnauzer");
        Pet result = vpg.getPetByPlayerName("JUST4TEST");
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEnergy(), result.getEnergy());
        assertEquals(expResult.getHappiness(), result.getHappiness());
        assertEquals(expResult.getStrain(), result.getStrain());
    }

    /**
     * Test of updatePetInformationById method, of class VirtualPetGame.
     */
    @Test
    public void testUpdatePetInformationById() {
        System.out.println("updatePetInformationById");
        int petId = 1;
        Pet petInfo = new Pet("Luson", 80, 70, 90, 1, true, "Schnauzer");
        vpg.updatePetInformationById(petId, petInfo);
    }

    /**
     * Test of loginCheck method, of class VirtualPetGame.
     */
    @Test
    public void testLoginCheck() {
        System.out.println("loginCheck");
        int expResult = 1;
        int result = vpg.loginCheck("JUST4TEST", "123123");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of loginCheck method, of class VirtualPetGame.
     */
    @Test
    public void testLoginCheckWrongPassword() {
        System.out.println("loginCheckWrongPassword");
        int expResult = -1;
        int result = vpg.loginCheck("JUST4TEST", "123456");
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePetInfo method, of class VirtualPetGame.
     */
    @Test
    public void testDeletePetInfo() {
        System.out.println("deletePetInfo");
        int petId = 1;
        vpg.deletePetInfo(petId);
    }

    /**
     * Test of readFoodTable method, of class VirtualPetGame.
     * Test whether the food information in the table can be successfully read
     */
    @Test
    public void testReadFoodTable() {
        System.out.println("readFoodTable");
        ArrayList<Food> result = vpg.readFoodTable();
        System.out.println(result);
    }

    /**
     * Test of readToyTable method, of class VirtualPetGame.
     * Test whether the toy information in the table can be successfully read
     */
    @Test
    public void testReadToyTable() {
        System.out.println("readToyTable");
        ArrayList<Toys> result = vpg.readToyTable();
        System.out.println(result);
    }

    /**
     * Test of saveGameIfPetExists method, of class VirtualPetGame.
     * Test whether the save operation for the pet is successul if the player has already got a pet
     */
    @Test
    public void testSaveGameIfPetExists() {
        System.out.println("saveGameIfPetExists");
        String playerName = "JUST4TEST";
        Pet pet = new Pet("Luson", 50, 50, 50, 1, true, "Test");
        vpg.saveGameIfPetExists(playerName, pet);
    }

    /**
     * Test of saveNewPet method, of class VirtualPetGame.
     * Test whether the save operation for the pet is successful if the player has not got a pet before
     */
    @Test
    public void testSaveNewPet() {
        System.out.println("saveNewPet");
        String playerName = "JUST4TEST";
        Pet pet = new Pet("Luson", 50, 50, 50, 1, true, "New Pet");
        vpg.saveNewPet(playerName, pet);
    }
    
}
