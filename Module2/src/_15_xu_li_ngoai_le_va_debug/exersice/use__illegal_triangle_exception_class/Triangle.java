package _15_xu_li_ngoai_le_va_debug.exersice.use__illegal_triangle_exception_class;

public class Triangle {

    private double slide1;
    private double slide2;
    private double slide3;

    Triangle () {

    }

    Triangle(double slide1, double slide2, double slide3) throws IllegalTriangleException {
        if (slide1 >= slide2 + slide3){
            throw new IllegalTriangleException(slide1);
        } else if (slide2 >= slide1 + slide3){
            throw new IllegalTriangleException(slide2);
        } else if (slide3 >= slide1 + slide2){
            throw new IllegalTriangleException(slide3);
        }
        if (slide1 <= 0 || slide2 <= 0 || slide3 <= 0){
            throw new IllegalTriangleException();
        }
        System.out.println("Finally");
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
    }

    public double getSlide1() {
        return slide1;
    }

    public void setSlide1(int slide1) {
        this.slide1 = slide1;
    }

    public double getSlide2() {
        return slide2;
    }

    public void setSlide2(int slide2) {
        this.slide2 = slide2;
    }

    public double getSlide3() {
        return slide3;
    }

    public void setSlide3(int slide3) {
        this.slide3 = slide3;
    }
}
