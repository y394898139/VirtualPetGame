package com.aut.pdc.mike.gamemodel;

import com.aut.pdc.mike.gui.VirtualPetFrame;

/**
 * It's a Thread Class used to make the pet grow up with time.
 *
 * @author Minghao Yang
 *
 */
public class MyThread extends Thread {
    // Used to control the loop in the run method

    private boolean flag;
    public VirtualPetFrame vpf;
    private Player player;

    /**
     * Constructor
     *
     * @param player
     */
    public MyThread(VirtualPetFrame vpf) {
        super();
        this.vpf = vpf;
        this.player = vpf.player;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        this.flag = true;
        while (flag) {
            try {
                Thread.sleep(10000);
                //Pet grow
                player.getPet().grow();
                //Check whether the pet is alive
                vpf.checkPetSurvive();
                //Pet is randomly ill
                player.getPet().getSick();
                //Check the pet's situation
                String message = player.getPet().situationCheck();
                vpf.setWarn(message);
                //Update the gui
                vpf.setPetInformation(player.getPet().getEnergy(), player.getPet().getHappiness(), player.getPet().getHealth(), player.getPet().getAge(), player.getPet().isAlive());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Return the value of the flag
     *
     * @return
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Set the value of the flag
     *
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Get the player
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the player
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

}
