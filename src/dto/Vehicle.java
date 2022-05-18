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
public abstract class Vehicle implements Comparable<Vehicle>{
    public static final double Min_Price = 1;
    public static final double Max_Price = 10000000;
    
    private String id;
    private String name;
    private String color;
    private double price;
    private String brand;

    public Vehicle() {
    }
    
    

    public Vehicle(String id) {
        this.id = id;
    }


    public Vehicle(String id, String name, String color, double price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public boolean setInformation(){
        this.name = Utils.getString("Input name of Vehicle: ");
        this.setName(name);
        this.color = Utils.getString("Input color of Vehicle: ");
        this.setColor(color);
        this.brand = Utils.getString("Input brand of Vehicle: ");
        this.setBrand(brand);
        this.price = Utils.getDouble("Input price of Vehicle: ", Min_Price, Max_Price);
        this.setPrice(price);
        return true;
    }
    
    public boolean updateInformation(){
        String newName = Utils.getString("Input new name of Vehicle: ", this.getName());
        this.setName(newName);
        String newColor = Utils.getString("Input new color of Vehicle: ", this.getColor());
        this.setColor(newColor);
        String newBrand = Utils.getString("Input new brand of Vehicle: ", this.getBrand());
        this.setBrand(newBrand);
        double newPrice = Utils.getDouble("Input new price of Vehicle: ", Min_Price, Max_Price, this.getPrice());
        this.setPrice(newPrice);
        return true;
    }
    
    @Override
    public int compareTo(Vehicle o) {
        return o.name.compareTo(this.name);
    }

    public abstract void showProfile();
}
