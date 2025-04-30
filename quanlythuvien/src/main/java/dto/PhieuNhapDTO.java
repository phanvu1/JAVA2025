package dto;

import java.util.Date;

public class PhieuNhapDTO {
    private int maphieunhap;
    private int mancc;
    private int manv;
    private Date ngaynhap;
    private double tongtien;

    // Constructor mặc định
    public PhieuNhapDTO() {
    }

    // Constructor đầy đủ tham số
    public PhieuNhapDTO(int maphieunhap, int mancc, int manv, Date ngaynhap, double tongtien) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
    }

    // Constructor mới với 4 tham số (không có tongtien, gán mặc định tongtien = 0.0)
    public PhieuNhapDTO(int maphieunhap, int mancc, int manv, Date ngaynhap) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.tongtien = 0.0; // Gán mặc định
    }

    // Phương thức thiết lập từ một PhieuNhapDTO khác
    public void setFromPhieuNhapDTO(PhieuNhapDTO other) {
        if (other != null) {
            this.maphieunhap = other.maphieunhap;
            this.mancc = other.mancc;
            this.manv = other.manv;
            this.ngaynhap = other.ngaynhap != null ? new Date(other.ngaynhap.getTime()) : null;
            this.tongtien = other.tongtien;
        }
    }

    // Getter và Setter cho maphieunhap
    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    // Getter và Setter cho mancc
    public int getMancc() {
        return mancc;
    }
    
    public double getTongTien() {
        return tongtien;
    }
    
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    // Getter và Setter cho manv
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    // Getter và Setter cho ngaynhap
    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
}