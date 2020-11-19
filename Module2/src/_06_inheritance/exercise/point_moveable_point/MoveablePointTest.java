package _06_inheritance.exercise.point_moveable_point;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(3,5);
        System.out.println(moveablePoint.toString());
        System.out.println(moveablePoint.move());
    }
}
