package bus;

import dao.PhieuMuonDAO;
import dao.ChiTietPhieuMuonDAO;
import dto.PhieuMuonDTO;
import dto.ChiTietPhieuMuonDTO;
import java.util.ArrayList;

public class PhieuMuonBUS {
    private PhieuMuonDAO phieuMuonDAO;
    private ChiTietPhieuMuonDAO chiTietPhieuMuonDAO;

    public PhieuMuonBUS() {
        this.phieuMuonDAO = new PhieuMuonDAO();
        this.chiTietPhieuMuonDAO = new ChiTietPhieuMuonDAO();
    }

    // Lấy tất cả phiếu mượn
    public ArrayList<PhieuMuonDTO> getAllPhieuMuon() {
        return phieuMuonDAO.getAll();
    }

    // Thêm phiếu mượn mới
    public boolean addPhieuMuon(PhieuMuonDTO phieuMuon) {
        return phieuMuonDAO.insert(phieuMuon);
    }

    // Cập nhật phiếu mượn
    public boolean updatePhieuMuon(PhieuMuonDTO phieuMuon) {
        return phieuMuonDAO.update(phieuMuon);
    }

    // Xóa phiếu mượn
    public boolean deletePhieuMuon(int maPM) {
        return phieuMuonDAO.delete(maPM);
    }

    // Tìm kiếm phiếu mượn theo mã
    public PhieuMuonDTO getPhieuMuonById(int maPM) {
        return phieuMuonDAO.getById(maPM);
    }

    // Lấy chi tiết phiếu mượn
    public ArrayList<ChiTietPhieuMuonDTO> getChiTietPhieuMuon(int maPM) {
        return chiTietPhieuMuonDAO.getChiTietPhieuMuonByMaPhieuMuon(maPM);
    }

    // Thêm chi tiết phiếu mượn
    public boolean addChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        return chiTietPhieuMuonDAO.saveChiTietPhieuMuon(chiTiet);
    }

    // Xóa chi tiết phiếu mượn
    public boolean deleteChiTietPhieuMuon(int maPM, int maSach) {
        return chiTietPhieuMuonDAO.deleteChiTietPhieuMuon(maPM, maSach);
    }

    // Singleton pattern
    public static PhieuMuonBUS iBus = null;

    public static PhieuMuonBUS gI() {
        if (iBus == null) {
            iBus = new PhieuMuonBUS();
        }
        return iBus;
    }
}