package dto;

import java.util.Date;

public class ChiTietPhieuMuonDTO {
    private int maPhieuMuon;
    private int maSach;
    private Date ngayTra;
    private String ghiChu;

    // Constructor mặc định
    public ChiTietPhieuMuonDTO() {
    }

    // Constructor đầy đủ tham số
    public ChiTietPhieuMuonDTO(int maPhieuMuon, int maSach, Date ngayTra, String ghiChu) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }

    // Phương thức thiết lập từ một ChiTietPhieuMuonDTO khác
    public void setFromChiTietPhieuMuonDTO(ChiTietPhieuMuonDTO other) {
        if (other != null) {
            this.maPhieuMuon = other.maPhieuMuon;
            this.maSach = other.maSach;
            this.ngayTra = other.ngayTra != null ? new Date(other.ngayTra.getTime()) : null;
            this.ghiChu = other.ghiChu;
        }
    }

    // Getter và Setter cho maPhieuMuon
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    // Getter và Setter cho maSach
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    // Getter và Setter cho ngayTra
    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    // Getter và Setter cho ghiChu
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}