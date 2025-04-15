package entity;

import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long madocgia;
    private String tendg;
    private String gioitinh;
    private String diachi;
    private Long mathe;

    public DocGia() {}

    public DocGia(Long madocgia, String tendg, String gioitinh, String diachi, Long mathe) {
        this.madocgia = madocgia;
        this.tendg = tendg;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.mathe = mathe;
    }

    public DocGia(DocGia object) {
        this.madocgia = object.madocgia;
        this.tendg = object.tendg;
        this.gioitinh = object.gioitinh;
        this.diachi = object.diachi;
        this.mathe = object.mathe;
    }

    public Long getMadocgia() { return madocgia; }
    public void setMadocgia(Long madocgia) { this.madocgia = madocgia; }
    public String getTendg() { return tendg; }
    public void setTendg(String tendg) { this.tendg = tendg; }
    public String getGioitinh() { return gioitinh; }
    public void setGioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }
    public Long getMathe() { return mathe; }
    public void setMathe(Long mathe) { this.mathe = mathe; }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã độc giả: ");
        madocgia = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên độc giả: ");
        tendg = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioitinh = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diachi = sc.nextLine();
        System.out.print("Nhập mã thẻ: ");
        mathe = sc.nextLong();
    }

    public void xuatThongTin() {
        System.out.println("Mã độc giả: " + madocgia);
        System.out.println("Tên độc giả: " + tendg);
        System.out.println("Giới tính: " + gioitinh);
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("Mã thẻ: " + mathe);
    }
}