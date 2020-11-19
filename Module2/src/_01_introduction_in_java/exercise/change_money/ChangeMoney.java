package _01_introduction_in_java.exercise.change_money;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        int mVND = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD to change VND: ");
        int mUSD = scanner.nextInt();
        int mChange = mUSD * mVND;
        System.out.println("Changed: " + mChange + "đ");
    }
}
