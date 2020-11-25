package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Models.Customer;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Room;
import case_study.furama_resort.Models.Villa;

import java.util.List;
import java.util.Scanner;

public class ManagerBooking {

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void choseVillaForCustomer(Customer customer) {
        new ManagerVilla().displayVilla();
        System.out.println("Enter id service to chose: ");
        String idService = getScanner().nextLine();
        boolean isIdList = false;
        List<Villa> villaList = new ManagerVilla().readVillaCSV();
        while (true) {
            new ManagerVilla().displayVilla();
            for (Villa v : villaList) {
                if (idService.equals(v.getId())) {
                    customer.setServices(v);
                    isIdList = true;
                    break;
                }
            }
            if (!isIdList) {
                System.out.println(idService + " - This id don't have. \nEnter id service again: ");
                idService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void choseHouseForCustomer(Customer customer) {
        new ManagerHouse().displayHouse();
        System.out.println("Enter id service to chose: ");
        String idService = getScanner().nextLine();
        boolean isIdList = false;
        List<House> houseList = new ManagerHouse().readHouseCSV();
        while (true) {
            new ManagerHouse().displayHouse();
            for (House h : houseList) {
                if (idService.equals(h.getName())) {
                    customer.setServices(h);
                    isIdList = true;
                    break;
                }
            }
            if (!isIdList) {
                System.out.println(idService + " - This name don't have. \nEnter name service again: ");
                idService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void choseRoomForCustomer(Customer customer) {
        new ManagerRoom().displayRoom();
        System.out.println("Enter id service to chose: ");
        String idService = getScanner().nextLine();
        boolean isIdList = false;
        List<Room> roomList = new ManagerRoom().readRoomCSV();
        while (true) {
            new ManagerRoom().displayRoom();
            for (Room r : roomList) {
                if (idService.equals(r.getName())) {
                    customer.setServices(r);
                    isIdList = true;
                    break;
                }
            }
            if (!isIdList) {
                System.out.println(idService + " - This id don't have. \nEnter id service again: ");
                idService = getScanner().nextLine();
            } else {
                break;
            }
        }
    }

    public void addNewBooking() {
        List<Customer> customerList = new ManagerCustomer().readCustomerCSV();
        for (Customer c: customerList) {
            c.showInfo();
        }
        boolean isIdCustomer = false;

        while (true) {
            System.out.println("Enter Id customer to booking: ");
            String choseCustomer = getScanner().nextLine();
            for (Customer c: customerList) {
                if (choseCustomer.equals(c.getIdCustomer())) {
                    System.out.println("1. Villa\n2. House\n3. Room\nEnter service that you want to chose: ");
                    String choseService = getScanner().nextLine();
                    String elementLine = null;
                    switch (Integer.parseInt(choseService)) {
                        case 1: {
                            choseVillaForCustomer(c);
                            Villa villa = (Villa) c.getServices();
                            elementLine = villa.getId() + "," + villa.getName() + "," + villa.getPlaceArea() + ","
                                    + villa.getPrice() + "," + villa.getMaxPeople() + "," + villa.getRentDay() + ","
                                    + villa.getStandardRoom() + "," + villa.getDifferentUseful() + "," + villa.getAreaPool() + ","
                                    + villa.getNumFloors();
                            break;
                        }
                        case 2: {
                            choseHouseForCustomer(c);
                            House house = (House) c.getServices();
                            elementLine = house.getId() + "," + house.getName() + "," + house.getPlaceArea() + ","
                                    + house.getPrice() + "," + house.getMaxPeople() + "," + house.getRentDay() + ","
                                    + house.getStandardRoom() + "," + house.getDifferentUseful() + "," + house.getNumFloors();
                            break;
                        }
                        case 3: {
                            choseRoomForCustomer(c);
                            Room room = (Room) c.getServices();
                            elementLine = room.getId() + "," + room.getName() + "," + room.getPlaceArea() + ","
                                    + room.getPrice() + "," + room.getMaxPeople() + "," + room.getRentDay() + "," + room.getFreeService();
                            break;
                        }
                    }

                    String line = c.getIdCustomer() + "," + c.getNameCustomer() + "," + c.getBirthDayCustomer() + "," + c.getGenderCustomer()
                                + "," + c.getIdNumberCustomer() + "," + c.getPhoneCustomer() + "," + c.getEmailCustomer()
                                + "," + c.getTypeOfCustomer() + "," + c.getAddressCustomer() + "," + elementLine;
                    new ReadAndWrite().writeFile("src/case_study/furama_resort/Data/Booking.csv", line);
                    isIdCustomer = true;
                    break;
                }
            }
            if (!isIdCustomer){
                System.out.println("Id customer isn't exist!");
            } else {
                break;
            }
        }
    }
}
