package _01_introduction_in_java.practice.find_day_in_month;

import java.util.Scanner;

public class FinDayInMonth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month: ");
        int d = scanner.nextInt();
        
        switch (d){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Month "+d+" have 31 Day.");
                break;
            case 2:
                System.out.printf("Month %d have 28 or 29 Day.", d);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Month "+d+" have 30 Day.");
                break;
        }
    }
}
