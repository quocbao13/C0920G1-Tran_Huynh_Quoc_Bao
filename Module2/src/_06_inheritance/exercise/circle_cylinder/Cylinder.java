package _06_inheritance.exercise.circle_cylinder;

public class Cylinder extends Circle {
    private double h = 0.0;
    Cylinder(){

    }

    Cylinder(double r, String color, double h){
        super(r,color);
        this.h = h;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public void setR(double r) {
        super.setR(r);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public double getVolume() {
        double volume = 0.0;
        volume = super.getArea() * this.h;
        return volume;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "h=" + h +
                ", volume=" + getVolume() +
                "} " + super.toString();
    }
}
