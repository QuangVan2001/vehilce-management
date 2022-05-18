/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dto.I_Menu;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class Menu extends ArrayList<String> implements I_Menu{
    public Menu(){
        super();
    }
    
    @Override
    public void addItem(String s) {
        add(s);
    }

    

    @Override
    public void showMenu() {
        for (String thi : this) {
            System.out.println(thi);
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        boolean result = false;
        result = Utils.confirmYesNo(welcome);
        return result;
    }
    
    @Override
    public int getChoice() {
        return Utils.getInt("Input your choice: ", 1, this.size());
    }
}
