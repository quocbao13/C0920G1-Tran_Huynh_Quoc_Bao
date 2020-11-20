package case_study.furama_resort.Controllers;

import case_study.furama_resort.Models.Customer;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Room;
import case_study.furama_resort.Models.Villa;

import java.io.*;
import java.util.*;

public class MainController {
    FileWriter file;
    FileReader fileReader;



    private Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void displayMainMenu(){
        boolean isWhile = true;
        while (isWhile) {
            System.out.println("1. Add New Services."
                    + "\n2. Show Services."
                    + "\n3. Add New Customer."
                    + "\n4. Show Information of Customer."
                    + "\n5. Add New Booking."
                    + "\n6. Show Information of Employee."
                    + "\n0. Exit."
                    + "Enter number.");
            String choseCase = getScanner().nextLine();

            switch (Integer.parseInt(choseCase)) {
                case 1: {
                    new ManagerService().addNewService();
                    break;
                }
                case 2: {
                    new ManagerService().displayService();
                    break;
                }
                case 3: {
                    new ManagerCustomer().addNewCustomer();
                    break;
                }
                case 4: {
                    new ManagerCustomer().showCustomer();
                    break;
                }
                case 5: {
                    new ManagerBooking().addNewBooking();
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    isWhile = false;
                    break;
                }
            }
        }
    }




}
