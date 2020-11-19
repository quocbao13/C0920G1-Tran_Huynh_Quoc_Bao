package _01_introduction_in_java.exercise.show_hello;

import java.util.Scanner;

public class ShowHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: " + name);
    }
}
