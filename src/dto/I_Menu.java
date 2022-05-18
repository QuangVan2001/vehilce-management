/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author QUANG VAN
 */
public interface I_Menu {
    //add a menu item--> add a text to menu
    void addItem(String s);
    
    //get user choice(user input their chocie)
    int getChoice();
    
    //show menu for user
    void showMenu();
    
    //confirmYesNo
    boolean confirmYesNo(String welcome);
}
