package dto;

import java.util.Date;

public class ThongKePhieuNhapDTO {
    private int maphieunhap;
    private int masach;
    private double gianhap;
    private int soluong;
    private double thanhtien;
    private Date ngaynhap;
    private String tensach;

    // Constructor mặc định
    public ThongKePhieuNhapDTO() {
    }

    // Constructor đầy đủ tham số
    public ThongKePhieuNhapDTO(int maphieunhap, int masach, double gianhap, int soluong, double thanhtien, Date ngaynhap, String tensach) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.ngaynhap = ngaynhap;
        this.tensach = tensach;
    }

    // Constructor không có thanhtien (tính toán sau)
    public ThongKePhieuNhapDTO(int maphieunhap, int masach, double gianhap, int soluong, Date ngaynhap, String tensach) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.thanhtien = gianhap * soluong; // Tính mặc định
        this.ngaynhap = ngaynhap;
        this.tensach = tensach;
    }

    // Phương thức thiết lập từ một ThongKePhieuNhapDTO khác
    public void setFromThongKePhieuNhapDTO(ThongKePhieuNhapDTO other) {
        if (other != null) {
            this.maphieunhap = other.maphieunhap;
            this.masach = other.masach;
            this.gianhap = other.gianhap;
            this.soluong = other.soluong;
            this.thanhtien = other.thanhtien;
            this.ngaynhap = other.ngaynhap != null ? new Date(other.ngaynhap.getTime()) : null;
            this.tensach = other.tensach;
        }
    }

    // Getter và Setter cho maphieunhap
    public int getmaphieunhap() {
        return maphieunhap;
    }

    public void setmaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    // Getter và Setter cho masach
    public int getmasach() {
        return masach;
    }

    public void setmasach(int masach) {
        this.masach = masach;
    }

    // Getter và Setter cho gianhap
    public double getgianhap() {
        return gianhap;
    }

    public void setgianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    // Getter và Setter cho soluong
    public int getsoluong() {
        return soluong;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

    // Getter và Setter cho thanhtien
    public double getthanhtien() {
        return thanhtien;
    }

    public void setthanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    // Getter và Setter cho ngaynhap
    public Date getngaynhap() {
        return ngaynhap;
    }

    public void setngaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    // Getter và Setter cho tensach
    public String gettensach() {
        return tensach;
    }

    public void settensach(String tensach) {
        this.tensach = tensach;
    }
}