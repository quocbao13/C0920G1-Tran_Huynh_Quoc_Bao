package _06_inheritance.exercise.point_moveable_point;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed = 1.0f;
    private float ySpeed = 1.0f;

    MoveablePoint(){

    }

    MoveablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    public float[] getSpeed() {
        float[] arrSpeed = new float[2];
        arrSpeed[0] = getXSpeed();
        arrSpeed[1] = getYSpeed();
        return arrSpeed;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "(" + super.getX() +
                "," + super.getY() +
                "), Speed=" + Arrays.toString(getSpeed()) +
                "} ";
    }

    MoveablePoint move(){
        super.setX(super.getX() + getXSpeed());
        super.setY(super.getY() + getYSpeed());
        return this;
    }
}
