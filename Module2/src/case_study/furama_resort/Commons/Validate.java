package case_study.furama_resort.Commons;

import case_study.furama_resort.Libs.NameException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^([A-Z][a-z]*( [A-Z][a-z]*)*)";
    public static final String REGEX_AREA = "[\\d]+([.][\\d]+)?";
    public static final String REGEX_PRICE = "[\\d]{2,8}([.][\\d]+)?";
    public static final String REGEX_NUM_PEOPLE = "[\\d]{1,19}";
    public static final String REGEX_FLOOR = "[\\d]+";
    public static final String REGEX_NUM_SERVICE = "[1-5]";
    public static final String REGEX_SERVICE = "(Massage)|(Karaoke)|(Food)|(Drink)|(Car Rental)|(No)";

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public String regexName(String name) {
        while (true) {
            try {
                if (Pattern.matches(REGEX_NAME, name)) {
                    return name;
                } else {
                    throw new NameException("Fail. Enter again: ");
                }
            }catch (NameException n){
                System.err.println(n);
                name = getScanner().nextLine();
            }

        }
    }

    public String regexArea(String area) {
        while (true){
            if (Pattern.matches(REGEX_AREA, area) && Double.parseDouble(area) >= 30) {
                return area;
            } else {
                System.out.println("Fail. Area must be bigger 30m2. Enter again: ");
                area = getScanner().nextLine();
            }
        }
    }

    public String regexPrice(String price) {
        while (true) {
            if (Pattern.matches(REGEX_PRICE, price)){
                return price;
            } else {
                System.out.println("Fail. Price must be more 2 number. Enter again: ");
                price = getScanner().nextLine();
            }
        }
    }

    public String regexNumPeople(String numPeople) {
        while (true) {
            if (Pattern.matches(REGEX_NUM_PEOPLE, numPeople)){
                return numPeople;
            } else {
                System.out.println("Fail. Price must be more 2 number. Enter again: ");
                numPeople = getScanner().nextLine();
            }
        }
    }

    public String regexFloor(String floor) {
        while (true) {
            if (Pattern.matches(REGEX_FLOOR, floor)){
                return floor;
            } else {
                System.out.println("Fail. Enter again: ");
                floor = getScanner().nextLine();
            }
        }
    }

    public String regexNumService(String NumService) {
        while (true) {
            if (Pattern.matches(REGEX_NUM_SERVICE, NumService)){
                return NumService;
            } else {
                System.out.println("Fail. Chose 1-5. Enter again: ");
                NumService = getScanner().nextLine();
            }
        }
    }

    public String regexService(String name) {
        while (true) {
            try {
                if (Pattern.matches(REGEX_SERVICE, name)) {
                    return name;
                } else {
                    throw new NameException("Fail. Enter again: ");
                }
            }catch (NameException n){
                System.err.println(n);
                name = getScanner().nextLine();
            }

        }
    }

}
