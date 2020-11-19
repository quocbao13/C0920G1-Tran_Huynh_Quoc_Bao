package case_study.furama_resort.Commons;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
    public String regexName(String name) {
        String regexName = "^([A-Z][a-z]*( [A-Z][a-z]*)*)";
        while (true) {
            if (Pattern.matches(regexName, name)) {
                return name;
            } else {
                System.out.println("Fail. Enter again: ");
                name = getScanner().nextLine();
            }
        }
    }

    public String regexArea(String area) {
        String regexArea = "[\\d]+([.][\\d]+)?";
        while (true){
            if (Pattern.matches(regexArea, area) && Double.parseDouble(area) >= 30) {
                return area;
            } else {
                System.out.println("Fail. Area must be bigger 30m2. Enter again: ");
                area = getScanner().nextLine();
            }
        }
    }

    public String regexPrice(String price) {
        String regexPrice = "[\\d]{2,8}([.][\\d]+)?";
        while (true) {
            if (Pattern.matches(regexPrice, price)){
                return price;
            } else {
                System.out.println("Fail. Price must be more 2 number. Enter again: ");
                price = getScanner().nextLine();
            }
        }
    }

    public String regexNumPeople(String numPeople) {
        String regexNumPeople = "[\\d]{1,19}";
        while (true) {
            if (Pattern.matches(regexNumPeople, numPeople)){
                return numPeople;
            } else {
                System.out.println("Fail. Price must be more 2 number. Enter again: ");
                numPeople = getScanner().nextLine();
            }
        }
    }

    public String regexFloor(String floor) {
        String regexFloor = "[\\d]+";
        while (true) {
            if (Pattern.matches(regexFloor, floor)){
                return floor;
            } else {
                System.out.println("Fail. Enter again: ");
                floor = getScanner().nextLine();
            }
        }
    }

    public String regexNumService(String NumService) {
        String regexNumService = "[1-5]";
        while (true) {
            if (Pattern.matches(regexNumService, NumService)){
                return NumService;
            } else {
                System.out.println("Fail. Chose 1-5. Enter again: ");
                NumService = getScanner().nextLine();
            }
        }
    }
}
