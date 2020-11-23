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
}
