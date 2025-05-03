package bus;

import dao.ChiTietPhieuMuonDAO;

public class ChiTietPhieuMuonBUS {
    private ChiTietPhieuMuonDAO chitietphieumuondao;

    // Constructor
    public ChiTietPhieuMuonBUS() {
        this.chitietphieumuondao = new ChiTietPhieuMuonDAO();
    }

    // Lấy số lượng sách đang mượn
    public int getSoLuongSachDangMuon() {
        return chitietphieumuondao.getSoLuongSachDangMuon();
    }

    // Mô hình Singleton
    public static ChiTietPhieuMuonBUS iBus = null;

    public static ChiTietPhieuMuonBUS gI() {
        if (iBus == null) {
            iBus = new ChiTietPhieuMuonBUS();
        }
        return iBus;
    }
}