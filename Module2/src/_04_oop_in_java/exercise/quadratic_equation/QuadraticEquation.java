package _04_oop_in_java.exercise.quadratic_equation;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant(){
        double delta = 0;
        delta = Math.pow(this.b,2) - 4 * this.a * this.c;
        return delta;
    }

    public double getRoot1(){
        double r1 = (-(this.b) + Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        return r1;
    }

    public double getRoot2(){
        double r2 = (-(this.b) - Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        return r2;
    }

    public String getKQ(){
        double d = getDiscriminant();
        String kQ = "";
        if (d > 0){
            kQ = "Quadratic equation have 2 roots: " + getRoot1()+ " and " + getRoot2();
        }else if (d == 0){
            kQ = "Quadratic equation have 1 roots: "+ getRoot1();
        }else if (d < 0){
            kQ = "The equation has no roots";
        }
        return kQ;
    }

    public static void main(String[] args) {
        double a,b,c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number a:");
        a = scanner.nextDouble();
        System.out.print("Enter number b:");
        b = scanner.nextDouble();
        System.out.print("Enter number c:");
        c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);

        System.out.println(quadraticEquation.getKQ());
    }
}
