package bus;

import java.sql.Connection;
import java.util.List;

import dao.SachDAO;
import dto.SachDTO;

public class SachBUS {
    private SachDAO sachDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public SachBUS(Connection connection) {
        this.sachDAO = new SachDAO(connection);
    }

    // Thêm sách mới
    public boolean addSach(SachDTO sach) {
        if (validateSach(sach)) {
            return sachDAO.saveSach(sach);
        }
        System.err.println("Dữ liệu sách không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin sách
    public boolean updateSach(SachDTO sach) {
        if (validateSach(sach) && sach.getMaSach() > 0) {
            return sachDAO.updateSach(sach);
        }
        System.err.println("Dữ liệu sách không hợp lệ hoặc mã sách không tồn tại!");
        return false;
    }

    // Xóa sách theo mã sách
    public boolean deleteSach(int maSach) {
        if (maSach > 0) {
            return sachDAO.deleteSach(maSach);
        }
        System.err.println("Mã sách không hợp lệ!");
        return false;
    }

    // Lấy danh sách tất cả sách
    public List<SachDTO> getAllSach() {
        return sachDAO.getAllSach();
    }

    // Tìm sách theo mã sách
    public SachDTO findSachById(int maSach) {
        if (maSach > 0) {
            return sachDAO.findSachById(maSach);
        }
        System.err.println("Mã sách không hợp lệ!");
        return null;
    }

    // Tìm sách theo tên sách
    public List<SachDTO> findSachByName(String tenSach) {
        if (tenSach != null && !tenSach.trim().isEmpty()) {
            return sachDAO.findSachByName(tenSach);
        }
        System.err.println("Tên sách không hợp lệ!");
        return null;
    }

    // Kiểm tra tính hợp lệ của dữ liệu sách
    private boolean validateSach(SachDTO sach) {
        if (sach == null) {
            return false;
        }
        if (sach.getTenSach() == null || sach.getTenSach().trim().isEmpty()) {
            return false;
        }
        if (sach.getMaLoai() <= 0 || sach.getMaNXB() <= 0 || sach.getMaKeSach() <= 0) {
            return false;
        }
        if (sach.getNamXB() <= 0 || sach.getSoLuong() < 0) {
            return false;
        }
        return true;
    }
}