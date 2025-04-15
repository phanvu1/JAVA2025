package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Scanner;

public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mancc;
    private String tenncc;

    public NhaCungCap() {}

    public NhaCungCap(Long mancc, String tenncc) {
        this.mancc = mancc;
        this.tenncc = tenncc;
    }

    public NhaCungCap(NhaCungCap object) {
        this.mancc = object.mancc;
        this.tenncc = object.tenncc;
    }

    public Long getMancc() { return mancc; }
    public void setMancc(Long mancc) { this.mancc = mancc; }
    public String getTenncc() { return tenncc; }
    public void setTenncc(String tenncc) { this.tenncc = tenncc; }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp: ");
        mancc = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        tenncc = sc.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("Mã nhà cung cấp: " + mancc);
        System.out.println("Tên nhà cung cấp: " + tenncc);
    }
}