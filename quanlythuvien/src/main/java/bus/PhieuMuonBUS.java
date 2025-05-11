package bus;

import dao.PhieuMuonDAO;
import dto.PhieuMuonDTO;
import java.util.ArrayList;

public class PhieuMuonBUS {
    private PhieuMuonDAO phieumuondao;

    public PhieuMuonBUS() {
        this.phieumuondao = new PhieuMuonDAO();
    }

    // Lấy tất cả phiếu mượn
    public ArrayList<PhieuMuonDTO> getAllPhieuMuon() {
        return phieumuondao.getAll();
    }

    // Thêm phiếu mượn mới
    public boolean addPhieuMuon(PhieuMuonDTO phieumuon) {
        return phieumuondao.insert(phieumuon);
    }

    // Cập nhật phiếu mượn
    public boolean updatePhieuMuon(PhieuMuonDTO phieumuon) {
        return phieumuondao.update(phieumuon);
    }

    // Xóa phiếu mượn
    public boolean deletePhieuMuon(int maPhieuMuon) {
        return phieumuondao.delete(maPhieuMuon);
    }

    // Tìm kiếm phiếu mượn theo mã
    public PhieuMuonDTO getPhieuMuonById(int maPhieuMuon) {
        return phieumuondao.getById(maPhieuMuon);
    }

    public static PhieuMuonBUS iBus = null;

    public static PhieuMuonBUS gI() {
        if (iBus == null) {
            iBus = new PhieuMuonBUS();
        }
        return iBus;
    }
}