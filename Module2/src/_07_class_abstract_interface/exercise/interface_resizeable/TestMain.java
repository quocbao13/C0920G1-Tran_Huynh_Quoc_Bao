package _07_class_abstract_interface.exercise.interface_resizeable;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        for (Shape shape: shapes){
            shape.resize(100);
        }

        System.out.println(Arrays.toString(shapes));
    }
}
