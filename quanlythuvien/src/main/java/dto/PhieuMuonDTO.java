package dto;

import java.util.Date;

public class PhieuMuonDTO {
    private int maPM;          
    private int maNV;          
    private int maDocGia;      
    private Date ngayMuon;     
    private String tinhTrang;
    
    // Constructor mặc định
    public PhieuMuonDTO() {
    }

    // Constructor đầy đủ tham số
    public PhieuMuonDTO(int maPM, int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maPM = maPM;
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }

    // Constructor không có mã phiếu mượn (dùng khi thêm mới, vì maPM có thể auto increment)
    public PhieuMuonDTO(int maNV, int maDocGia, Date ngayMuon, String tinhTrang) {
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }

    // Getter và Setter
    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
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
