package dto;

import java.util.Date;

public class ChiTietPhieuMuonDTO {
    private int maPhieuMuon;
    private int maSach;
    private Date ngayTra;
    private String ghiChu;

    public ChiTietPhieuMuonDTO() {
    }

    public ChiTietPhieuMuonDTO(int maPhieuMuon, int maSach, Date ngayTra, String ghiChu) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}