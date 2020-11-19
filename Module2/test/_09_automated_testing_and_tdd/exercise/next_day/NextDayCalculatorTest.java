package _09_automated_testing_and_tdd.exercise.next_day;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {
    @Test
    void checkNextDay() {
        int toYear = 2018;
        int toMonth = 12;
        int toDay = 31;

        String toDate = "1/1/2019";

        String result = NextDayCalculator.checkNextDay(toDay, toMonth, toYear);

        assertEquals(result, toDate);
    }

    Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

   int checkDay(int toMonth, int toYear){
        int toDay;
        System.out.println("Enter a day: ");
        toDay = Integer.parseInt(getScanner().nextLine());
        switch (toMonth) {
            case 2: {
                boolean isLeap = false;
                if(toYear % 4 == 0) {
                    if( toYear % 100 == 0) {
                        if ( toYear % 400 == 0){
                            isLeap = true;
                        }
                        else{
                            isLeap = false;
                        }
                    }else
                        isLeap = true;
                } else {
                    isLeap = false;
                }
                if(isLeap){
                    while (true){
                        if (toDay > 0 && toDay <= 29) {
                            break;
                        }else {
                            System.out.println("You enter fail .Enter again a day: ");
                            toDay = Integer.parseInt(getScanner().nextLine());
                        }
                    }
                }else {
                    while (true) {
                        if (toDay > 0 && toDay <= 28) {
                            break;
                        } else {
                            System.out.println("You enter fail .Enter again a day: ");
                            toDay = Integer.parseInt(getScanner().nextLine());
                        }
                    }
                }
                break;
            }
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            case 1: {
                while (true){
                    if (toDay > 0 && toDay <= 31) {
                        break;
                    }else {
                        System.out.println("You enter fail .Enter again a day: ");
                        toDay = Integer.parseInt(getScanner().nextLine());
                        getScanner().nextLine();
                    }
                }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                while (true){
                    if (toDay > 0 && toDay <= 30) {
                        break;
                    }else {
                        System.out.println("You enter fail .Enter again a day: ");
                        toDay = Integer.parseInt(getScanner().nextLine());
                        getScanner().nextLine();
                    }
                }
                break;
            }
        }
        return toDay;
    }

   int checkMonth() {
        int toMonth;
        System.out.println("Enter a month: ");
        toMonth = Integer.parseInt(getScanner().nextLine());
        while (true){
            if (toMonth > 0 && toMonth <= 12) {
                break;
            }else {
                System.out.println("You enter fail .Enter again a month: ");
                toMonth = Integer.parseInt(getScanner().nextLine());
            }
        }
        return toMonth;
    }

   int checkYear() {
        int toYear;
        System.out.println("Enter a year: ");
        toYear = Integer.parseInt(getScanner().nextLine());
        return toYear;
    }

}