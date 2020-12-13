package models;

public class KhachHang {
    private int id_khach_hang;
    private String ho_ten;
    private String ngay_sinh;
    private String so_cmnd;
    private String sdt;
    private String email;
    private String diachi;
    private int loai_khach_hang_id;

    public KhachHang(){}

    public KhachHang(int id_khach_hang, String ho_ten, String ngay_sinh,
                     String so_cmnd, String sdt, String email, String diachi, int loai_khach_hang_id) {
        this.id_khach_hang = id_khach_hang;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.so_cmnd = so_cmnd;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.loai_khach_hang_id = loai_khach_hang_id;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSo_cmnd() {
        return so_cmnd;
    }

    public void setSo_cmnd(String so_cmnd) {
        this.so_cmnd = so_cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getLoai_khach_hang_id() {
        return loai_khach_hang_id;
    }

    public void setLoai_khach_hang_id(int loai_khach_hang_id) {
        this.loai_khach_hang_id = loai_khach_hang_id;
    }
}
