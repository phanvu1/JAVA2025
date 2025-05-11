package bus;

import dao.ChiTietPhieuMuonDAO;
import dto.ChiTietPhieuMuonDTO;
import java.util.ArrayList;

public class ChiTietPhieuMuonBUS {
    private ChiTietPhieuMuonDAO chitietphieumuondao;

    public ChiTietPhieuMuonBUS() {
        this.chitietphieumuondao = new ChiTietPhieuMuonDAO();
    }

    // Lấy tất cả chi tiết phiếu mượn
    public ArrayList<ChiTietPhieuMuonDTO> getAllChiTietPhieuMuon() {
        return chitietphieumuondao.getAll();
    }

    // Thêm chi tiết phiếu mượn mới
    public boolean addChiTietPhieuMuon(ChiTietPhieuMuonDTO chitietphieumuon) {
        return chitietphieumuondao.insert(chitietphieumuon);
    }

    // Cập nhật chi tiết phiếu mượn
    public boolean updateChiTietPhieuMuon(ChiTietPhieuMuonDTO chitietphieumuon) {
        return chitietphieumuondao.update(chitietphieumuon);
    }

    // Xóa chi tiết phiếu mượn
    public boolean deleteChiTietPhieuMuon(int maPhieuMuon, int maSach) {
        return chitietphieumuondao.delete(maPhieuMuon, maSach);
    }

    // Tìm kiếm chi tiết phiếu mượn theo mã
    public ChiTietPhieuMuonDTO getChiTietPhieuMuonById(int maPhieuMuon, int maSach) {
        return chitietphieumuondao.getById(maPhieuMuon, maSach);
    }

    public boolean deleteByMaPN(int maPhieuMuon) {
        return chitietphieumuondao.deleteByMaPN(maPhieuMuon);
    }

    public int getSoLuongSachDangMuon() {
        return chitietphieumuondao.getSoLuongSachDangMuon();
    }

    public static ChiTietPhieuMuonBUS iBus = null;

    public static ChiTietPhieuMuonBUS gI() {
        if (iBus == null) {
            iBus = new ChiTietPhieuMuonBUS();
        }
        return iBus;
    }
}