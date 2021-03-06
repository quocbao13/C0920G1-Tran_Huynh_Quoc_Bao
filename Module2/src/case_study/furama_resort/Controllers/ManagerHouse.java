package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Villa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManagerHouse {
    private static int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<House> readHouseCSV() {
        List<House> houseList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/House.csv");
        for (String[] line : lineArr) {
            House house = new House(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
            houseList.add(house);
        }
        return houseList;
    }

    public void setCountId() {
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/House.csv");
        for (String[] line : lineArr) {
            String[] eLine = line[0].split("-");
            if (countId < Integer.parseInt(eLine[1])) {
                countId = Integer.parseInt(eLine[1]);
            }
        }
    }

    public void addNewHouse() {
        setCountId();
        countId++;
        House house = new House();
        if (countId < 10) {
            house.setId("SVHO-000" + countId);
        }else {
            house.setId("SVHO-00" + countId);
        }
        System.out.println("Enter name house: ");
        house.setName(new Validate().regexName(getScanner().nextLine()));
        System.out.println("Enter place area house: ");
        house.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
        System.out.println("Enter price house: ");
        house.setPrice(new Validate().regexPrice(getScanner().nextLine()));
        System.out.println("Enter number people house: ");
        house.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
        System.out.println("Enter rent day house: ");
        house.setRentDay(getScanner().nextLine());
        System.out.println("Enter standard room house: ");
        house.setStandardRoom(getScanner().nextLine());
        System.out.println("1.Massage, 2.Karaoke, 3.Food, 4.Drink, 5.Car Rental. 6.No. Enter useful house: ");
        house.setDifferentUseful(new Validate().regexService(getScanner().nextLine()));
        System.out.println("Enter floor number house: ");
        house.setNumFloors(new Validate().regexFloor(getScanner().nextLine()));
        String line = house.getId() + "," + house.getName() + "," + house.getPlaceArea() + ","
                    + house.getPrice() + "," + house.getMaxPeople() + "," + house.getRentDay() + ","
                    + house.getStandardRoom() + "," + house.getDifferentUseful() + "," + house.getNumFloors();
        new ReadAndWrite().writeFile("src/case_study/furama_resort/Data/House.csv", line);
    }

    public void displayHouse() {
        System.out.println("House: ");
        List<House> houseList = readHouseCSV();
        for (House v : houseList){
            v.showInfo();
        }
    }

    public void displayHouseDuplicate() {
        Set<String> HouseSet = new TreeSet<>();
        List<House> houseList = readHouseCSV();
        for (House h : houseList){
            HouseSet.add(h.getName());
        }
        System.out.println("House not duplicate: ");
        for (String s : HouseSet){
            System.out.println("- " + s);
        }
    }

    public void editHouse() {
        List<House> houseList = readHouseCSV();
        displayHouse();
        System.out.println("Enter id house to upload: ");
        String idVilla = getScanner().nextLine();
        boolean isService = false;
        for (House h: houseList) {
            if (idVilla.equals(h.getName())) {
                choseUpload(h);
                isService = true;
                break;
            }
        }
        if (!isService) {
            System.out.println("This id isn't exist");
        }
        isYesNo(houseList);
    }

    private void choseUpload(House h) {
        System.out.println("1. Name\n2. Place area\n3. Price\n4. Number people\n5. Rent Day\n6. Stand room"
                + "\n7. Useful\n8. Floor number\nChose property, you want to upload: ");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                System.out.println("Enter new name house: ");
                h.setName(new Validate().regexName(getScanner().nextLine()));
                break;
            }
            case 2: {
                System.out.println("Enter new place area house: ");
                h.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
                break;
            }
            case 3: {
                System.out.println("Enter new price house: ");
                h.setPrice(new Validate().regexPrice(getScanner().nextLine()));
                break;
            }
            case 4: {
                System.out.println("Enter new number people house: ");
                h.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
                break;
            }
            case 5: {
                System.out.println("Enter new rent day house: ");
                h.setRentDay(new Validate().getScanner().nextLine());
                break;
            }
            case 6: {
                System.out.println("Enter new standard room house: ");
                h.setStandardRoom(new Validate().regexName(getScanner().nextLine()));
                break;
            }
            case 7: {
                System.out.println("1.Massage, 2.Karaoke, 3.Food, 4.Drink, 5.Car Rental. 6.No. Enter a new useful house: ");
                h.setDifferentUseful(new Validate().regexService(getScanner().nextLine()));
                break;
            }
            case 8:{
                System.out.println("Enter new floor number house: ");
                h.setNumFloors(new Validate().regexFloor(getScanner().nextLine()));
                break;
            }
            default: {
                System.out.println("Not exist. Chose again: ");
                choseUpload(h);
            }
        }
    }

    private void isYesNo(List<House> houseList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                String line = "";
                for (House house: houseList) {
                    line += house.getId() + "," + house.getName() + "," + house.getPlaceArea() + ","
                            + house.getPrice() + "," + house.getMaxPeople() + "," + house.getRentDay() + ","
                            + house.getStandardRoom() + "," + house.getDifferentUseful() + ","
                            + house.getNumFloors() + "\n";
                }
                new ReadAndWrite().writeFileInNewFile("src/case_study/furama_resort/Data/House.csv", line);
                break;
            }
            default: {
                new MainController().displayMainMenu();
            }
        }
    }

    public void deleteHouse() {
        List<House> houseList = readHouseCSV();
        displayHouse();
        System.out.println("Enter id house, you want to delete: ");
        String idHouse = getScanner().nextLine();
        boolean isHas = false;
        for (House h : houseList) {
            if (idHouse.equals(h.getId())) {
                houseList.remove(h);
                isYesNo(houseList);
                isHas = true;
                break;
            }
        }
        if (!isHas) {
            System.out.println("This id isn't exist!!");
        }
    }

    public void searchHouse() {
        List<House> houseList = readHouseCSV();
        System.out.println("Enter name House, you want to find: ");
        String nameHouse = getScanner().nextLine();
        boolean isHas = false;
        for (House h : houseList) {
            if (h.getName().toLowerCase().contains(nameHouse.toLowerCase())) {
                h.showInfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }
}
