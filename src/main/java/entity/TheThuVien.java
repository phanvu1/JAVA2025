package entity;

import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TheThuVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mathetv;
    private String ngaybd;
    private String ngayhh;
    private String ghichu;

    public TheThuVien() {}

    public TheThuVien(Long mathetv, String ngaybd, String ngayhh, String ghichu) {
        this.mathetv = mathetv;
        this.ngaybd = ngaybd;
        this.ngayhh = ngayhh;
        this.ghichu = ghichu;
    }

    public TheThuVien(TheThuVien object) {
        this.mathetv = object.mathetv;
        this.ngaybd = object.ngaybd;
        this.ngayhh = object.ngayhh;
        this.ghichu = object.ghichu;
    }

    public Long getMathetv() { return mathetv; }
    public void setMathetv(Long mathetv) { this.mathetv = mathetv; }
    public String getNgaybd() { return ngaybd; }
    public void setNgaybd(String ngaybd) { this.ngaybd = ngaybd; }
    public String getNgayhh() { return ngayhh; }
    public void setNgayhh(String ngayhh) { this.ngayhh = ngayhh; }
    public String getGhichu() { return ghichu; }
    public void setGhichu(String ghichu) { this.ghichu = ghichu; }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thẻ thư viện: ");
        mathetv = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập ngày bắt đầu: ");
        ngaybd = sc.nextLine();
        System.out.print("Nhập ngày hết hạn: ");
        ngayhh = sc.nextLine();
        System.out.print("Nhập ghi chú: ");
        ghichu = sc.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("Mã thẻ thư viện: " + mathetv);
        System.out.println("Ngày bắt đầu: " + ngaybd);
        System.out.println("Ngày hết hạn: " + ngayhh);
        System.out.println("Ghi chú: " + ghichu);
    }
}