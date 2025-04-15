package entity;

import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// Lớp đối tượng NhanVien
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manv;
    private String tennv;
    private int namsinh;
    private String gioitinh;
    private String sdt;
    private String ngaybatdau;
    private double luong;
    private String diachi;
    private int mataikhoan;

    // Constructor mặc định
    public NhanVien() {
    }

    // Constructor đầy đủ
    public NhanVien(int manv, String tennv, int namsinh, String gioitinh, String sdt, String ngaybatdau, double luong,
            String diachi, int mataikhoan) {
        this.manv = manv;
        this.tennv = tennv;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.ngaybatdau = ngaybatdau;
        this.luong = luong;
        this.diachi = diachi;
        this.mataikhoan = mataikhoan;
    }

    // Getters và Setters
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    // Hàm nhập thông tin nhân viên (truyền Scanner từ bên ngoài)
    public void nhapThongTin(Scanner sc) {
        try {
            System.out.print("Nhập mã nhân viên: ");
            manv = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm

            System.out.print("Nhập tên nhân viên: ");
            tennv = sc.nextLine();

            System.out.print("Nhập năm sinh: ");
            namsinh = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhập giới tính: ");
            gioitinh = sc.nextLine();

            System.out.print("Nhập số điện thoại: ");
            sdt = sc.nextLine();

            System.out.print("Nhập ngày bắt đầu: ");
            ngaybatdau = sc.nextLine();

            // Kiểm tra nhập lương hợp lệ
            while (true) {
                try {
                    System.out.print("Nhập lương: ");
                    luong = sc.nextDouble();
                    sc.nextLine();
                    if (luong < 0) {
                        System.out.println("Lương không thể là số âm! Vui lòng nhập lại.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Lương phải là số! Vui lòng nhập lại.");
                    sc.nextLine(); // Xóa bộ nhớ đệm
                }
            }

            System.out.print("Nhập địa chỉ: ");
            diachi = sc.nextLine();

            System.out.print("Nhập mã tài khoản: ");
            mataikhoan = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nhập liệu! Hãy nhập đúng kiểu dữ liệu.");
            sc.nextLine(); // Xóa bộ nhớ đệm
        }
    }

    // Xuất thông tin nhân viên
    public void xuatThongTin() {
        System.out.println("Mã nhân viên: " + manv);
        System.out.println("Tên nhân viên: " + tennv);
        System.out.println("Năm sinh: " + namsinh);
        System.out.println("Giới tính: " + gioitinh);
        System.out.println("Số điện thoại: " + sdt);
        System.out.println("Ngày bắt đầu làm việc: " + ngaybatdau);
        System.out.println("Lương: " + String.format("%,.2f", luong) + " VND");
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("Mã tài khoản: " + mataikhoan);
    }
}
