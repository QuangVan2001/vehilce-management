/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.HashMap;

/**
 *
 * @author QUANG VAN
 */
public interface I_Collection {
    
    public boolean add();
    
    public boolean update();
    
    public boolean delete();

    public Vehicle search();
    
    public Vehicle searchID(String id);

    public Vehicle searchName();

    public void showInfor();
}
