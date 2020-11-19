package _06_inheritance.exercise.class_triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh thứ nhất: ");
        triangle.setSide1(scanner.nextDouble());
        System.out.print("Nhập cạnh thứ hai: ");
        triangle.setSide2(scanner.nextDouble());
        System.out.print("Nhập cạnh thứ ba: ");
        triangle.setSide3(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Nhập màu bạn muốn: ");
        triangle.setColor(scanner.nextLine());

        System.out.println(triangle.toString());
    }
}
