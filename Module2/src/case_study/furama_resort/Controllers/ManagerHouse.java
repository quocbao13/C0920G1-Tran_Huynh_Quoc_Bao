package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Villa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public void addNewHouse() {
        setCountId();
        countId++;
        House house = new House();
        house.setId(String.valueOf(countId));
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
        System.out.println("Enter different useful house: ");
        house.setDifferentUseful(getScanner().nextLine());
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
//        Set<String> HouseSet = new HashSet<>();
//        for (Villa v : villaList){
//            HouseSet.add(v.getName());
//        }
//        System.out.println("Villa not duplicate: ");
//        for (String s : HouseSet){
//            System.out.println("- " + s);
//        }
    }
}
