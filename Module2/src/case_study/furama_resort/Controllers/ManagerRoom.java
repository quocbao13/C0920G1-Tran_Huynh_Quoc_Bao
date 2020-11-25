package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.House;
import case_study.furama_resort.Models.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManagerRoom {
    private static int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<Room> readRoomCSV() {
        List<Room> roomList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Room.csv");
        for (String[] line : lineArr) {
            Room room = new Room(line[0], line[1], line[2], line[3], line[4], line[5], line[6]);
            roomList.add(room);
        }
        return roomList;
    }

    public void setCountId() {
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Room.csv");
        for (String[] line : lineArr) {
            String[] eLine = line[0].split("-");
            if (countId < Integer.parseInt(eLine[1])) {
                countId = Integer.parseInt(eLine[1]);
            }
        }
    }

    public void addNewRoom() {
        setCountId();
        countId++;
        Room room = new Room();
        if (countId < 10) {
            room.setId("SVRO-000" + countId);
        }else {
            room.setId("SVRO-00" + countId);
        }
        System.out.println("Enter name room: ");
        room.setName(new Validate().regexName(getScanner().nextLine()));
        System.out.println("Enter place area room: ");
        room.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
        System.out.println("Enter price room: ");
        room.setPrice(new Validate().regexPrice(getScanner().nextLine()));
        System.out.println("Enter number people room: ");
        room.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
        System.out.println("Enter rent day room: ");
        room.setRentDay(getScanner().nextLine());
        System.out.println("1. Massage, 2. Karaoke, 3. Food, 4. Drink, 5. Car. Enter free service: ");
        String chose = getScanner().nextLine();
        switch (Integer.parseInt(new Validate().regexNumService(chose))){
            case 1: {
                room.setFreeService(new Validate().regexName("Massage"));
                break;
            }
            case 2: {
                room.setFreeService(new Validate().regexName("Karaoke"));
                break;
            }
            case 3: {
                room.setFreeService(new Validate().regexName("Food"));
                break;
            }
            case 4: {
                room.setFreeService(new Validate().regexName("Drink"));
                break;
            }
            case 5: {
                room.setFreeService(new Validate().regexName("Car Rental"));
                break;
            }
        }
        String line = room.getId() + "," + room.getName() + "," + room.getPlaceArea() + ","
                    + room.getPrice() + "," + room.getMaxPeople() + "," + room.getRentDay() + "," + room.getFreeService();
        new ReadAndWrite().writeFile("src/case_study/furama_resort/Data/Room.csv", line);
    }

    public void displayRoom() {
        System.out.println("Room: ");
        List<Room> roomList = readRoomCSV();
        for (Room v : roomList){
            v.showInfo();
        }
    }

    public void displayRoomDuplicate() {
        Set<String> RoomSet = new TreeSet<>();
        List<Room> roomList = readRoomCSV();
        for (Room v : roomList){
            RoomSet.add(v.getName());
        }
        System.out.println("Villa not duplicate: ");
        for (String s : RoomSet){
            System.out.println("- " + s);
        }
    }

    public void editRoom() {
        List<Room> roomList = readRoomCSV();
        displayRoom();
        System.out.println("Enter id room to upload: ");
        String idRoom = getScanner().nextLine();
        boolean isService = false;
        for (Room r: roomList) {
            if (idRoom.equals(r.getName())) {
                choseUpload(r);
                isService = true;
                break;
            }
        }
        if (!isService) {
            System.out.println("This id isn't exist");
        }
        isYesNo(roomList);
    }

    private void choseUpload(Room r) {
        System.out.println("1. Name\n2. Place area\n3. Price\n4. Number people\n5. Rent Day\n6. \nChose property, you want to upload: ");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                System.out.println("Enter new name room: ");
                r.setName(new Validate().regexName(getScanner().nextLine()));
                break;
            }
            case 2: {
                System.out.println("Enter new place area room: ");
                r.setPlaceArea(new Validate().regexArea(getScanner().nextLine()));
                break;
            }
            case 3: {
                System.out.println("Enter new price room: ");
                r.setPrice(new Validate().regexPrice(getScanner().nextLine()));
                break;
            }
            case 4: {
                System.out.println("Enter new number people v: ");
                r.setMaxPeople(new Validate().regexNumPeople(getScanner().nextLine()));
                break;
            }
            case 5: {
                System.out.println("Enter new rent day room: ");
                r.setRentDay(new Validate().getScanner().nextLine());
                break;
            }
            case 6: {
                System.out.println("1.Massage, 2.Karaoke, 3.Food, 4.Drink, 5.Car Rental. 6.No. Enter a new useful Room: ");
                r.setFreeService(new Validate().regexService(getScanner().nextLine()));
            }
            default: {
                System.out.println("Not exist. Chose again: ");
                choseUpload(r);
            }
        }
    }

    private void isYesNo(List<Room> roomList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                String line = "";
                for (Room room: roomList) {
                    line += room.getId() + "," + room.getName() + "," + room.getPlaceArea() + ","
                            + room.getPrice() + "," + room.getMaxPeople() + "," + room.getRentDay() + "," + "\n";
                }
                new ReadAndWrite().writeFileInNewFile("src/case_study/furama_resort/Data/Room.csv", line);
                break;
            }
            default: {
                new MainController().displayMainMenu();
            }
        }
    }

    public void deleteHouse() {
        List<Room> roomList = readRoomCSV();
        displayRoom();
        System.out.println("Enter id room, you want to delete: ");
        String idRoom = getScanner().nextLine();
        boolean isHas = false;
        for (Room r : roomList) {
            if (idRoom.equals(r.getName())) {
                roomList.remove(r);
                isYesNo(roomList);
                isHas = true;
                break;
            }
        }
        if (!isHas) {
            System.out.println("This id isn't exist!!");
        }
    }

    public void searchRoom() {
        List<Room> roomList = readRoomCSV();
        System.out.println("Enter name Room, you want to find: ");
        String nameRoom = getScanner().nextLine();
        boolean isHas = false;
        for (Room r : roomList) {
            if (r.getName().toLowerCase().contains(nameRoom.toLowerCase())) {
                r.showInfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }
}
