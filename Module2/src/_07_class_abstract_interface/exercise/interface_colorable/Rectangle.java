package _07_class_abstract_interface.exercise.interface_colorable;

public class Rectangle extends Shape{
    private double width = 1.0;
    private double height = 1.0;

    Rectangle(){

    }

    Rectangle(double width, double height, String color){
        super(color);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        double area = getHeight() * getWidth();
        return area;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                "} " + super.toString();
    }
}
