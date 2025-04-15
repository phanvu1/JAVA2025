package entity;

import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manxb;
    private String tennxb;
    private String diachi;
    private String sdt;

    public NhaXuatBan() {}

    public NhaXuatBan(Long manxb, String tennxb, String diachi, String sdt) {
        this.manxb = manxb;
        this.tennxb = tennxb;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public NhaXuatBan(NhaXuatBan object) {
        this.manxb = object.manxb;
        this.tennxb = object.tennxb;
        this.diachi = object.diachi;
        this.sdt = object.sdt;
    }

    public Long getManxb() {
        return manxb;
    }

    public void setManxb(Long manxb) {
        this.manxb = manxb;
    }

    public String getTennxb() {
        return tennxb;
    }

    public void setTennxb(String tennxb) {
        this.tennxb = tennxb;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NXB: ");
        this.manxb = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên NXB: ");
        this.tennxb = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diachi = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.sdt = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Mã NXB: " + this.manxb);
        System.out.println("Tên NXB: " + this.tennxb);
        System.out.println("Địa chỉ: " + this.diachi);
        System.out.println("Số điện thoại: " + this.sdt);
    }
}