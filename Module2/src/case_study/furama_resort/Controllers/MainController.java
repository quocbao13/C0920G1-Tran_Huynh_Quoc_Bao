package case_study.furama_resort.Controllers;

import case_study.furama_resort.Models.Customer;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Room;
import case_study.furama_resort.Models.Villa;

import java.io.*;
import java.util.*;

public class MainController {
    private static int countId;
    private static int countIdCustomer;
    private static List<Villa> villaList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
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
                    addNewCustomer();
                    break;
                }
                case 4: {
                    showCustomer();
                    break;
                }
                case 5: {
                    addNewBooking();
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



    public void readVillaCSV(){
        Villa villa = new Villa();
        try {
            fileReader = new FileReader("src/case_study/furama_resort/Data/Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arrLineElement;
            while ((line = bufferedReader.readLine()) != null) {
                arrLineElement = line.split(",");
                villa.setId(arrLineElement[0]);
                if (countId < Integer.parseInt(arrLineElement[0])) {
                    countId = Integer.parseInt(arrLineElement[0]);
                }
                villa.setName(arrLineElement[1]);
                villa.setPlaceArea(arrLineElement[2]);
                villa.setPrice(arrLineElement[3]);
                villa.setMaxPeople(arrLineElement[4]);
                villa.setRentDay(arrLineElement[5]);
                villa.setStandardRoom(arrLineElement[6]);
                villa.setDifferentUseful(arrLineElement[7]);
                villa.setAreaPool(arrLineElement[8]);
                villa.setNumFloors(arrLineElement[9]);
                villaList.add(villa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void readHouseCSV() {
        House house = new House();
        try {
            fileReader = new FileReader("src/case_study/furama_resort/Data/House.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] arrLineElement = line.split(",");
                if (countId < Integer.parseInt(arrLineElement[0])) {
                    countId = Integer.parseInt(arrLineElement[0]);
                }
                house.setId(arrLineElement[0]);
                house.setName(arrLineElement[1]);
                house.setPlaceArea(arrLineElement[2]);
                house.setPrice(arrLineElement[3]);
                house.setMaxPeople(arrLineElement[4]);
                house.setRentDay(arrLineElement[5]);
                house.setStandardRoom(arrLineElement[6]);
                house.setDifferentUseful(arrLineElement[7]);
                house.setNumFloors(arrLineElement[8]);
                houseList.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void readRoomCSV() {
        Room room = new Room();
        try {
            fileReader = new FileReader("src/case_study/furama_resort/Data/Room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arrLineElement = line.split(",");
                if (countId < Integer.parseInt(arrLineElement[0])) {
                    countId = Integer.parseInt(arrLineElement[0]);
                }
                room.setId(arrLineElement[0]);
                room.setName(arrLineElement[1]);
                room.setPlaceArea(arrLineElement[2]);
                room.setPrice(arrLineElement[3]);
                room.setMaxPeople(arrLineElement[4]);
                room.setRentDay(arrLineElement[5]);
                room.setFreeService(arrLineElement[6]);
                roomList.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }















    public void readCustomerCSV() {

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(new File("src/case_study/furama_resort/Data/Customer.csv")));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elementLine = line.split(",");
                if (countIdCustomer < Integer.parseInt(elementLine[0])) {
                    countIdCustomer = Integer.parseInt(elementLine[0]);
                }
                Customer customer = new Customer(elementLine[0], elementLine[1], elementLine[2], elementLine[3],
                        elementLine[4], elementLine[5],elementLine[6],elementLine[7], elementLine[8]);
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewCustomer() {
        Customer customer = new Customer();
        countIdCustomer++;
        customer.setIdCustomer(String.valueOf(countIdCustomer));
        System.out.println("Enter name customer: ");
        customer.setNameCustomer(getScanner().nextLine());
        System.out.println("Enter birthday customer: ");
        customer.setBirthDayCustomer(getScanner().nextLine());
        System.out.println("Enter gender customer: ");
        customer.setGenderCustomer(getScanner().nextLine());
        System.out.println("Enter id number customer: ");
        customer.setIdNumberCustomer(getScanner().nextLine());
        System.out.println("Enter phone customer: ");
        customer.setPhoneCustomer(getScanner().nextLine());
        System.out.println("Enter email customer: ");
        customer.setEmailCustomer(getScanner().nextLine());
        System.out.println("Enter type customer: ");
        customer.setTypeOfCustomer(getScanner().nextLine());
        System.out.println("Enter address customer: ");
        customer.setAddressCustomer(getScanner().nextLine());
        customerList.add(customer);
        try {
            file = new FileWriter("src/case_study/furama_resort/Data/Customer.csv");
            for (Customer c : customerList) {
                file.write(c.getIdCustomer() + "," + c.getNameCustomer() + "," + c.getBirthDayCustomer() + "," + c.getGenderCustomer()
                        + "," + c.getIdNumberCustomer() + "," + c.getPhoneCustomer() + "," + c.getEmailCustomer()
                        + "," + c.getTypeOfCustomer() + "," + c.getAddressCustomer() + "\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choseVillaForCustomer(Customer customer) {
        //displayVilla();
        System.out.println("Enter name service to chose: ");
        String nameService = getScanner().nextLine();
        boolean isNameList = false;
        while (true) {
            //displayVilla();
            for (Villa v : villaList) {
                if (nameService.equals(v.getName())) {
                    customer.setServices(v.getId());
                    isNameList = true;
                    break;
                }
            }
            if (!isNameList) {
                System.out.println(nameService + " - This name don't have. \nEnter name service again: ");
                nameService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void choseHouseForCustomer(Customer customer) {
        //displayHouse();
        System.out.println("Enter name service to chose: ");
        String nameService = getScanner().nextLine();
        boolean isNameList = false;
        while (true) {
            //displayHouse();
            for (House h : houseList) {
                if (nameService.equals(h.getName())) {
                    customer.setServices(h.getId());
                    isNameList = true;
                    break;
                }
            }
            if (!isNameList) {
                System.out.println(nameService + " - This name don't have. \nEnter name service again: ");
                nameService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void choseRoomForCustomer(Customer customer) {
        //displayRoom();
        System.out.println("Enter name service to chose: ");
        String nameService = getScanner().nextLine();
        boolean isNameList = false;
        while (true) {
            //displayRoom();
            for (Room r : roomList) {
                if (nameService.equals(r.getName())) {
                    customer.setServices(r.getId());
                    isNameList = true;
                    break;
                }
            }
            if (!isNameList) {
                System.out.println(nameService + " - This name don't have. \nEnter name service again: ");
                nameService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void showCustomer() {
        for (Customer c: customerList) {
            c.showInfo();
//            for (Villa v: villaList) {
//                if (c.getServices().equals(v.getId())){
//                    System.out.println("Service: ");
//                    v.showInfo();
//                    break;
//                }
//            }
//            for (House h: houseList) {
//                if (c.getServices().equals(h.getId())){
//                    System.out.println("Service: ");
//                    h.showInfo();
//                    break;
//                }
//            }
//            for (Room r: roomList) {
//                if (c.getServices().equals(r.getId())){
//                    System.out.println("Service: ");
//                    r.showInfo();
//                    break;
//                }
//            }
        }
    }

    public void addNewBooking() {
        for (Customer c: customerList) {
            c.showInfo();
        }
        boolean isIdCustomer = false;

        while (!isIdCustomer) {
            System.out.println("Enter Id customer to booking: ");
            String choseCustomer = getScanner().nextLine();
            for (Customer c: customerList) {
                if (choseCustomer.equals(c.getIdCustomer())) {
                    System.out.println("1. Villa\n2. House\n3. Room\nEnter service that you want to chose: ");
                    String choseService = getScanner().nextLine();
                    switch (Integer.parseInt(choseService)) {
                        case 1: {
                            choseVillaForCustomer(c);
                            break;
                        }
                        case 2: {
                            choseHouseForCustomer(c);
                            break;
                        }
                        case 3: {
                            choseRoomForCustomer(c);
                            break;
                        }
                    }
                    try {
                        file = new FileWriter("src/case_study/furama_resort/Data/Booking.csv",true);
                        file.write(c.getIdCustomer() + "," + c.getNameCustomer() + "," + c.getBirthDayCustomer() + "," + c.getGenderCustomer()
                                + "," + c.getIdNumberCustomer() + "," + c.getPhoneCustomer() + "," + c.getEmailCustomer()
                                + "," + c.getTypeOfCustomer() + "," + c.getAddressCustomer() + "," + c.getServices() + "\n");
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    isIdCustomer = true;
                    break;
                }
            }
            if (!isIdCustomer){
                System.out.println("Id customer isn't exist!");
            }
        }
    }
}
