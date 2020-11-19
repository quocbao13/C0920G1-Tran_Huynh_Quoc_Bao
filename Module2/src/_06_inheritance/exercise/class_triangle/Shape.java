package _06_inheritance.exercise.class_triangle;

public class Shape {
    private String color ="Red";

    Shape() {

    }

    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                '}';
    }
}
