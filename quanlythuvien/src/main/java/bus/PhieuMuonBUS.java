package bus;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import dao.ChiTietPhieuMuonDAO;
import dao.PhieuMuonDAO;
import dto.ChiTietPhieuMuonDTO;
import dto.PhieuMuonDTO;

public class PhieuMuonBUS {
    private PhieuMuonDAO phieuMuonDAO;
    private ChiTietPhieuMuonDAO chiTietPhieuMuonDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public PhieuMuonBUS(Connection connection) {
        this.phieuMuonDAO = new PhieuMuonDAO(connection);
        this.chiTietPhieuMuonDAO = new ChiTietPhieuMuonDAO(connection);
    }

    // Lấy danh sách tất cả phiếu mượn
    public List<PhieuMuonDTO> getAllPhieuMuon() {
        return phieuMuonDAO.getAllPhieuMuon();
    }

    // Tìm phiếu mượn theo mã
    public PhieuMuonDTO findPhieuMuonById(int maPM) {
        if (maPM > 0) {
            return phieuMuonDAO.findPhieuMuonById(maPM);
        }
        System.err.println("Mã phiếu mượn không hợp lệ!");
        return null;
    }

    // Tìm phiếu mượn theo mã độc giả
    public List<PhieuMuonDTO> findPhieuMuonByDocGiaId(int maDocGia) {
        if (maDocGia > 0) {
            return (List<PhieuMuonDTO>) phieuMuonDAO.findPhieuMuonById(maDocGia);
        }
        System.err.println("Mã độc giả không hợp lệ!");
        return null;
    }

    // Thêm phiếu mượn mới và các chi tiết mượn
    public boolean addPhieuMuon(PhieuMuonDTO phieuMuon, List<ChiTietPhieuMuonDTO> danhSachChiTiet) {
        if (validatePhieuMuon(phieuMuon)) {
            boolean phieuMuonAdded = phieuMuonDAO.savePhieuMuon(phieuMuon);
            if (phieuMuonAdded && phieuMuon.getMaPM() > 0 && danhSachChiTiet != null && !danhSachChiTiet.isEmpty()) {
                for (ChiTietPhieuMuonDTO chiTiet : danhSachChiTiet) {
                    chiTiet.setMaPhieuMuon(phieuMuon.getMaPM());
                    if (!chiTietPhieuMuonDAO.saveChiTietPhieuMuon(chiTiet)) {
                        System.err.println("Lỗi khi thêm chi tiết phiếu mượn cho mã sách: " + chiTiet.getMaSach());
                        // Có thể cần rollback phiếu mượn đã thêm nếu thêm chi tiết thất bại
                        return false;
                    }
                }
                return true;
            } else if (phieuMuonAdded) {
                return true; // Phiếu mượn không có chi tiết nào
            } else {
                System.err.println("Lỗi khi thêm phiếu mượn!");
                return false;
            }
        }
        System.err.println("Dữ liệu phiếu mượn không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin phiếu mượn
    public boolean updatePhieuMuon(PhieuMuonDTO phieuMuon) {
        if (validatePhieuMuon(phieuMuon) && phieuMuon.getMaPM() > 0) {
            return phieuMuonDAO.updatePhieuMuon(phieuMuon);
        }
        System.err.println("Dữ liệu phiếu mượn không hợp lệ hoặc mã phiếu mượn không tồn tại!");
        return false;
    }

    // Xóa phiếu mượn và các chi tiết liên quan
    public boolean deletePhieuMuon(int maPM) {
        if (maPM > 0) {
            // Xóa các chi tiết phiếu mượn trước
            List<ChiTietPhieuMuonDTO> danhSachChiTiet = chiTietPhieuMuonDAO.getChiTietPhieuMuonByMaPhieuMuon(maPM);
            for (ChiTietPhieuMuonDTO chiTiet : danhSachChiTiet) {
                if (!chiTietPhieuMuonDAO.deleteChiTietPhieuMuon(chiTiet.getMaPhieuMuon(), chiTiet.getMaSach())) {
                    System.err.println("Lỗi khi xóa chi tiết phiếu mượn cho mã sách: " + chiTiet.getMaSach());
                    return false; // Không xóa được hết chi tiết
                }
            }
            // Sau đó xóa phiếu mượn chính
            return phieuMuonDAO.deletePhieuMuon(maPM);
        }
        System.err.println("Mã phiếu mượn không hợp lệ!");
        return false;
    }

    // Lấy danh sách chi tiết phiếu mượn theo mã phiếu mượn
    public List<ChiTietPhieuMuonDTO> getChiTietPhieuMuonByMaPhieuMuon(int maPM) {
        if (maPM > 0) {
            return chiTietPhieuMuonDAO.getChiTietPhieuMuonByMaPhieuMuon(maPM);
        }
        System.err.println("Mã phiếu mượn không hợp lệ!");
        return null;
    }

    // Thêm chi tiết phiếu mượn vào phiếu mượn đã tồn tại
    public boolean addChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        if (chiTiet.getMaPhieuMuon() > 0 && chiTiet.getMaSach() > 0) {
            return chiTietPhieuMuonDAO.saveChiTietPhieuMuon(chiTiet);
        }
        System.err.println("Mã phiếu mượn hoặc mã sách không hợp lệ cho chi tiết phiếu mượn!");
        return false;
    }

    // Cập nhật chi tiết phiếu mượn
    public boolean updateChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        if (chiTiet.getMaPhieuMuon() > 0 && chiTiet.getMaSach() > 0) {
            return chiTietPhieuMuonDAO.updateChiTietPhieuMuon(chiTiet);
        }
        System.err.println("Mã phiếu mượn hoặc mã sách không hợp lệ cho chi tiết phiếu mượn!");
        return false;
    }

    // Xóa chi tiết phiếu mượn
    public boolean deleteChiTietPhieuMuon(int maPhieuMuon, int maSach) {
        if (maPhieuMuon > 0 && maSach > 0) {
            return chiTietPhieuMuonDAO.deleteChiTietPhieuMuon(maPhieuMuon, maSach);
        }
        System.err.println("Mã phiếu mượn hoặc mã sách không hợp lệ để xóa chi tiết!");
        return false;
    }

    // Kiểm tra tính hợp lệ của dữ liệu phiếu mượn
    private boolean validatePhieuMuon(PhieuMuonDTO phieuMuon) {
        if (phieuMuon == null) {
            return false;
        }
        if (phieuMuon.getMaNV() <= 0 || phieuMuon.getMaDocGia() <= 0) {
            return false;
        }
        if (phieuMuon.getNgayMuon() == null || phieuMuon.getNgayMuon().after(new Date())) {
            return false; // Ngày mượn không hợp lệ (null hoặc sau ngày hiện tại)
        }
        if (phieuMuon.getTinhTrang() == null || (!phieuMuon.getTinhTrang().equals("Mượn") && !phieuMuon.getTinhTrang().equals("Đã Trả"))) {
            return false; // Tình trạng không hợp lệ
        }
        return true;
    }
}