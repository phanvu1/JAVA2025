package dto;

import java.util.Date;

public class PhieuMuonDTO {
    private int maPhieuMuon;
    private int maNV;
    private int maDocGia;
    private Date ngayMuon;
    private String tinhTrang;

    public PhieuMuonDTO() {
    }

    public PhieuMuonDTO(int maPhieuMuon, int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maPhieuMuon = maPhieuMuon;
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }
    
        public PhieuMuonDTO(int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}