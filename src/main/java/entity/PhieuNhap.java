package entity;

import java.util.Date;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maphieunhap;
    private Long mancc;
    private Long manv;
    private Date ngaynhap;

    public PhieuNhap() {}

    public PhieuNhap(Long maphieunhap, Long mancc, Long manv, Date ngaynhap) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
    }

    public PhieuNhap(PhieuNhap object) {
        this.maphieunhap = object.maphieunhap;
        this.mancc = object.mancc;
        this.manv = object.manv;
        this.ngaynhap = object.ngaynhap;
    }

    public Long getMaphieunhap() { return maphieunhap; }
    public void setMaphieunhap(Long maphieunhap) { this.maphieunhap = maphieunhap; }

    public Long getMancc() { return mancc; }
    public void setMancc(Long mancc) { this.mancc = mancc; }

    public Long getManv() { return manv; }
    public void setManv(Long manv) { this.manv = manv; }

    public Date getNgaynhap() { return ngaynhap; }
    public void setNgaynhap(Date ngaynhap) { this.ngaynhap = ngaynhap; }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        maphieunhap = sc.nextLong();
        System.out.print("Nhập mã nhà cung cấp: ");
        mancc = sc.nextLong();
        System.out.print("Nhập mã nhân viên: ");
        manv = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập ngày nhập (yyyy-MM-dd): ");
        ngaynhap = java.sql.Date.valueOf(sc.nextLine());
    }

    public void xuatThongTin() {
        System.out.println("Mã phiếu nhập: " + maphieunhap);
        System.out.println("Mã nhà cung cấp: " + mancc);
        System.out.println("Mã nhân viên: " + manv);
        System.out.println("Ngày nhập: " + ngaynhap);
    }
}