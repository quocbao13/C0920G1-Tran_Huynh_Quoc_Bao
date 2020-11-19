package _15_xu_li_ngoai_le_va_debug.exersice.use__illegal_triangle_exception_class;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập 3 cạnh! ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        Triangle triangle = new Triangle(a,b,c);
        System.out.println("Finally");
    }
}
