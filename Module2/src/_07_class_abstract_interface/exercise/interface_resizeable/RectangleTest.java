package _07_class_abstract_interface.exercise.interface_resizeable;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3,6);
        System.out.println(rectangle.toString());
        rectangle.resize(100);
        System.out.println(rectangle.toString());
    }
}
