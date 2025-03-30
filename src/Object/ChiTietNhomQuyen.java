package Object;

import java.util.Scanner;

public class ChiTietNhomQuyen {
    private int idchitietnhomquyen;
    private int idquyen;
    private int idchucnang;
    private String hanhdong;

    // Constructor mặc định
    public ChiTietNhomQuyen() {}

    // Constructor đầy đủ
    public ChiTietNhomQuyen(int idchitietnhomquyen, int idquyen, int idchucnang, String hanhdong) {
        this.idchitietnhomquyen = idchitietnhomquyen;
        this.idquyen = idquyen;
        this.idchucnang = idchucnang;
        this.hanhdong = hanhdong;
    }

    // Getters và Setters
    public int getIdChiTietNhomQuyen() {
        return idchitietnhomquyen;
    }

    public void setIdChiTietNhomQuyen(int idchitietnhomquyen) {
        this.idchitietnhomquyen = idchitietnhomquyen;
    }

    public int getIdQuyen() {
        return idquyen;
    }

    public void setIdQuyen(int idquyen) {
        this.idquyen = idquyen;
    }

    public int getIdChucNang() {
        return idchucnang;
    }

    public void setIdChucNang(int idchucnang) {
        this.idchucnang = idchucnang;
    }

    public String getHanhDong() {
        return hanhdong;
    }

    public void setHanhDong(String hanhdong) {
        this.hanhdong = hanhdong;
    }

    // Nhập thông tin chi tiết nhóm quyền
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID chi tiết nhóm quyền: ");
        idchitietnhomquyen = sc.nextInt();
        System.out.print("Nhập ID quyền: ");
        idquyen = sc.nextInt();
        System.out.print("Nhập ID chức năng: ");
        idchucnang = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập hành động: ");
        hanhdong = sc.nextLine();
    }

    // Xuất thông tin chi tiết nhóm quyền
    public void xuat() {
        System.out.println("ID chi tiết nhóm quyền: " + idchitietnhomquyen);
        System.out.println("ID quyền: " + idquyen);
        System.out.println("ID chức năng: " + idchucnang);
        System.out.println("Hành động: " + hanhdong);
    }
}
