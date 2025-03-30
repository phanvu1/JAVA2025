package Object;

import java.util.Scanner;

public class TaiKhoan {
    private int mataikhoan;
    private String username;
    private String password;
    private int idnhomquyen;

    // Constructor mặc định
    public TaiKhoan() {}

    // Constructor đầy đủ
    public TaiKhoan(int mataikhoan, String username, String password, int idnhomquyen) {
        this.mataikhoan = mataikhoan;
        this.username = username;
        this.password = password;
        this.idnhomquyen = idnhomquyen;
    }

    // Getters và Setters
    public int getMaTaiKhoan() {
        return mataikhoan;
    }

    public void setMaTaiKhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdNhomQuyen() {
        return idnhomquyen;
    }

    public void setIdNhomQuyen(int idnhomquyen) {
        this.idnhomquyen = idnhomquyen;
    }

    // Nhập thông tin tài khoản
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã tài khoản: ");
        mataikhoan = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập username: ");
        username = sc.nextLine();
        System.out.print("Nhập password: ");
        password = sc.nextLine();
        System.out.print("Nhập ID nhóm quyền: ");
        idnhomquyen = sc.nextInt();
    }

    // Xuất thông tin tài khoản
    public void xuat() {
        System.out.println("Mã tài khoản: " + mataikhoan);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("ID nhóm quyền: " + idnhomquyen);
    }
}
