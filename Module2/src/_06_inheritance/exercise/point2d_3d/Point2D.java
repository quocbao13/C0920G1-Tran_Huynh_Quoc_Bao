package _06_inheritance.exercise.point2d_3d;

import java.util.Arrays;

public class Point2D {
    private float x = 1.0f;
    private float y = 2.0f;

    float[] arr = new float[2];

    Point2D() {

    }

    Point2D(float x, float y){
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

    public float[] getXY() {
        arr[0] = getX();
        arr[1] = getY();
        return arr;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                ", arr=" + Arrays.toString(getXY()) +
                '}';
    }
}
