package _05_access_modifier_static_method_static_property.execise.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){

    }

    Circle(double radius){
        this.radius = radius;
    }

    private double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        double area = 0;
        area = Math.pow(getRadius(),2) * Math.PI;
        return area;
    }
}
