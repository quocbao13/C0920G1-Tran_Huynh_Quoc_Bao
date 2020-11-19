package _15_xu_li_ngoai_le_va_debug.exersice.use__illegal_triangle_exception_class;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(double side) {
        super(side + " Lỗi tổng 2 cạnh bé hơn cạnh còn lại");
    }
    public IllegalTriangleException(){
        super("Cạnh bé hơn 0");
    }
}
