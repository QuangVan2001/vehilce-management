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
public class Car extends Vehicle{
    public static final int Min_Year = 1900;
    public static final int Max_Year = 2021;
    private String type;
    private int year;

    public Car() {
    }

    
    public Car(String id) {
        super(id);
    }

    public Car( String id, String name, String color, double price, String brand, String type, int year) {
        super(id, name, color, price, brand);
        this.type = type;
        this.year = year;
    }

  

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean updateInformation() {
        super.setInformation();
        String newType = Utils.getString("Input new Type of car: ", this.getType());
        this.setType(newType);
        int newYear = Utils.getInt("Input new Year of manufacture of car: ", Min_Year, Max_Year, this.getYear());
        this.setYear(newYear);
        return true;
    }

    @Override
    public boolean setInformation() {
        super.setInformation();
        this.type = Utils.getString("Input type of Car: ");
        setType(type);
        this.year = Utils.getInt("Input year of manufacture of car: ", Min_Year, Max_Year);
        setYear(year);
        return true;
    }


    
    
    @Override
    public void showProfile() {
        System.out.println("[CAR]: " + "ID:" + getId() + "\t" + "Name: " + getName() + "\t" + "Color: " + getColor() + "\t" + "Brand: " + getBrand() + "\t" + "Price: " + getPrice() + "\t" + "Type: " + getType() + "\t" + "Year of manaufacture: " + getYear());

    }

}
