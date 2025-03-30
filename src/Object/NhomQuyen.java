package Object;

import java.util.Scanner;

public class NhomQuyen {
    private int idnhomquyen;
    private String tennhomquyen;
    private String mota;

    // Constructor mặc định
    public NhomQuyen() {}

    // Constructor đầy đủ
    public NhomQuyen(int idnhomquyen, String tennhomquyen, String mota) {
        this.idnhomquyen = idnhomquyen;
        this.tennhomquyen = tennhomquyen;
        this.mota = mota;
    }

    // Getters và Setters
    public int getIdNhomQuyen() {
        return idnhomquyen;
    }

    public void setIdNhomQuyen(int idnhomquyen) {
        this.idnhomquyen = idnhomquyen;
    }

    public String getTenNhomQuyen() {
        return tennhomquyen;
    }

    public void setTenNhomQuyen(String tennhomquyen) {
        this.tennhomquyen = tennhomquyen;
    }

    public String getMoTa() {
        return mota;
    }

    public void setMoTa(String mota) {
        this.mota = mota;
    }

    // Nhập thông tin nhóm quyền
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID nhóm quyền: ");
        idnhomquyen = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập tên nhóm quyền: ");
        tennhomquyen = sc.nextLine();
        System.out.print("Nhập mô tả: ");
        mota = sc.nextLine();
    }

    // Xuất thông tin nhóm quyền
    public void xuat() {
        System.out.println("ID nhóm quyền: " + idnhomquyen);
        System.out.println("Tên nhóm quyền: " + tennhomquyen);
        System.out.println("Mô tả: " + mota);
    }
}
