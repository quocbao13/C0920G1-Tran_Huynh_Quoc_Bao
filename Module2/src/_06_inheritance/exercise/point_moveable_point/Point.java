package _06_inheritance.exercise.point_moveable_point;

import java.util.Arrays;

public class Point {
    private float x = 1.0f;
    private float y = 1.0f;

    Point(){

    }

    Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] arrXY = new float[2];
        arrXY[0] = getX();
        arrXY[1] = getY();
        return arrXY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", arr XY=" + Arrays.toString(getXY()) +
                '}';
    }
}
