package entity;

import java.math.BigDecimal;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChiTietPhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maphieunhap;
    private Long masach;
    private BigDecimal gia;
    private Integer soluong;

    public ChiTietPhieuNhap() {}

    public ChiTietPhieuNhap(Long maphieunhap, Long masach, BigDecimal gia, Integer soluong) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.gia = gia;
        this.soluong = soluong;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap object) {
        this.maphieunhap = object.maphieunhap;
        this.masach = object.masach;
        this.gia = object.gia;
        this.soluong = object.soluong;
    }

    public Long getMaphieunhap() { return maphieunhap; }
    public void setMaphieunhap(Long maphieunhap) { this.maphieunhap = maphieunhap; }

    public Long getMasach() { return masach; }
    public void setMasach(Long masach) { this.masach = masach; }

    public BigDecimal getGia() { return gia; }
    public void setGia(BigDecimal gia) { this.gia = gia; }

    public Integer getSoluong() { return soluong; }
    public void setSoluong(Integer soluong) { this.soluong = soluong; }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        maphieunhap = sc.nextLong();
        System.out.print("Nhập mã sách: ");
        masach = sc.nextLong();
        System.out.print("Nhập giá: ");
        gia = sc.nextBigDecimal();
        System.out.print("Nhập số lượng: ");
        soluong = sc.nextInt();
    }

    public void xuatThongTin() {
        System.out.println("Mã phiếu nhập: " + maphieunhap);
        System.out.println("Mã sách: " + masach);
        System.out.println("Giá: " + gia);
        System.out.println("Số lượng: " + soluong);
    }
}