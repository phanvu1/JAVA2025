package Object;

import java.util.Scanner;
import java.math.BigDecimal;

// Lớp đối tượng ChiTietPhieuNhap
public class ChiTietPhieuNhap {
    private int maphieunhap;
    private int masach;
    private BigDecimal gia;
    private int soluong;

    // Constructor mặc định
    public ChiTietPhieuNhap() {}

    // Constructor đầy đủ
    public ChiTietPhieuNhap(int maphieunhap, int masach, BigDecimal gia, int soluong) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.gia = gia;
        this.soluong = soluong;
    }

    // Getters và Setters
    public int getMaphieunhap() { return maphieunhap; }
    public void setMaphieunhap(int maphieunhap) { this.maphieunhap = maphieunhap; }

    public int getMasach() { return masach; }
    public void setMasach(int masach) { this.masach = masach; }

    public BigDecimal getGia() { return gia; }
    public void setGia(BigDecimal gia) { this.gia = gia; }

    public int getSoluong() { return soluong; }
    public void setSoluong(int soluong) { this.soluong = soluong; }

    // Nhập thông tin chi tiết phiếu nhập
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        maphieunhap = sc.nextInt();
        System.out.print("Nhập mã sách: ");
        masach = sc.nextInt();
        System.out.print("Nhập giá: ");
        gia = sc.nextBigDecimal();
        System.out.print("Nhập số lượng: ");
        soluong = sc.nextInt();
    }

    // Xuất thông tin chi tiết phiếu nhập
    public void xuatThongTin() {
        System.out.println("Mã phiếu nhập: " + maphieunhap);
        System.out.println("Mã sách: " + masach);
        System.out.println("Giá: " + gia);
        System.out.println("Số lượng: " + soluong);
    }
}
