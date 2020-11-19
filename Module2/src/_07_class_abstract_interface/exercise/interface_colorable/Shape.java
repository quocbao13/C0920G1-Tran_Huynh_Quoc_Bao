package _07_class_abstract_interface.exercise.interface_colorable;

public class Shape implements Colorable{
    private String color = "red";

    Shape(){

    }

    Shape(String color){
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
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public void howToColor() {

    }
}
