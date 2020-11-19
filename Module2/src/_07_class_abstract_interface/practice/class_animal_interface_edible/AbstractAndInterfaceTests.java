package _07_class_abstract_interface.practice.class_animal_interface_edible;

import _07_class_abstract_interface.practice.class_animal_interface_edible.edible.Edible;
import _07_class_abstract_interface.practice.class_animal_interface_edible.fruit.Fruit;
import _07_class_abstract_interface.practice.class_animal_interface_edible.fruit.Orange;
import _07_class_abstract_interface.practice.class_animal_interface_edible.fruit.Apple;
public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}