package _06_inheritance.exercise.point2d_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 1.0f;
    private float[] arr3D = new float[3];
    Point3D() {

    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        setZ(z);
    }

    public float[] getXYZ() {
        arr3D[0] = super.getXY()[0];
        arr3D[1] = super.getXY()[1];
        arr3D[2] = getZ();
        return arr3D;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", arr3D=" + Arrays.toString(getXYZ()) +
                "} " + super.toString();
    }
}
