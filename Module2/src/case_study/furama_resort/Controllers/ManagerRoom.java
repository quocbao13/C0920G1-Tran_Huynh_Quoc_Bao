package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Models.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManagerRoom {
    private static int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void addNewRoom() {
        countId++;
        Room room = new Room();
        room.setId(String.valueOf(countId));
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
                room.setFreeService(new Validate().regexName("Car"));
                break;
            }
        }
        try {
            FileWriter file;
            file = new FileWriter("src/case_study/furama_resort/Data/Room.csv", true);
            file.write(room.getId() + "," + room.getName() + "," + room.getPlaceArea() + ","
                    + room.getPrice() + "," + room.getMaxPeople() + "," + room.getRentDay() + "," + room.getFreeService() + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayRoom() {
//        System.out.println("Room: ");
//        for (Room v : roomList){
//            v.showInfo();
//        }
    }

    public void displayRoomDuplicate() {
//        Set<String> RoomSet = new HashSet<>();
//        for (Villa v : villaList){
//            RoomSet.add(v.getName());
//        }
//        System.out.println("Villa not duplicate: ");
//        for (String s : RoomSet){
//            System.out.println("- " + s);
//        }
    }
}
