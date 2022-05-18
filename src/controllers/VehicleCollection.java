/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dto.Car;
import dto.I_Collection;
import dto.Motorbike;
import dto.Vehicle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class VehicleCollection extends HashMap<String, Vehicle> implements I_Collection{
    
    @Override
    public boolean add() {
        boolean result = false;
        Vehicle hasVechicle = null;

        int type = typeVehicle();
        String id = Utils.getString("Input id of vehicle: ");
        if (this.searchID(id) != null) {
            System.out.println("ID has exist!");
            result = false;
        }

        switch (type) {
            case 1:
                hasVechicle = new Car(id);
                break;
            case 2:
                hasVechicle = new Motorbike(id);
                break;
        }

        if (hasVechicle.setInformation()) {
            this.put(id, hasVechicle);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update() {
        boolean result = false;
        String id = Utils.getString("Input id of vehicle you want to update: ");
        Vehicle upVehicle = searchID(id);
        if (upVehicle == null) {
            System.out.println("Vehicle does not exist!");
        } else {
            upVehicle.updateInformation();
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete() {
        boolean result = false;
        String id = Utils.getString("Input Id of vehicle you want to delete: ");
        Vehicle deVehicle = searchID(id);
        if (deVehicle == null) {
            System.out.println("Vehicle does not exist!");
        } else {
            boolean confirmDelete = Utils.confirmYesNo("Are you sure?(Y/N)");
            if (confirmDelete) {
                this.remove(id);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Vehicle search() {

        Vehicle searchVehicle = null;
        int type = searchType();
        switch (type) {
            case 1:
                Vehicle vehi = searchName();
                break;
            case 2:
                String id = Utils.getString("Input id of vehicle you want to search: ");
                Vehicle vehicle = this.searchID(id);
                if (vehicle != null) {
                    vehicle.showProfile();
                } else {
                    System.out.println("Vehicle does not exist!");
                }
                break;
        }
        return searchVehicle;
    }

    @Override
    public Vehicle searchID(String id) {
        Vehicle veh = null;
        if (this.containsKey(id)) {
            veh = this.get(id);
        }
        return veh;
    }

    @Override
    public Vehicle searchName() {
        List<Vehicle> list = new ArrayList<>(this.values());
        Collections.sort(list);
        String sequen = Utils.getString(" input string of name's vehicle you want to search: ");
        for (Vehicle f : list) {
            if (f.getName().contains(sequen)) {
                f.showProfile();
            } else {
                System.out.println("Vehicle does not exist.");
            }
        }
        return null;
    }

    @Override
    public void showInfor() {
        int type = showType();
        switch (type) {
            case 1:
                for (String string : this.keySet()) {
                    get(string).showProfile();
                }
                break;
            case 2:
                showdesPrice();
                break;
        }

    }

    public int typeVehicle() {
        int choice;
        Menu subMenu = new Menu();
        subMenu.add("Enter type of Vehicle: ");
        subMenu.add("1. Car.");
        subMenu.add("2. Motorbike.");
        subMenu.showMenu();
        choice = Utils.getInt("Select your choice: ", 1, subMenu.size() - 1);
        return choice;
    }

    public int searchType() {
        int choice;
        Menu subSearchMenu = new Menu();
        subSearchMenu.add("Enter Type you want to search: ");
        subSearchMenu.add("1. Search by name.");
        subSearchMenu.add("2. Search by Id");
        subSearchMenu.showMenu();
        choice = Utils.getInt("Select your choice: ", 1, subSearchMenu.size() - 1);
        return choice;
    }

    public int showType() {
        int choice;
        Menu subShowMenu = new Menu();
        subShowMenu.add("Enter type of show Vehicle collection: ");
        subShowMenu.add("1. Show all vehicle.");
        subShowMenu.add("2. Show all vehicle descending by price.");
        subShowMenu.showMenu();
        choice = Utils.getInt("Select your choice: ", 1, subShowMenu.size() - 1);
        return choice;
    }

    public void showdesPrice() {
        List<Vehicle> list = new ArrayList<>(this.values());
        Collections.sort(list, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                if (o2.getPrice() < o1.getPrice()) {
                    return -1;
                }
                return 1;
            }
        });
        for (Vehicle vehicle : list) {
            vehicle.showProfile();
            if (vehicle instanceof Motorbike) {
                ((Motorbike) vehicle).makeSound();
            }
        }
    }


    //write to file
    public void writeFile(String filename) {
        ArrayList<Vehicle> list = new ArrayList<>(this.values());
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Vehicle ve : list) {
                if (ve instanceof Motorbike) {
                    String license;
                    if (((Motorbike) ve).isLicense()) {
                        license = " yes ";
                    } else {
                        license = " no";
                    }
                    bw.write("MOTORBIKE: " + "ID: " + ve.getId() + "\t" + "Name: " + ve.getName() + "\t" + "Color: " + ve.getColor() + "\t" + "Brand:" + ve.getBrand() + "\t" + "Price: " + ve.getPrice() + "\t" + "Speed: " + ((Motorbike) ve).getMaxSpeed() + "\t" + "License: " + license +  "\n");
//                    bw.write("Tin tin tin" + "\n");
                }
                System.out.println();
                if (ve instanceof Car) {
                    bw.write("ID: " + ve.getId() + "\t" + "Name: " + ve.getName() + "\t" + "Color: " + ve.getColor() + "\t" + "Brand:" + ve.getBrand() + "\t" + "Price: " + ve.getPrice() + "\t" + "Type: " + ((Car) ve).getType() + "\t" + "Year: " + ((Car) ve).getYear() + "\n");

                }
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Have error!");
        }

    }

//read from file and add data to list
    public ArrayList<Vehicle> readFromFile(String filename) {
        ArrayList<Vehicle> list = new ArrayList<>(this.values());
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] tmp = line.split(",");
                String id = tmp[1];
                String name = tmp[2];
                String color = tmp[3];
                double price = Double.parseDouble(tmp[4]);
                String brand = tmp[5];
                try {
                    int maxSpeed = Integer.parseInt(tmp[6]);
                    boolean license = tmp[7].equalsIgnoreCase("true");
                    list.add(new Motorbike(id, name, color, price, brand, maxSpeed, license));
                } catch (Exception e) {
                    String type = tmp[6];
                    int year = Integer.parseInt(tmp[7]);
                    list.add(new Car(id, name, color, price, brand, type, year));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
        return list;
    }
    
//    public void addFromFile(){
//        try {
//            File f = new File("vehicle.txt");
//            if (!f.exists()) {
//                return  ;
//                
//            }
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String details;
//            while((details = br.readLine().equalsIgnoreCase("MOTORBIKE") == false)){
//                
//            }
//        } catch (Exception e) {
//        }
//    }
}
