package _06_inheritance.exercise.circle_cylinder;

public class Circle {
    private double r;
    private String color;
    Circle() {

    }

    Circle(double r, String color) {
        this.r = r;
        this.color = color;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        double area = 0.0;
        area = Math.pow(this.r, 2) * Math.PI;
        return area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", color='" + color + '\'' +
                ", area='" + getArea() + '\'' +
                '}';
    }
}
