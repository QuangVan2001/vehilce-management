/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.Menu;
import controllers.VehicleCollection;
import dto.I_Menu;
import dto.Vehicle;
import java.io.FileNotFoundException;

/**
 *
 * @author QUANG VAN
 */
public class VehicleManagement {
    public static void main(String[] args) throws FileNotFoundException  {
       
        VehicleCollection CoVehicle = new VehicleCollection();
//        System.out.println("Welcome to Vehicle Management - @2022 by <SE150505- PHAM QUANG VAN>");

        I_Menu menu = new Menu();
        menu.addItem("Welcome to Vehicle Management - @2022 by <SE150505- PHAM QUANG VAN>");
        menu.addItem("======================================");          
        menu.addItem("|       Vehicle Management:           |");          
        menu.addItem("|       1. Add a new vehicle.         |");
        menu.addItem("|       2. Update vehicle by ID.      |");
        menu.addItem("|       3. Delete vehicle by ID.      |");
        menu.addItem("|       4. Search Vehicle.            |");
        menu.addItem("|       5. Show vehicle list:         |");
        menu.addItem("|       6. Save to File.              |");
        menu.addItem("|       7. Quit.                      |");
        menu.addItem("======================================");    
        int choice;
        boolean cont = false;
        String fileName = "vehicle.txt";
        CoVehicle.readFromFile(fileName);
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    if (CoVehicle.add()) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Unsuccessfull!");
                    }
                    break;
                case 2:
                    if (CoVehicle.update()) {
                        System.out.println("Successfull!");
                    } else {
                        System.out.println("Unccessful!");
                    }
                    break;
                case 3:
                    if (CoVehicle.delete()) {
                        System.out.println("Successfull!");
                    } else {
                        System.out.println("unccessfull!");
                    }
                    break;

                case 4:
                    Vehicle vhe = CoVehicle.search();
                    break;

                case 5:
                    CoVehicle.showInfor();
                    break;
                case 6:
                    CoVehicle.writeFile(fileName);
                    break;
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(y/n)");
                    break;

            }
        } while (!cont);
        

    }
}
