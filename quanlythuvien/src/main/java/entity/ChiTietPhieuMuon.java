package entity;

import java.util.Date;
import java.util.Scanner;
import jakarta.persistence.*;

@Entity
// Lớp đối tượng ChiTietPhieuMuon
public class ChiTietPhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maphieumuon;
    
    
    private int masach;
    private Date ngaytra;
    private String ghichu;

    // Constructor mặc định
    public ChiTietPhieuMuon() {}

    // Constructor đầy đủ
    public ChiTietPhieuMuon(int maphieumuon, int masach, Date ngaytra, String ghichu) {
        this.maphieumuon = maphieumuon;
        this.masach = masach;
        this.ngaytra = ngaytra;
        this.ghichu = ghichu;
    }

    // Getters và Setters
    public int getMaphieumuon() { return maphieumuon; }
    public void setMaphieumuon(int maphieumuon) { this.maphieumuon = maphieumuon; }

    public int getMasach() { return masach; }
    public void setMasach(int masach) { this.masach = masach; }

    public Date getNgaytra() { return ngaytra; }
    public void setNgaytra(Date ngaytra) { this.ngaytra = ngaytra; }

    public String getGhichu() { return ghichu; }
    public void setGhichu(String ghichu) { this.ghichu = ghichu; }

    // Nhập thông tin chi tiết phiếu mượn
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu mượn: ");
        maphieumuon = sc.nextInt();
        System.out.print("Nhập mã sách: ");
        masach = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập ngày trả (yyyy-MM-dd): ");
        ngaytra = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Nhập ghi chú: ");
        ghichu = sc.nextLine();
    }

    // Xuất thông tin chi tiết phiếu mượn
    public void xuatThongTin() {
        System.out.println("Mã phiếu mượn: " + maphieumuon);
        System.out.println("Mã sách: " + masach);
        System.out.println("Ngày trả: " + ngaytra);
        System.out.println("Ghi chú: " + ghichu);
    }
}
