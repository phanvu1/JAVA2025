package Object;

import java.util.Date;
import java.util.Scanner;

// Lớp đối tượng PhieuMuon
public class PhieuMuon {
    private int maphieumuon;
    private int manv;
    private int madocgia;
    private Date ngaymuon;
    private String tinhtrang; // Trạng thái phiếu mượn

    // Constructor mặc định
    public PhieuMuon() {}

    // Constructor đầy đủ
    public PhieuMuon(int maphieumuon, int manv, int madocgia, Date ngaymuon, String tinhtrang) {
        this.maphieumuon = maphieumuon;
        this.manv = manv;
        this.madocgia = madocgia;
        this.ngaymuon = ngaymuon;
        this.tinhtrang = tinhtrang;
    }

    // Getters và Setters
    public int getMaphieumuon() {
        return maphieumuon;
    }

    public void setMaphieumuon(int maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(int madocgia) {
        this.madocgia = madocgia;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    // Nhập thông tin phiếu mượn
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu mượn: ");
        maphieumuon = sc.nextInt();
        System.out.print("Nhập mã nhân viên: ");
        manv = sc.nextInt();
        System.out.print("Nhập mã độc giả: ");
        madocgia = sc.nextInt();
        sc.nextLine(); // Xử lý trôi lệnh
        System.out.print("Nhập ngày mượn (yyyy-MM-dd): ");
        ngaymuon = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Nhập tình trạng: ");
        tinhtrang = sc.nextLine();
    }

    // Xuất thông tin phiếu mượn
    public void xuat() {
        System.out.println("Mã phiếu mượn: " + maphieumuon);
        System.out.println("Mã nhân viên: " + manv);
        System.out.println("Mã độc giả: " + madocgia);
        System.out.println("Ngày mượn: " + ngaymuon);
        System.out.println("Tình trạng: " + tinhtrang);
    }
}
