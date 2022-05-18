/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class Motorbike extends Vehicle{
    public static final int Min_Speed = 1;
    public static final int Max_Speed = 500;
    
    private int maxSpeed;
    private boolean license;

    public Motorbike() {
    }

    
    public Motorbike(String id) {
        super(id);
    }

    public Motorbike( String id, String name, String color, double price, String brand, int maxSpeed, boolean license) {
        super(id, name, color, price, brand);
        this.maxSpeed = maxSpeed;
        this.license = license;
    }   




    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    @Override
    public boolean updateInformation() {
        super.updateInformation();
        int newSpeed = Utils.getInt("Input new speed of Motorbike: ", Min_Speed, Max_Speed, this.getMaxSpeed());
        this.setMaxSpeed(newSpeed);
        this.license = Utils.confirmYesNo("License (Y/n)");
        this.setLicense(license);
        return true;
    }

    @Override
    public boolean setInformation() {
        super.setInformation();
        this.maxSpeed = Utils.getInt("Input speed of Motorbike: ", Min_Speed, Max_Speed);
        this.setMaxSpeed(maxSpeed);
        this.license = Utils.confirmYesNo("License (Y/n)");
        this.setLicense(license);
        return true;
    }
    
    
    @Override
    public void showProfile() {
        String license;
        if (this.isLicense()) {
            license = " yes ";
        } else {
            license = " no";
        }
        System.out.println("[MotoBike]: " + "ID:" + getId() + "\t" + "Name: " + getName() + "\t" + "Color: " + getColor() + "\t"  + "Brand: " + getBrand() + "\t" + "Price: " + getPrice() + "\t" + "Speed: " + getMaxSpeed() + "\t" + "License: " + license);
      
    
    }


    public void makeSound() {
        System.out.println("tin tin tin");
    }
}
