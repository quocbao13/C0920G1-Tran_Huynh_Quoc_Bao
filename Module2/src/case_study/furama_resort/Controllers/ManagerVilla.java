package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerVilla {
    private static int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<Villa> readVillaCSV() {
        List<Villa> villaList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Villa.csv");
        for (String[] line : lineArr) {
            Villa villa = new Villa(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9]);
            villaList.add(villa);
        }
        return villaList;
    }

    public void setCountId() {
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Villa.csv");
        for (String[] line : lineArr) {
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public void addNewVilla() {
        setCountId();
        countId++;
        Villa villa = new Villa();
        villa.setId(String.valueOf(countId));
        System.out.println("Enter name villa: ");
        villa.setName(new Validate().regexName(getScanner().nextLine()));
        System.out.println("Enter place area villa: ");
        villa.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
        System.out.println("Enter price villa: ");
        villa.setPrice(new Validate().regexPrice(getScanner().nextLine()));
        System.out.println("Enter number people villa: ");
        villa.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
        System.out.println("Enter rent day villa: ");
        villa.setRentDay(new Validate().getScanner().nextLine());
        System.out.println("Enter standard room villa: ");
        villa.setStandardRoom(new Validate().getScanner().nextLine());
        System.out.println("Enter different useful villa: ");
        villa.setDifferentUseful(new Validate().getScanner().nextLine());
        System.out.println("Enter pool area villa: ");
        villa.setAreaPool(new Validate().regexArea(getScanner().nextLine()));
        System.out.println("Enter floor number villa: ");
        villa.setNumFloors(new Validate().regexFloor(getScanner().nextLine()));
        String line = villa.getId() + "," + villa.getName() + "," + villa.getPlaceArea() + ","
                    + villa.getPrice() + "," + villa.getMaxPeople() + "," + villa.getRentDay() + ","
                    + villa.getStandardRoom() + "," + villa.getDifferentUseful() + "," + villa.getAreaPool() + ","
                    + villa.getNumFloors();
        new ReadAndWrite().writeFile("src/case_study/furama_resort/Data/Villa.csv", line);
    }

    public void displayVilla() {
        System.out.println("Villa: ");
        List<Villa> villaList = readVillaCSV();
        for (Villa v : villaList){
            v.showInfo();
        }
    }

    public void displayVillaDuplicate() {
//        Set<String> villaSet = new HashSet<>();
//        for (Villa v : villaList){
//            villaSet.add(v.getName());
//        }
//        System.out.println("Villa not duplicate: ");
//        for (String s : villaSet){
//            System.out.println("- " + s);
//        }
    }




}
