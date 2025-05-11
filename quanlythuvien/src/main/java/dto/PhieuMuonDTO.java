package dto;

import java.util.Date;

public class PhieuMuonDTO {
    private int maPhieuMuon;
    private int maNV;
    private int maDocGia;
    private Date ngayMuon;
    private String tinhTrang;

    // Constructor mặc định
    public PhieuMuonDTO() {
    }

    // Constructor đầy đủ tham số
    public PhieuMuonDTO(int maPhieuMuon, int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maPhieuMuon = maPhieuMuon;
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }

    // Constructor mới với 4 tham số (không có maPhieuMuon, gán mặc định maPhieuMuon = 0)
    public PhieuMuonDTO(int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
        this.maPhieuMuon = 0; // Gán mặc định
    }

    // Phương thức thiết lập từ một PhieuMuonDTO khác
    public void setFromPhieuMuonDTO(PhieuMuonDTO other) {
        if (other != null) {
            this.maPhieuMuon = other.maPhieuMuon;
            this.maNV = other.maNV;
            this.maDocGia = other.maDocGia;
            this.ngayMuon = other.ngayMuon != null ? new Date(other.ngayMuon.getTime()) : null;
            this.tinhTrang = other.tinhTrang;
        }
    }

    // Getter và Setter cho maPhieuMuon
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    // Getter và Setter cho maNV
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    // Getter và Setter cho maDocGia
    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    // Getter và Setter cho ngayMuon
    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    // Getter và Setter cho tinhTrang
    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}