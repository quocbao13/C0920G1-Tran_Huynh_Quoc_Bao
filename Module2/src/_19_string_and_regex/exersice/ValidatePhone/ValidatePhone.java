package _19_string_and_regex.exersice.ValidatePhone;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        String regexPhone = "\\((84)\\)\\-\\(0\\d{9}\\)";
        Scanner scanner = new Scanner(System.in);
        String nameClass = scanner.nextLine();
        if (Pattern.matches(regexPhone, nameClass)) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
