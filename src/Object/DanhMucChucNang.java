package Object;

import java.util.Scanner;

public class DanhMucChucNang {
    private int iddanhmucchucnang;
    private String tenchucnang;
    private boolean trangthai;

    // Constructor mặc định
    public DanhMucChucNang() {}

    // Constructor đầy đủ
    public DanhMucChucNang(int iddanhmucchucnang, String tenchucnang, boolean trangthai) {
        this.iddanhmucchucnang = iddanhmucchucnang;
        this.tenchucnang = tenchucnang;
        this.trangthai = trangthai;
    }

    // Getters và Setters
    public int getIdDanhMucChucNang() {
        return iddanhmucchucnang;
    }

    public void setIdDanhMucChucNang(int iddanhmucchucnang) {
        this.iddanhmucchucnang = iddanhmucchucnang;
    }

    public String getTenChucNang() {
        return tenchucnang;
    }

    public void setTenChucNang(String tenchucnang) {
        this.tenchucnang = tenchucnang;
    }

    public boolean isTrangThai() {
        return trangthai;
    }

    public void setTrangThai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    // Nhập thông tin danh mục chức năng
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID danh mục chức năng: ");
        iddanhmucchucnang = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập tên chức năng: ");
        tenchucnang = sc.nextLine();
        System.out.print("Nhập trạng thái (true/false): ");
        trangthai = sc.nextBoolean();
    }

    // Xuất thông tin danh mục chức năng
    public void xuat() {
        System.out.println("ID danh mục chức năng: " + iddanhmucchucnang);
        System.out.println("Tên chức năng: " + tenchucnang);
        System.out.println("Trạng thái: " + (trangthai ? "Hoạt động" : "Không hoạt động"));
    }
}
