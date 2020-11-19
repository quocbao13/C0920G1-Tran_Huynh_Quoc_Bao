package _01_introduction_in_java.practice.linear_equation_resolver;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        System.out.println("Enter a: ");
        a = scanner.nextFloat();

        System.out.println("Enter b: ");
        b = scanner.nextFloat();

        System.out.println("Enter c: ");
        c = scanner.nextFloat();


        if (a != 0){
            double solver = (c - b) / a;
            System.out.printf("Equation pass with x = %f!", solver);
        }else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
