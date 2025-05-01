package bus;

import java.sql.Connection;
import java.util.List;

import dao.SachDAO;
import dto.SachDTO;

public class SachBUS {

    public static Object gI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private SachDAO sachDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public SachBUS(Connection connection) {
        this.sachDAO = new SachDAO(connection);
    }

    // Thêm sách mới
    public boolean themSach(SachDTO sach) {
        if (sach.getTenSach() == null || sach.getTenSach().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
        if (sach.getMaLoai() <= 0 || sach.getMaNXB() <= 0 || sach.getMaKeSach() <= 0) {
            throw new IllegalArgumentException("Mã loại, mã NXB hoặc mã kệ sách không hợp lệ");
        }
        if (sach.getNamXB() <= 0 || sach.getSoLuong() < 0) {
            throw new IllegalArgumentException("Năm xuất bản hoặc số lượng không hợp lệ");
        }
        return sachDAO.saveSach(sach);
    }

    // Cập nhật thông tin sách
    public boolean suaSach(SachDTO sach) {
        if (sach.getMaSach() <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        return themSach(sach); // Tái sử dụng logic kiểm tra từ phương thức thêm
    }

    // Xóa sách theo mã sách
    public boolean xoaSach(int maSach) {
        if (maSach <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        return sachDAO.deleteSach(maSach);
    }

    // Lấy danh sách tất cả sách
    public List<SachDTO> getAllSach() {
        return sachDAO.getAllSach();
    }

    // Tìm sách theo mã sách
    public SachDTO timSachTheoMa(int maSach) {
        if (maSach <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        return sachDAO.findSachById(maSach);
    }

    // Tìm sách theo tên sách
    public List<SachDTO> timSachTheoTen(String tenSach) {
        if (tenSach == null || tenSach.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
        return sachDAO.findSachByName(tenSach);
    }

    public boolean updateSach(SachDTO sach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteSach(int masach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addSach(SachDTO sach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}