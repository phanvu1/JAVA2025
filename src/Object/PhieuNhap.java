package Object;

import java.util.Date;
import java.util.Scanner;

// Lớp đối tượng PhieuNhap
public class PhieuNhap {
    private int maphieunhap;
    private int mancc;
    private int manv;
    private Date ngaynhap;

    // Constructor mặc định
    public PhieuNhap() {}

    // Constructor đầy đủ
    public PhieuNhap(int maphieunhap, int mancc, int manv, Date ngaynhap) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
    }

    // Getters và Setters
    public int getMaphieunhap() { return maphieunhap; }
    public void setMaphieunhap(int maphieunhap) { this.maphieunhap = maphieunhap; }

    public int getMancc() { return mancc; }
    public void setMancc(int mancc) { this.mancc = mancc; }

    public int getManv() { return manv; }
    public void setManv(int manv) { this.manv = manv; }

    public Date getNgaynhap() { return ngaynhap; }
    public void setNgaynhap(Date ngaynhap) { this.ngaynhap = ngaynhap; }

    // Nhập thông tin phiếu nhập
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        maphieunhap = sc.nextInt();
        System.out.print("Nhập mã nhà cung cấp: ");
        mancc = sc.nextInt();
        System.out.print("Nhập mã nhân viên: ");
        manv = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập ngày nhập (yyyy-MM-dd): ");
        ngaynhap = java.sql.Date.valueOf(sc.nextLine());
    }

    // Xuất thông tin phiếu nhập
    public void xuatThongTin() {
        System.out.println("Mã phiếu nhập: " + maphieunhap);
        System.out.println("Mã nhà cung cấp: " + mancc);
        System.out.println("Mã nhân viên: " + manv);
        System.out.println("Ngày nhập: " + ngaynhap);
    }
}
