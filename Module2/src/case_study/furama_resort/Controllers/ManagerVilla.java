package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.Villa;

import java.util.*;

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
            String[] eLine = line[0].split("-");
            if (countId < Integer.parseInt(eLine[1])) {
                countId = Integer.parseInt(eLine[1]);
            }
        }
    }

    public void addNewVilla() {
        setCountId();
        countId++;
        Villa villa = new Villa();
        villa.setId(String.format("SVVL-%04d", countId));
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
        villa.setStandardRoom(new Validate().regexName(getScanner().nextLine()));
        System.out.println("1.Massage, 2.Karaoke, 3.Food, 4.Drink, 5.Car Rental. 6.No. Enter a useful villa: ");
        villa.setDifferentUseful(new Validate().regexService(getScanner().nextLine()));
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
        Set<String> villaSet = new TreeSet<>();
        List<Villa> villaList = readVillaCSV();
        for (Villa v : villaList){
            villaSet.add(v.getName());
        }
        System.out.println("Villa not duplicate: ");
        for (String s : villaSet){
            System.out.println("- " + s);
        }
    }

    public void editVilla() {
        List<Villa> villaList = readVillaCSV();
        displayVilla();
        System.out.println("Enter name villa to upload: ");
        String nameVilla = getScanner().nextLine();
        boolean isService = false;
        for (Villa v: villaList) {
            if (nameVilla.equals(v.getName())) {
                choseUpload(v);
                isService = true;
                break;
            }
        }
        if (!isService) {
            System.out.println("This name isn't exist");
        }
        isYesNo(villaList);
    }

    private void choseUpload(Villa v) {
        System.out.println("1. Name\n2. Place area\n3. Price\n4. Number people\n5. Rent Day\n6. Stand room"
                + "\n7. Useful\n8. Pool area\n9. Floor number\nChose property, you want to upload: ");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                System.out.println("Enter new name villa: ");
                v.setName(new Validate().regexName(getScanner().nextLine()));
                break;
            }
            case 2: {
                System.out.println("Enter new place area villa: ");
                v.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
                break;
            }
            case 3: {
                System.out.println("Enter new price villa: ");
                v.setPrice(new Validate().regexPrice(getScanner().nextLine()));
                break;
            }
            case 4: {
                System.out.println("Enter new number people villa: ");
                v.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
                break;
            }
            case 5: {
                System.out.println("Enter new rent day villa: ");
                v.setRentDay(new Validate().getScanner().nextLine());
                break;
            }
            case 6: {
                System.out.println("Enter new standard room villa: ");
                v.setStandardRoom(new Validate().regexName(getScanner().nextLine()));
                break;
            }
            case 7: {
                System.out.println("1.Massage, 2.Karaoke, 3.Food, 4.Drink, 5.Car Rental. 6.No. Enter a new useful villa: ");
                v.setDifferentUseful(new Validate().regexService(getScanner().nextLine()));
                break;
            }
            case 8:{
                System.out.println("Enter new pool area villa: ");
                v.setAreaPool(new Validate().regexArea(getScanner().nextLine()));
                break;
            }
            case 9: {
                System.out.println("Enter new floor number villa: ");
                v.setNumFloors(new Validate().regexFloor(getScanner().nextLine()));
                break;
            }
            default: {
                System.out.println("Not exist. Chose again: ");
                choseUpload(v);
            }
        }
    }

    private void isYesNo(List<Villa> villaList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                String line = "";
                for (Villa villa: villaList) {
                    line += villa.getId() + "," + villa.getName() + "," + villa.getPlaceArea() + ","
                            + villa.getPrice() + "," + villa.getMaxPeople() + "," + villa.getRentDay() + ","
                            + villa.getStandardRoom() + "," + villa.getDifferentUseful() + "," + villa.getAreaPool() + ","
                            + villa.getNumFloors() + "\n";
                }
                new ReadAndWrite().writeFileInNewFile("src/case_study/furama_resort/Data/Villa.csv", line);
                break;
            }
            default: {
                new MainController().displayMainMenu();
            }
        }
    }

    public void deleteVilla() {
        List<Villa> villaList = readVillaCSV();
        displayVilla();
        System.out.println("Enter name villa, you want to delete: ");
        String nameVilla = getScanner().nextLine();
        boolean isHas = false;
        for (Villa v : villaList) {
            if (nameVilla.equals(v.getName())) {
                villaList.remove(v);
                isHas = true;
                break;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
        isYesNo(villaList);
    }

    public void searchVilla() {
        List<Villa> villaList = readVillaCSV();
        System.out.println("Enter name villa, you want to find: ");
        String nameVilla = getScanner().nextLine();
        boolean isHas = false;
        for (Villa v : villaList) {
            if (v.getName().toLowerCase().contains(nameVilla)) {
                v.showInfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }
}
