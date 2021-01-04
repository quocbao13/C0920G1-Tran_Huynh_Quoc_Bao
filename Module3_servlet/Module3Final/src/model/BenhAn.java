package model;

public class BenhAn {
    private int id;
    private String ngayVao;
    private String ngayRa;
    private String lyDoNhapVien;
    private BenhNhan benhNhan;

    public BenhAn() {}

    public BenhAn(int id, String ngayVao, String ngayRa, String lyDoNhapVien, BenhNhan benhNhan) {
        this.id = id;
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.lyDoNhapVien = lyDoNhapVien;
        this.benhNhan = benhNhan;
    }

    public BenhAn(String ngayVao, String ngayRa, String lyDoNhapVien, BenhNhan benhNhan) {
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.lyDoNhapVien = lyDoNhapVien;
        this.benhNhan = benhNhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}
