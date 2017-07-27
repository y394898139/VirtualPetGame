package com.aut.pdc.mike.main;

import com.aut.pdc.mike.gamemodel.Player;
import com.aut.pdc.mike.gui.MainMenu;

/**
 * Main
 * @author Minghao Yang
 */
public class Main {
    public static void main(String args[]){
        final Player player = new Player();
        MainMenu menu = new MainMenu(player);
        menu.setVisible(true);
    }
}
