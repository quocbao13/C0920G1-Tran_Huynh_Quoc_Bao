package _07_class_abstract_interface.practice.class_animal_interface_edible;
import _07_class_abstract_interface.practice.class_animal_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
