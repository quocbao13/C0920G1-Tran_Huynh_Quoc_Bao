package _04_oop_in_java.exercise.class_fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, boolean on, double radius, String color){
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }

    public int getFAST() {
        return FAST;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getSLOW() {
        return SLOW;
    }

    public String getSpeed() {
        String speedStr = "";
        if (this.speed == getSLOW()){
            speedStr = "SLOW";
        }else if (this.speed == getMEDIUM()){
            speedStr = "MEDIUM";
        }
        else if (this.speed == getFAST()){
            speedStr = "FAST";
        }
        return speedStr;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getOn(){
        String status = "";
        if (on){
            status = "Turning ON";
        }else {
            status = "Turning OFF";
        }
        return status;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String Fan1() {
        String fan1 = "Speed: " + getSpeed() +". Radius: " + getRadius() + ". Color: " + getColor() + ". Status: " + getOn();
        return fan1;
    }

    public static void main(String[] args) {
        Fan fan = new Fan(2,true,5,"red");
        System.out.println(fan.Fan1());
        fan = new Fan(3,true,2,"blue");
        System.out.println(fan.Fan1());
    }
}
