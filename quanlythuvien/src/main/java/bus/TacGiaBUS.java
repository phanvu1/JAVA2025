package bus;

import java.sql.Connection;
import java.util.List;

import dao.TacGiaDAO;
import dto.TacGiaDTO;

public class TacGiaBUS {
    private TacGiaDAO tacGiaDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public TacGiaBUS(Connection connection) {
        this.tacGiaDAO = new TacGiaDAO(connection);
    }

    // Thêm tác giả mới
    public boolean themTacGia(TacGiaDTO tacGia) {
        if (tacGia.getTenTacGia() == null || tacGia.getTenTacGia().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tác giả không được để trống");
        }
        if (tacGia.getNamSinh() <= 0) {
            throw new IllegalArgumentException("Năm sinh không hợp lệ");
        }
        if (tacGia.getQueQuan() == null || tacGia.getQueQuan().trim().isEmpty()) {
            throw new IllegalArgumentException("Quê quán không được để trống");
        }
        return tacGiaDAO.saveTacGia(tacGia);
    }

    // Cập nhật thông tin tác giả
    public boolean suaTacGia(TacGiaDTO tacGia) {
        if (tacGia.getMaTacGia() <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return themTacGia(tacGia); // Tái sử dụng logic kiểm tra từ phương thức thêm
    }

    // Xóa tác giả theo mã tác giả
    public boolean xoaTacGia(int maTacGia) {
        if (maTacGia <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return tacGiaDAO.deleteTacGia(maTacGia);
    }

    // Lấy danh sách tất cả tác giả
    public List<TacGiaDTO> getAllTacGia() {
        return tacGiaDAO.getAllTacGia();
    }

    // Tìm tác giả theo mã tác giả
    public TacGiaDTO timTacGiaTheoMa(int maTacGia) {
        if (maTacGia <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return tacGiaDAO.findTacGiaById(maTacGia);
    }

    // Tìm tác giả theo tên
    public List<TacGiaDTO> timTacGiaTheoTen(String tenTacGia) {
        if (tenTacGia == null || tenTacGia.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tác giả không được để trống");
        }
        return tacGiaDAO.findTacGiaByName(tenTacGia);
    }
}