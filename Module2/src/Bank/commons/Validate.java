package Bank.commons;

import luyen_tap.Controller.ManagerController;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_REQUIRE = "[\\w ]+";
    public static final String REGEX_NUM = "[\\d]+";
    public static final String REGEX_DATE = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[9]|[2-9]\\d)\\d{2})$";
    public static final String REGEX_SHORT_TIME = "[63]";
    public static final String REGEX_LONG_TIME = "1|3|5|10";
    public static final String REGEX_SAVE_MONEY = "[1-9][0-9]{5,}";

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static String regexRequire(String str) {
        while (true){
            if (Pattern.matches(REGEX_REQUIRE, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            } else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexNum(String str) {
        while (true){
            if (Pattern.matches(REGEX_NUM, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexDate(String str) {
        while (true){
            if (Pattern.matches(REGEX_DATE, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexShortTime(String str) {
        while (true){
            if (Pattern.matches(REGEX_SHORT_TIME, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexLongTime(String str) {
        while (true){
            if (Pattern.matches(REGEX_LONG_TIME, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexSaveMoney(String str) {
        while (true){
            if (Pattern.matches(REGEX_SAVE_MONEY, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }
}
