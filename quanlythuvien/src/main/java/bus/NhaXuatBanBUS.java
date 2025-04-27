package bus;

import java.sql.*;
import java.util.List;

import dao.NhaXuatBanDAO;
import dto.NhaXuatBanDTO;

public class NhaXuatBanBUS {
    private NhaXuatBanDAO nhaXuatBanDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public NhaXuatBanBUS(Connection connection) {
        this.nhaXuatBanDAO = new NhaXuatBanDAO(connection);
    }

    // Lấy danh sách tất cả nhà xuất bản
    public List<NhaXuatBanDTO> getAllNhaXuatBan() {
        return nhaXuatBanDAO.getAllNhaXuatBan();
    }

    // Tìm nhà xuất bản theo mã
    public NhaXuatBanDTO findNhaXuatBanById(int maNXB) {
        if (maNXB > 0) {
            return nhaXuatBanDAO.findNhaXuatBanById(maNXB);
        }
        System.err.println("Mã nhà xuất bản không hợp lệ!");
        return null;
    }

    // Tìm nhà xuất bản theo tên
    public List<NhaXuatBanDTO> findNhaXuatBanByName(String tenNXB) {
        if (tenNXB != null && !tenNXB.trim().isEmpty()) {
            return nhaXuatBanDAO.findNhaXuatBanByName(tenNXB);
        }
        System.err.println("Tên nhà xuất bản không hợp lệ!");
        return null;
    }

    // Thêm nhà xuất bản mới
    public boolean addNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        if (validateNhaXuatBan(nhaXuatBan)) {
            return nhaXuatBanDAO.saveNhaXuatBan(nhaXuatBan);
        }
        System.err.println("Dữ liệu nhà xuất bản không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin nhà xuất bản
    public boolean updateNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        if (validateNhaXuatBan(nhaXuatBan) && nhaXuatBan.getMaNXB() > 0) {
            return nhaXuatBanDAO.updateNhaXuatBan(nhaXuatBan);
        }
        System.err.println("Dữ liệu nhà xuất bản không hợp lệ hoặc mã nhà xuất bản không tồn tại!");
        return false;
    }

    // Xóa nhà xuất bản theo mã
    public boolean deleteNhaXuatBan(int maNXB) {
        if (maNXB > 0) {
            // Có thể thêm kiểm tra nghiệp vụ ở đây, ví dụ: kiểm tra xem có sách nào thuộc NXB này không trước khi xóa
            return nhaXuatBanDAO.deleteNhaXuatBan(maNXB);
        }
        System.err.println("Mã nhà xuất bản không hợp lệ!");
        return false;
    }

    // Kiểm tra tính hợp lệ của dữ liệu nhà xuất bản
    private boolean validateNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        if (nhaXuatBan == null) {
            return false;
        }
        if (nhaXuatBan.getTenNXB() == null || nhaXuatBan.getTenNXB().trim().isEmpty()) {
            return false;
        }
        if (nhaXuatBan.getDiaChi() == null || nhaXuatBan.getDiaChi().trim().isEmpty()) {
            return false;
        }
        if (nhaXuatBan.getSDT() == null || nhaXuatBan.getSDT().trim().isEmpty()) {
            return false;
        }
        // Có thể thêm các kiểm tra định dạng khác cho địa chỉ và số điện thoại nếu cần
        return true;
    }
}