package _06_inheritance.exercise.class_triangle;

public class Triangle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() {

    }

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    Triangle(double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea(){
        double area;
        double p;
        p = (getSide1() + getSide2() + getSide3()) / 2;
        double x;
        x = p * (p - getSide1()) * (p - getSide2()) * (p - getSide3());
        area = Math.pow(x,0.5);
        return area;
    }

    public double getPerimeter(){
        double perimeter = 0;
        perimeter = getSide1() + getSide2() + getSide3();
        return perimeter;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + getSide1() +
                ", side2=" + getSide2() +
                ", side3=" + getSide3() +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                "} " + super.toString();
    }
}
